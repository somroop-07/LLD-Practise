package concurrencyLLD.job_scheduler.entitites;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class JobScheduler implements JobExectuorResult{
	
    DelayQueue<Job> scheduledJobs = new DelayQueue<>();
    PriorityBlockingQueue<Job> readyQueue = new PriorityBlockingQueue<>(100,new JobComparator());
    ConcurrentHashMap<String, Job> jobRepo = new ConcurrentHashMap<>();
    ConcurrentLinkedQueue<Job> deadLetterQueue = new ConcurrentLinkedQueue<>();
    Thread schedulerThread;
    ExecutorService workerPool;
    
    
    int workerCount;
       
    public JobScheduler(int workerCount) {
		super();
		this.workerCount = workerCount;
	}

	public void start() {
    	schedulerThread = new Thread(new SchedulerThread(scheduledJobs, readyQueue));
    	schedulerThread.start();

    	startWorkerPool(workerCount);
    }
	
	public void stop() {
		schedulerThread.interrupt();
		workerPool.shutdownNow();
		
	}
    
    public void startWorkerPool(int workerCount) {
    	  workerPool = Executors.newFixedThreadPool(workerCount);
    	  for(int i = 0; i < workerCount; i++)
    	  workerPool.submit(new Worker(readyQueue, this));
    	  
    	  //If no priority required, workers consume directly from DelayQueue
//    	  for(int i = 0; i < workerCount; i++) {
//    		  workerPool.submit(() -> {
//    			  while(!Thread.currentThread().isInterrupted()) {
//    			 try {
//    			  Job job = scheduledJobs.take();
//    			  if(job.getStatus().equals(JobStatus.CANCELLED)) {
//    					continue;
//    			   }
//    			  try {
//					job.getTask().execute();
//					onSuccess(job);
//				} catch (Exception e) {
//					onFailure(job);
//				}
//    			 }catch (InterruptedException e) {
//					Thread.currentThread().interrupt();
//					break;
//				}
//    			  }	  
//    		  });
//    	  }
    	}
    
    public void scheduleJob(Job job) {
    	 jobRepo.put(job.getJobId(), job);
    	 scheduledJobs.offer(job);
    }

	@Override
	public void onSuccess(Job job) {
		if(job.isRecurring()) {
			job.setStatus(JobStatus.SCHEDULED);
			job.setScheduledTime(job.getScheduledTime().plus(job.getRecurringDuration()));
			scheduleJob(job);
		}
		else {
		job.setStatus(JobStatus.COMPLETED);
		}
	}

	@Override
	public void onFailure(Job job) {
		if(job.getRetryCount() < job.getRetryAttempt()) {
			job.setStatus(JobStatus.SCHEDULED);
			job.incrementRetryCount();
			job.setScheduledTime(LocalDateTime.now().plus(Duration.ofSeconds((long) Math.pow(2, job.getRetryCount()))));
			scheduleJob(job);
		}
		else {
			job.setStatus(JobStatus.FAILED);
			deadLetterQueue.add(job);
		}
		
	}
    public JobStatus getJobStatus(Job job) {
    	if(jobRepo.containsKey(job.getJobId())) {
    		return jobRepo.get(job.getJobId()).getStatus();
    	}
    	else {
    		throw new IllegalArgumentException("Job doesn't exist");
    	}
    }
    
    public void cancelJob(Job job) {
    	if(jobRepo.containsKey(job.getJobId())) {
    	   jobRepo.get(job.getJobId()).setStatus(JobStatus.CANCELLED);
    	}
    	else {
    		throw new IllegalArgumentException("Job doesn't exist");
    	}
    }
	 
}

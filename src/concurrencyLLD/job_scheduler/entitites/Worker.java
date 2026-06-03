package concurrencyLLD.job_scheduler.entitites;

import java.util.concurrent.PriorityBlockingQueue;

public class Worker implements Runnable {

	PriorityBlockingQueue<Job> readyQueue;
	JobExectuorResult jobExectuorResult;
	
	
	
	public Worker(PriorityBlockingQueue<Job> readyQueue, JobExectuorResult jobExectuorResult) {
		super();
		this.readyQueue = readyQueue;
		this.jobExectuorResult = jobExectuorResult;
	}


   //take blocks the thread if queue empty. else wakes up, exactly what we want
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
		     try {
				Job job = readyQueue.take();
				if(job != null) {
					if(job.getStatus().equals(JobStatus.CANCELLED)) {
						continue;
					}
					job.setStatus(JobStatus.RUNNING);
					execute(job);
				}
			 } catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
				 break;
			 }
		}
		
	}
	
	public void execute(Job job) {
		try {
			job.getTask().execute();
			jobExectuorResult.onSuccess(job);
			
		} catch (Exception e) {
			jobExectuorResult.onFailure(job);
		}
		
	}

}

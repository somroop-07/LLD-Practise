package concurrencyLLD.job_scheduler.entitites;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class SchedulerThread implements Runnable {

	DelayQueue<Job> scheduledJobs;
	PriorityBlockingQueue<Job> readyQueue;

	
	
	public SchedulerThread(DelayQueue<Job> scheduledJobs, PriorityBlockingQueue<Job> readyQueue) {
		super();
		this.scheduledJobs = scheduledJobs;
		this.readyQueue = readyQueue;
	}

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
		try {
			Job job = scheduledJobs.take();
			if(job.getStatus().equals(JobStatus.CANCELLED)) {
				continue;
			}
			readyQueue.offer(job);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			break;
		}
		
		}
	}

}

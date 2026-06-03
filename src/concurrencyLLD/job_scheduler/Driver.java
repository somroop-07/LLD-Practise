package concurrencyLLD.job_scheduler;

import java.time.Duration;
import java.time.LocalDateTime;

import concurrencyLLD.job_scheduler.entitites.ConcreteTask;
import concurrencyLLD.job_scheduler.entitites.Job;
import concurrencyLLD.job_scheduler.entitites.JobPriority;
import concurrencyLLD.job_scheduler.entitites.JobScheduler;

//A scheduler should support: Submit jobs/tasks, 
//Execute jobs at scheduled time,
//Support: one-time jobs, recurring jobs, 
//Track job status, Retry failed jobs, 
//Cancel jobs, 
//Multiple worker threads, 
//Priority handling 
public class Driver {
       
	public static void main(String[] args) throws InterruptedException {
		 Job job1 = new Job(new ConcreteTask("Task 1"), 3, 
				 LocalDateTime.now().plusSeconds(5),JobPriority._2, true, 
				 Duration.ofSeconds(5));
		 Job job2 = new Job(new ConcreteTask("Task 2"), 3, 
				 LocalDateTime.now().plusSeconds(3),JobPriority._3, false, 
				 null);
		 Job job3 = new Job(new ConcreteTask("Task 3"), 3, 
				 LocalDateTime.now().plusSeconds(5),JobPriority._1, false, 
				 null);
		 
		 JobScheduler jobScheduler = new JobScheduler(3);
		 
		 jobScheduler.scheduleJob(job1);
		 jobScheduler.scheduleJob(job2);
		 jobScheduler.scheduleJob(job3);
		 
		 jobScheduler.start();

		 Thread.sleep(10000);

		 jobScheduler.stop();
	}
}

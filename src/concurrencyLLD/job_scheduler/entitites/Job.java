package concurrencyLLD.job_scheduler.entitites;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

//Required for DelayQueue
public class Job implements Delayed{
	
    private String jobId;
    private Task task;
    private int retryCount;
    private int retryAttempt;
    private JobStatus status;
    private LocalDateTime scheduledTime;
    private JobPriority priority;
    private boolean isRecurring;
    private Duration recurringDuration;
    
	public Job(Task task, int retryAttempt, LocalDateTime scheduledTime, JobPriority priority, boolean isRecurring,
			Duration recurringDuration) {
		super();
		this.jobId = UUID.randomUUID().toString();
		this.task = task;
		this.retryAttempt = retryAttempt;
		this.retryCount = 0;
		this.status = JobStatus.SCHEDULED;
		this.scheduledTime = scheduledTime;
		this.priority = priority;
		this.isRecurring = isRecurring;
		this.recurringDuration = recurringDuration;
	}

	public String getJobId() {
		return jobId;
	}

	public Task getTask() {
		return task;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public int getRetryAttempt() {
		return retryAttempt;
	}

	public JobStatus getStatus() {
		return status;
	}

	public LocalDateTime getScheduledTime() {
		return scheduledTime;
	}

	public JobPriority getPriority() {
		return priority;
	}

	public boolean isRecurring() {
		return isRecurring;
	}

	public Duration getRecurringDuration() {
		return recurringDuration;
	}

	public void setStatus(JobStatus status) {
		this.status = status;
	}

	public void setScheduledTime(LocalDateTime scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
    public void incrementRetryCount() {
    	this.retryCount++;
    }
    
	@Override
	public int compareTo(Delayed o) {
		return Long.compare(this.getDelay(TimeUnit.MILLISECONDS),o.getDelay(TimeUnit.MILLISECONDS));
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long delay = Duration.between(LocalDateTime.now(), scheduledTime).toMillis();
		return unit.convert(delay, TimeUnit.MILLISECONDS);
	}
  
    
}

package concurrencyLLD.job_scheduler.entitites;

public interface JobExectuorResult {
    public void onSuccess(Job job);
    public void onFailure(Job job);
    
}

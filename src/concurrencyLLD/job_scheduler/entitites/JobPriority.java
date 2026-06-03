package concurrencyLLD.job_scheduler.entitites;

public enum JobPriority {
    _1(1), _2(2), _3(3);
	
	private int val;
	private JobPriority(int val) {
		this.val = val;
	}
	
	public int getPriority() {
		return this.val;
	}
}

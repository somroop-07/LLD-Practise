package concurrencyLLD.job_scheduler.entitites;

import java.util.Comparator;

public class JobComparator implements Comparator<Job> {

	@Override
	public int compare(Job o1, Job o2) {
		return Integer.compare(o2.getPriority().getPriority(), o1.getPriority().getPriority());
    
}
}

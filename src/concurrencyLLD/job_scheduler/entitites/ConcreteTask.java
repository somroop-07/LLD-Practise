package concurrencyLLD.job_scheduler.entitites;

public class ConcreteTask implements Task{

	String content;
	
	public ConcreteTask(String content) {
		super();
		this.content = content;
	}

	@Override
	public void execute() {
		System.out.println("Executing Task -> " + content);
		
	}

}

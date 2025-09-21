package decorator_pattern;

public class BasePizza implements Pizza {

	
	@Override
	public String getDesc() {
		return "Basic Pizza";
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return 300.0;
	}

}

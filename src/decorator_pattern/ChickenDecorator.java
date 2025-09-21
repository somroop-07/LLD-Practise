package decorator_pattern;

public class ChickenDecorator extends PizzaDecorator {

	ChickenDecorator(Pizza decoratedPizza) {
		super(decoratedPizza);
		// TODO Auto-generated constructor stub
	}
	public String getDesc() {
		// TODO Auto-generated method stub
		return decoratedPizza.getDesc() + "+ Chicken";
	}

	public double getCost() {
		// TODO Auto-generated method stub
		return decoratedPizza.getCost() + 200.0;
	}

}

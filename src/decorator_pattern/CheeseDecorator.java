package decorator_pattern;

public class CheeseDecorator extends PizzaDecorator{

	CheeseDecorator(Pizza decoratedPizza) {
		super(decoratedPizza);
		// TODO Auto-generated constructor stub
	}
	
	public String getDesc() {
		// TODO Auto-generated method stub
		return decoratedPizza.getDesc() + "+ Cheese";
	}

	public double getCost() {
		// TODO Auto-generated method stub
		return decoratedPizza.getCost() + 100.0;
	}

}

package decorator_pattern;

public class PizzaDecorator implements Pizza{
	
	Pizza decoratedPizza;
	
	PizzaDecorator(Pizza decoratedPizza){
		this.decoratedPizza = decoratedPizza;
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return decoratedPizza.getDesc();
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return decoratedPizza.getCost();
	}

}

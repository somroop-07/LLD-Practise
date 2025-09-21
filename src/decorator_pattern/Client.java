package decorator_pattern;

public class Client {
      public static void main(String[] args) {
    	  Pizza pizza = new BasePizza();
    	  pizza = new ChickenDecorator(pizza);
    	  pizza = new CheeseDecorator(pizza);
    	  System.out.println(pizza.getDesc());
    	  System.out.println(pizza.getCost());
      }
}

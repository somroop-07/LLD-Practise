package ShippingModel.java;

public class PriorityDeliveryDecorator extends ShippingDecorator{
   
	int surge = 1;
	 public PriorityDeliveryDecorator(Shipping baseShipping, int surge) {
		super(baseShipping);
		this.surge = surge;
		// TODO Auto-generated constructor stub
	}
	 @Override
	 public double calculateCost() {
		return baseShipping.calculateCost() * surge;
	 }
	 @Override
	 public String getId() {
		return baseShipping.getId();
	 }

	 
	 
	 
}

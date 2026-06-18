package ShippingModel.java;

public abstract class ShippingDecorator implements Shipping {

	Shipping baseShipping;

	public ShippingDecorator(Shipping baseShipping) {
		this.baseShipping = baseShipping;
	}

	
}

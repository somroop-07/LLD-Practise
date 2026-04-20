package ShoppingCartAddCoupon_LLD;

public class CouponDecorator extends Product{
  
	Product product;
	double discountPercentage;
	
	@Override
	public double getPrice() {
	    return product.getPrice();
	}
	
	@Override
	public String getName() {
	    return product.getName();
	}
	@Override
	public ProductType getType() {
	    return product.getType();
	}


}

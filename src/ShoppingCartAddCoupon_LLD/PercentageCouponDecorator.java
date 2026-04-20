package ShoppingCartAddCoupon_LLD;

public class PercentageCouponDecorator extends CouponDecorator{
	
	public PercentageCouponDecorator(Product product, double percentage) {
		this.product = product;
		this.discountPercentage = percentage;
	}
	
	public double getPrice() {
		double price = product.getPrice();
		return price - price * (discountPercentage) / 100 ;
	}
}

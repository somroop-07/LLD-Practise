package ShoppingCartAddCoupon_LLD;

import java.util.Arrays;
import java.util.List;

public class TypeCouponDecorator extends CouponDecorator{
	
	static List<ProductType> couponList;
	
	static {
		couponList = Arrays.asList(ProductType.ELECTRONICS, ProductType.FOODANDBEVERAGES);
	}
	
	public TypeCouponDecorator(Product product, double percentage) {
		this.product = product;
		this.discountPercentage = percentage;
	}
	
	public double getPrice() {
		double price = product.getPrice();
		ProductType type = product.getType();
		if(couponList.contains(type)) {
		return price - price * (discountPercentage) / 100 ;
		}
		return price;
	}
}
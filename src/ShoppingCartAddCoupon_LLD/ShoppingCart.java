package ShoppingCartAddCoupon_LLD;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Product> productList;
    
    public ShoppingCart() {
		this.productList = new ArrayList<>();
	}
    
    public void addToCart(Product product) {
    	Product discountedProduct = new TypeCouponDecorator(new PercentageCouponDecorator(product, 10) , 15);
    	productList.add(discountedProduct);
    }
    public double getTotalCartValue() {
    	int totalCost = 0;
    	for(Product product : productList) {
    		totalCost += product.getPrice();
    	}
    	return totalCost;
    }
 }

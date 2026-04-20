package ShoppingCartAddCoupon_LLD;

public abstract class Product {
	String id;
    String name;
    double originalPrice;
    ProductType productType;
	
    public abstract double getPrice();
    
    public ProductType getType() {
    	return this.productType;
    }
    public String getName() {
    	return this.name;
    }
}

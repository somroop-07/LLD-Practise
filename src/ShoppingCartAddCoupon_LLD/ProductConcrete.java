package ShoppingCartAddCoupon_LLD;

public class ProductConcrete extends Product{
   
	public ProductConcrete(String id, String name, double price, ProductType productType) {
	    this.id = id;
	    this.name = name;
	    this.originalPrice = price;
	    this.productType = productType;
	}
	
	@Override
	public double getPrice() {
		return this.originalPrice;
		
	}
}

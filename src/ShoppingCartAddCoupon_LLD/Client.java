package ShoppingCartAddCoupon_LLD;

public class Client {
     public static void main(String[] args) {
		Product product1 = new ProductConcrete("1", "Mobile", 100000, ProductType.ELECTRONICS);
		Product product2 = new ProductConcrete("2", "Chair", 8000, ProductType.FURNITURE);
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addToCart(product1);
		shoppingCart.addToCart(product2);
		System.out.println("Total value of cart: " + shoppingCart.getTotalCartValue());
	}
}

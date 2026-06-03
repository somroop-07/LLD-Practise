package amazon_review_system.entities;

import java.util.HashMap;
import java.util.Map;

public class ProductManager implements ProductRepo{
   Map<String, Product> productList;
   private static volatile ProductManager productManagerInstance;
   
   private ProductManager() {
	   productList = new HashMap<>();
   }
   
   public static ProductManager getInstance() {
	   if(productManagerInstance == null) {
	   synchronized (ProductManager.class) {
		   if(productManagerInstance == null) {
			   productManagerInstance = new ProductManager();
		   }
       	}
	   }
	   return productManagerInstance;
   }
   
   public void addProduct(Product product) {
	   productList.put(product.getProductId(), product);
   }
   
   public Product getProduct(String productId) {
	   return productList.getOrDefault(productId, null);
   }
	
}

package amazon_review_system;

import amazon_review_system.entities.Product;
import amazon_review_system.entities.ProductManager;
import amazon_review_system.entities.ProductRepo;
import amazon_review_system.entities.Review;

public class ReviewService {
	
	 ProductRepo productManager;

	 public ReviewService(ProductManager productManager) {
		super();
		this.productManager = productManager;
	 }
	 
	 public void addReview(String productId, Review review) throws Exception {
		 Product product = productManager.getProduct(productId);
		 if(product ==  null) {
			 throw new Exception("Product doesn't exist");
		 }
		 else {
			 product.addReview(review.getUserId(), review);
		 }
	 }

}

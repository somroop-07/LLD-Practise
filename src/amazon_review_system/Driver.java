package amazon_review_system;

import java.util.Map;

import amazon_review_system.entities.Product;
import amazon_review_system.entities.ProductManager;
import amazon_review_system.entities.Rating;
import amazon_review_system.entities.Review;
import amazon_review_system.entities.User;

public class Driver {
  public static void main(String[] args) throws Exception {
	ProductManager productManager = ProductManager.getInstance();
	Product product1 = new Product("p1");
	User user1 = new User("u1", "avvffvv");
	User user2 = new User("u2", "grgtg");
	User user3 = new User("u3", "hujuj");
	User user4 = new User("u4", "fddfg");
	User user5 = new User("u5", "yjytht");
	
	productManager.addProduct(product1);
	ReviewService reviewService = new ReviewService(productManager);
	
	reviewService.addReview("p1", new Review("Good ", "u1", Rating._4));
	reviewService.addReview("p1", new Review("Wow product", "u3", Rating._5));
	reviewService.addReview("p1", new Review("Avg product", "u4", Rating._3));
	reviewService.addReview("p1", new Review("Avg product", "u5", Rating._3));
	
	
	System.out.println(product1.getAverageRating());
	Map<String, Review> reviews = product1.getReviewList();
 	for(Review review : reviews.values()) {
 		System.out.println(review.getUserId());
 		System.out.println(review.getContent());
 	}
}
}

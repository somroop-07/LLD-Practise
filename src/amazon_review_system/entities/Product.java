package amazon_review_system.entities;

import java.util.HashMap;
import java.util.Map;

public  class Product {
	
	String productId;
    double averageRating;
    Map<String, Review> reviewList;
    int totalRating;
    
    public Product(String productId) {
		super();
		this.productId = productId;
		this.averageRating = 0;
		this.totalRating = 0;
		this.reviewList = new HashMap<>();
	}
    
	public String getProductId() {
		return productId;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public Map<String, Review> getReviewList() {
		return reviewList;
	}
	

	public void addReview(String userId, Review review) {
		
		if(reviewList.containsKey(userId)) {
			totalRating -= reviewList.get(userId).getRating().getVal();
		}
		reviewList.put(userId, review);
		totalRating += review.getRating().getVal();
		averageRating = (double)totalRating / (reviewList.size());
    }
	
    
}

package amazon_review_system.entities;

public class Review {
    String content;
    String userId;
    Rating rating;
    
	public Review(String content, String userId, Rating rating) {
		super();
		this.content = content;
		this.userId = userId;
		this.rating = rating;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
    
    
    
}

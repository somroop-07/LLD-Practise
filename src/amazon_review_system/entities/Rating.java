package amazon_review_system.entities;

public enum Rating {
    _1(1), _2(2), _3(3), _4(4), _5(5);
	
	private final int val;
	
	Rating(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return this.val;
	}
}

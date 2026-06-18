package ShippingModel.java;

public enum ShippingPriority {

	 HIGH(5), MEDIUM(3), LOW(1);
	
	private int surge;
	
	private ShippingPriority(int surge) {
		this.surge = surge;
	}
	public int getSurge() {
		return surge;
	}
}

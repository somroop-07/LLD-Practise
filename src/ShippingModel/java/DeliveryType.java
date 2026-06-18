package ShippingModel.java;

public enum DeliveryType {
    STANDARD(1), FAST(3), EXPRESS(5);
	
	private int surge;
	
	private DeliveryType(int surge) {
		this.surge = surge;
	}
	public int getSurge() {
		return surge;
	}
	
}

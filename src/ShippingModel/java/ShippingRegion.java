package ShippingModel.java;

public enum ShippingRegion {

	  METRO(1), NON_METRO(5);
	
		private int surge;
		
		private ShippingRegion(int surge) {
			this.surge = surge;
		}
		public int getSurge() {
			return surge;
		}
}

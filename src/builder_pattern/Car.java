package builder_pattern;

public class Car {
    private String modelName;
    private String modelColor;
    private String engineNumber;
    private boolean hasRoofShield;
    private boolean hasBackupCameras;
    private boolean hasAirBags;
    
    private Car(CarBuilder builder) {
    	this.modelName = builder.modelName;
    	this.modelColor = builder.modelColor;
    	this.engineNumber = builder.engineNumber;
    	this.hasRoofShield = builder.hasRoofShield;
    	this.hasBackupCameras = builder.hasBackupCameras;
    	this.hasAirBags = builder.hasAirBags;
    }

	@Override
	public String toString() {
		return "Car [modelName=" + modelName + ", modelColor=" + modelColor + ", engineNumber=" + engineNumber
				+ ", hasRoofShield=" + hasRoofShield + ", hasBackupCameras=" + hasBackupCameras + ", hasAirBags="
				+ hasAirBags + "]";
	}
    
	public static class CarBuilder {
		private String modelName;
	    private String modelColor;
	    private String engineNumber;
	    private boolean hasRoofShield;
	    private boolean hasBackupCameras;
	    private boolean hasAirBags;
	    
	    public CarBuilder(String modelName, String modelColor, String engineNumber) {
	    	this.modelName = modelName;
	    	this.modelColor = modelColor;
	    	this.engineNumber = engineNumber;
	    }
	    public CarBuilder setHasRoofShield(boolean hasRoofShield) {
	    	this.hasRoofShield = hasRoofShield;
	    	return this;
	    }
        public CarBuilder setHasBackupCameras(boolean hasBackupCameras) {
        	this.hasBackupCameras = hasBackupCameras;
        	return this;
	    }
       public CarBuilder setHasAirBags(boolean hasAirBags) {
    	   this.hasAirBags = hasAirBags;
    	   return this;
        }
       public Car build() {
    	   return new Car(this);
       }
	}
}

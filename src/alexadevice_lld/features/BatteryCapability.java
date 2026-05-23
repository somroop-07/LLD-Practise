package alexadevice_lld.features;

public class BatteryCapability implements IBatteryCapability{

	int batteryPercentage;

	public BatteryCapability(int batteryPercentage) {
		super();
		this.batteryPercentage = batteryPercentage;
	}

	@Override
	public int getBatteryPercentage() {
		// TODO Auto-generated method stub
		return this.batteryPercentage;
	}

	@Override
	public void setBatteryPercentage(int batteryPercentage) {
		// TODO Auto-generated method stub
		this.batteryPercentage = batteryPercentage;
		
	}
	
	
	
	
}

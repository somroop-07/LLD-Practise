package alexadevice_lld.entitites;

import java.util.UUID;

import alexadevice_lld.enums.DeviceType;
import alexadevice_lld.features.BatteryCapability;

public abstract class AlexaDevice {
     String deviceId;
     DeviceType deviceType;
     boolean isCharging;
     BatteryCapability batteryCapability;
     
	 public AlexaDevice(DeviceType deviceType, boolean isCharging, BatteryCapability batteryCapability) {
		super();
		deviceId = UUID.randomUUID().toString();
		this.deviceType = deviceType;
		this.isCharging = isCharging;
		this.batteryCapability = batteryCapability;
	 }
     
	 public void ChargeDevice() {
		 isCharging = true;
	 }
	 public void removeCharging() {
		 isCharging = false;
	 }
     public boolean isCharging() {
    	 return this.isCharging;
     }
	 
     public String show() {
    	 StringBuilder ssBuilder = new StringBuilder();
    	 if(this.isCharging) {
    		 ssBuilder.append("Charging ");
    	 }
    	 if(batteryCapability != null) {
    		 ssBuilder.append(batteryCapability.getBatteryPercentage());
    	 }
    	 else {
    		 ssBuilder.append("No Battery");
    	 }
    	 return ssBuilder.toString();
     }
     
}

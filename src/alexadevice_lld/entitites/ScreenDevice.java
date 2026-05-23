package alexadevice_lld.entitites;

import alexadevice_lld.enums.DeviceType;
import alexadevice_lld.features.BatteryCapability;

public class ScreenDevice extends AlexaDevice{

	public ScreenDevice(boolean isCharging, BatteryCapability batteryCapability) {
		super(DeviceType.SCREEN, isCharging, batteryCapability);
		// TODO Auto-generated constructor stub
	}

}

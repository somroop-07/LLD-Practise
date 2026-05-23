package alexadevice_lld;

import alexadevice_lld.entitites.AlexaDevice;
import alexadevice_lld.entitites.AudioDevice;
import alexadevice_lld.entitites.ScreenDevice;
import alexadevice_lld.features.BatteryCapability;

/** Consider there are different types of alexa devices available.
One with audio, one with screen, one with audio and screen. 
These devices may have a battery or may not.
Battery devices will have battery percentage. 
Both battery and non battery devices can be put charging. 
The task is to show the battery percentage. 
Include a show method and that method should show the current battery percentage
if it has a battery. If not just say, battery not available. 
You should also say whether its currently charging or not. 
There will four statements to print show method like Charging and battery percentage, 
charging and no battery, just battery percent and no battery.
Expectation is to write interface-driven code using appropriate design patterns (Amazon) **/


public class Driver {
   public static void main(String[] args) throws Exception {
	
	   AlexaDevice device1 = new AudioDevice(true, null);
	   AlexaDevice device2 = new ScreenDevice(true, new BatteryCapability(59));
	   AlexaDevice device3 = new ScreenDevice(false, new BatteryCapability(93));
	   
	   
	   System.out.println(device1.show());
	   System.out.println(device2.show());
	   System.out.println(device3.show());
	   
}
}

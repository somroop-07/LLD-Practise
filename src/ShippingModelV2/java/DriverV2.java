package ShippingModelV2.java;

import java.util.Arrays;

import ShippingModel.java.DeliveryType;
import ShippingModel.java.ShippingPriority;
import ShippingModel.java.ShippingRegion;

public class DriverV2 {
 public static void main(String[] args) {
	ShippingRequest shippingRequest = new ShippingRequest(12, 300, DeliveryType.EXPRESS,
			ShippingPriority.MEDIUM, ShippingRegion.METRO);
	ShippingCalculator calculator = new ShippingCalculator(Arrays.asList(new PriorityRuleEngine(),
			   new RegionRuleEngine(), new DeliveryTypeRuleEngine()));
	System.out.println(calculator.calculateCost(shippingRequest));
}
}

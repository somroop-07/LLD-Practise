package ShippingModelV2.java;

public class DeliveryTypeRuleEngine implements RuleEngine{

	@Override
	public double applyRule(ShippingRequest request, double currCost) {
		return currCost * request.getDeliveryType().getSurge();
	}

}

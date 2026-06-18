package ShippingModelV2.java;

public class PriorityRuleEngine implements RuleEngine{

	@Override
	public double applyRule(ShippingRequest request, double currCost) {
		return currCost * request.getShippingPriority().getSurge();
	}

}

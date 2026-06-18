package ShippingModelV2.java;

public class RegionRuleEngine implements RuleEngine{

	@Override
	public double applyRule(ShippingRequest request, double currCost) {
		return currCost * request.getRegion().getSurge();
	}

}

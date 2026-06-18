package ShippingModelV2.java;

public class BasePriceRuleEngine implements RuleEngine{

	@Override
	public double applyRule(ShippingRequest request, double currCost) {
		return  request.getWeight() * request.getDistance() * 0.5;
	}

}

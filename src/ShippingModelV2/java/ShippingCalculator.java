package ShippingModelV2.java;

import java.util.List;

public class ShippingCalculator {

	List<RuleEngine> ruleEngines;
	BasePriceRuleEngine basePriceRuleEngine = new BasePriceRuleEngine();

	public ShippingCalculator(List<RuleEngine> ruleEngines) {
		super();
		this.ruleEngines = ruleEngines;
	}
	
	public double calculateCost(ShippingRequest request) {
		double cost = basePriceRuleEngine.applyRule(request, 0);
		for(RuleEngine ruleEngine : ruleEngines) {
			cost = ruleEngine.applyRule(request, cost);
		}
		return cost;
	}
}

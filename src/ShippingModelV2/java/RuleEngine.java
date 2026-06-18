package ShippingModelV2.java;

public interface RuleEngine {
    public double applyRule(ShippingRequest request, double currCost);
}

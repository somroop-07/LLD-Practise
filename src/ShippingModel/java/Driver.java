package ShippingModel.java;

//Design a system to calculate shipping costs based on multiple dynamic conditions, 
//including weight, distance, delivery type, priority shipping, 
//region-based pricing, and special handling. (Amazon)
public class Driver {

	public static void main(String[] args) {
		
		ShippingService service = new ShippingService();
		String shippingID = service.addShipping(new RegionBasedDeliveryDecorator(
			new PriorityDeliveryDecorator(new DeliveryTypeDecorator(new BaseShipping(12, 300, 5),
					DeliveryType.EXPRESS), 2)	,ShippingRegion.METRO));
		System.out.println(service.calculateShippingCost(shippingID));
	}
}

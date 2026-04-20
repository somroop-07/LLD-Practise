package pubsub_lld.model;

import pubsub_lld.subscriber.PubSubService;
import pubsub_lld.subscriber.SubscriberConcrete;

public class PubSubDriver {
  public static void main(String[] args) throws Exception {
	
	  PubSubService pubSubService = PubSubService.getInstance();
	  
	  //Creating topics
	  pubSubService.createTopic("Topic 1");
	  pubSubService.createTopic("Topic 2");
	  
	  //Creating subscribers
	  pubSubService.subscribe("Topic 1", new SubscriberConcrete("Sub 22"));
	  //pubSubService.subscribe("Topic 3", new SubscriberConcrete("Sub 42"));
	  pubSubService.subscribe("Topic 2", new SubscriberConcrete("Sub 11"));
	  pubSubService.subscribe("Topic 2", new SubscriberConcrete("Sub 78"));
	  pubSubService.subscribe("Topic 2", new SubscriberConcrete("Sub 98"));
	  pubSubService.subscribe("Topic 1", new SubscriberConcrete("Sub 45"));
	  
	//  pubSubService.publish("Topic 1", new Message("Hello World"));
	  pubSubService.publish("Topic 2", new Message("Hello World"));
	 // pubSubService.publish("Topic 3", new Message("Hello World"));
	  
	  pubSubService.shutdown();
}
}

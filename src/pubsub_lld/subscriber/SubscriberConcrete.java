package pubsub_lld.subscriber;

import pubsub_lld.model.Message;

public class SubscriberConcrete implements Subscriber{

    String id;
    
    
	public SubscriberConcrete(String id) {
		super();
		this.id = id;
	}


	public String getId() {
		return id;
	}


	@Override
	public void onMessage(Message message) {
		System.out.println("Subscriber " + this.id + " has got message - > " + message.getText());		
	}

}

package pubsub_lld.subscriber;

import pubsub_lld.model.Message;

public interface Subscriber {
	public String getId();
    public void onMessage(Message message);
}

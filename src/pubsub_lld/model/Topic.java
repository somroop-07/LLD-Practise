package pubsub_lld.model;


import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;

import pubsub_lld.subscriber.Subscriber;

public class Topic {
	String id;
    String name;
    Set<Subscriber> sub;
    ExecutorService executorService;
	public Topic(String id, String name, ExecutorService executorService) {
		super();
		this.id = id;
		this.name = name;
		this.executorService = executorService;
		this.sub = new CopyOnWriteArraySet<>();
	}
    
    public void addSubscriber(Subscriber subscriber) {
    	sub.add(subscriber);
    }
    
    public void removeSubscriber(Subscriber subscriber) {
    	sub.remove(subscriber);
    }
    
    public void broadcast(Message message) {
    	for(Subscriber subscriber : sub) {
    		executorService.submit(() -> {
    			try {
    			subscriber.onMessage(message);
    			}
    			catch(Exception e) {
    				System.out.println("Unable to deliver message " + message.getText() + " to subscriber " + subscriber.getId());
    			}
    		});
    	}
    }
}

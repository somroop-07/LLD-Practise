package pubsub_lld.subscriber;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import pubsub_lld.model.Message;
import pubsub_lld.model.Topic;

public class PubSubService {

	private static PubSubService pubSubInstance;
	ExecutorService executorService;
	Map<String, Topic> topicMap;
	
	private PubSubService() {
	    executorService = Executors.newCachedThreadPool();
	    topicMap = new ConcurrentHashMap<>();
	}
	
	public static PubSubService  getInstance() {
		if(pubSubInstance == null) {
			pubSubInstance = new PubSubService();
		}
		return pubSubInstance;
	}
	
	public void createTopic(String topicName) throws Exception {
		topicMap.putIfAbsent(topicName, new Topic(UUID.randomUUID().toString(), topicName, executorService));
	}
	
	public void subscribe(String topicName, Subscriber sub) throws Exception {
		if(!topicMap.containsKey(topicName)) {
			throw new Exception("Topic does not exist");
			
		}
		Topic topic = topicMap.get(topicName);
		topic.addSubscriber(sub);
	}
	
	public void unsubscribe(String topicName, Subscriber sub) throws Exception {
		if(!topicMap.containsKey(topicName)) {
			throw new Exception("Topic does not exist");
			
		}
		Topic topic = topicMap.get(topicName);
		topic.removeSubscriber(sub);
	}
	
	public void publish(String topicName, Message message) throws Exception {
		if(!topicMap.containsKey(topicName)) {
			throw new Exception("Topic does not exist");
			
		}
		Topic topic = topicMap.get(topicName);
		topic.broadcast(message);
	}
	
	public void shutdown() {
		//Accepts no new submit tasks but wait for current threads to complete
		executorService.shutdown();
		try {
			//Waits 60 seconds for current threads to complete
			if(!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
				//If execution not completed within 60 secs, force stop
				executorService.shutdownNow();
			}
 		}catch (InterruptedException e) {
 			//If the thread that is waiting got interrupted externally, force stop
			executorService.shutdownNow();
			//Restores the interrupt status of the thread because catching InterruptedException clears it. 
			//This ensures that higher-level code can still detect that the thread was interrupted.
			Thread.currentThread().interrupt();
		}
	}
	
}

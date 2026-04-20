package bridge_pattern;

import java.nio.channels.NonReadableChannelException;

interface BreatheImpl {
	void breathe();
}
class LandBreatheImpl implements BreatheImpl {

	@Override
	public void breathe() {
		System.out.println("Land Breathing Strategy");
	}	
}
class AirBreatheImpl implements BreatheImpl {

	@Override
	public void breathe() {
		System.out.println("Air Breathing Strategy");
	}	
}
abstract class LivingThings {
	BreatheImpl impl;
	
	public LivingThings(BreatheImpl impl) {
		this.impl = impl;
	}
	abstract public void breatheOperation();
}
class Dog extends LivingThings {

	public Dog(BreatheImpl impl) {
		super(impl);
	}

	@Override
	public void breatheOperation() {
		impl.breathe();
	}	
}
class Bird extends LivingThings {

	public Bird(BreatheImpl impl) {
		super(impl);
	}

	@Override
	public void breatheOperation() {
		impl.breathe();
	}	
}
public class Client {
   public static void main(String[] args) {
	  Bird bird = new Bird(new AirBreatheImpl());
	  bird.breatheOperation();
	  Dog dog = new Dog(new LandBreatheImpl());
	  dog.breatheOperation();
	   
}
}

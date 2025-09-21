package state_pattern;

interface ButtonState {
    void click(Button button);
    void render();
}

class EnabledState implements ButtonState {

	@Override
	public void click(Button button) {
		System.out.println("Button clicked");
		button.setState(new PressedState());
		
	}

	@Override
	public void render() {
		System.out.println("Button is enabled. Can be pressed.");
		
	}
	
}

class DisabledState implements ButtonState {

	@Override
	public void click(Button button) {
		System.out.println("Button is disabled. Cannot click.");
		
	}

	@Override
	public void render() {
		System.out.println("Disabled button is greyed out.");
		
	}
	
}

class PressedState implements ButtonState {

	@Override
	public void click(Button button) {
		System.out.println("Button already pressed, wait...");
		button.setState(new EnabledState());
		
	}

	@Override
	public void render() {
		System.out.println("Button is being pressed.");
		
	}
	
}
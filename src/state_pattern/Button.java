package state_pattern;

//Context class
public class Button {
   
	ButtonState state;
	
	Button(ButtonState state) {
		this.state = state;
	}
	
	public void setState(ButtonState state) {
		this.state = state;
	}
	
	public void click() {
		this.state.click(this);
	}
	public void render() {
		this.state.render();
	}
}

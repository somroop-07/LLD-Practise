package command_design_pattern;

import java.util.Stack;
import java.util.spi.AbstractResourceBundleProvider;

//Command Interface
interface Command {
	void execute();
	void undo();
}

class Fan {
	public void on() {
		System.out.println("Fan turned on");
	}
	public void off() {
		System.out.println("Fan turned off");
	}
}
class Light {
	public void on() {
		System.out.println("Light turned on");
	}
	public void off() {
		System.out.println("Light turned off");
	}
}

class FanTurnOnCommand implements Command {
	
	Fan fan;
	public FanTurnOnCommand(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void execute() {
		fan.on();
		
	}

	@Override
	public void undo() {
		fan.off();
		
	}
	
	
}
class LightTurnOffCommand implements Command {
	
	Light light;
	public LightTurnOffCommand(Light light) {
		super();
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
		
	}

	@Override
	public void undo() {
		light.on();
		
	}
	
}
class FanTurnOffCommand implements Command {
	
	Fan fan;
	public FanTurnOffCommand(Fan fan) {
		super();
		this.fan = fan;
	}

	@Override
	public void execute() {
		fan.off();
		
	}

	@Override
	public void undo() {
		fan.on();
		
	}
	
}
class LightTurnOnCommand implements Command {
	
	Light light;
	public LightTurnOnCommand(Light light) {
		super();
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
		
	}

	@Override
	public void undo() {
		light.off();
		
	}
	
}

//Invoker 
class RemoteControl {
	Command command;
	Stack<Command> st = new Stack<Command>();
	
	public void setCommand(Command command) {
		this.command = command;
		st.push(command);
	}
	
	public void clickButton() {
		command.execute();
	}
	public void undo() {
		if(!st.isEmpty()) {
			Command tempCommand = st.pop();
			tempCommand.undo();
		}
	}
}



public class Client {
	


   public static void main(String[] args) {
	   
	 //Receievers
	   Fan fan = new Fan();
	   Light light = new Light();
	   
	   RemoteControl remoteControl = new RemoteControl();
	   remoteControl.setCommand(new LightTurnOnCommand(light));
	   remoteControl.clickButton();
	   remoteControl.setCommand(new FanTurnOnCommand(fan));
	   remoteControl.clickButton();
	   remoteControl.undo();
}

   
}







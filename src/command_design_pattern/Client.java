package command_design_pattern;

//Command Interface
interface Command {
	void execute();
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
	
}

//Invoker 
class RemoteControl {
	Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void clickButton() {
		command.execute();
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
}

   
}







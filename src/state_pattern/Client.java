package state_pattern;

public class Client {
  public static void main(String[] args) {
   Button button = new Button(new EnabledState());
   button.click();
   button.render();
   button.click();
   button.setState(new DisabledState());
   button.click();
   button.render();
  }
}

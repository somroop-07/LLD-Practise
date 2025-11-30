package memento_pattern;

import java.util.Stack;

//Caretaker Class
public class BankAccountCareTaker {
    
	Stack<BankAccountMemento> st = new Stack<>();
	
	public void saveState(BankAccount bankAccount) {
		st.push(bankAccount.saveState());
	}
	public void restoreState(BankAccount bankAccount) {
		if(!st.isEmpty()) {
			st.pop();
			bankAccount.restore(st.peek());
			
		}
	}
   
}

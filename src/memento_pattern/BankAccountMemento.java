package memento_pattern;

//Memento Class
public class BankAccountMemento {
	 int bankBalance;

	  public BankAccountMemento(int bankBalance) {
		super();
		this.bankBalance = bankBalance;
	   }
	  public int getBalance() {
		  return this.bankBalance;
	  }
}

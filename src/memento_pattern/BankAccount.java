package memento_pattern;

//Originator class
public class BankAccount {

	int bankBalance;
	   public BankAccount(int bankBalance) {
		this.bankBalance = bankBalance;
	   }
	   
	   public void addMoney(int amt) {
		   this.bankBalance += amt;
	   }
	   
	   public void withdrawMoney(int amt) {
		   this.bankBalance -= amt;
	   }
	   
	   public BankAccountMemento saveState() {
		   return new BankAccountMemento(bankBalance);
	   }
	   public void restore(BankAccountMemento bankAccountMemento) {
		   this.bankBalance = bankAccountMemento.getBalance();
	   }
	   public int getBalance() {
		   return this.bankBalance;
	   }
}

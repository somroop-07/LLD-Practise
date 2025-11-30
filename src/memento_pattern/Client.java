package memento_pattern;

public class Client {
	public static void main(String[] args) {
		  BankAccount bankAccount = new BankAccount(1000);
		    BankAccountCareTaker bankAccountCareTaker = new BankAccountCareTaker();
		    
		    bankAccount.addMoney(100);
		    bankAccountCareTaker.saveState(bankAccount);
		    System.out.println(bankAccount.getBalance());
		    bankAccount.addMoney(300);
		    bankAccountCareTaker.saveState(bankAccount);
		    System.out.println(bankAccount.getBalance());
		    bankAccountCareTaker.restoreState(bankAccount);
		    System.out.println(bankAccount.getBalance());
		    
	}
  
}

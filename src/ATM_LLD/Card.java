package ATM_LLD;

public class Card {
    private String nameOnCard;
    private int cvv;
    BankAccount bankAccount;
    private String pinNumber;
	public Card(String nameOnCard, int cvv, BankAccount bankAccount, String pinNumber) {
		super();
		this.nameOnCard = nameOnCard;
		this.cvv = cvv;
		this.bankAccount = bankAccount;
		this.pinNumber = pinNumber;
	}

    
    
}

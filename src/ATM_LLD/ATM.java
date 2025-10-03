package ATM_LLD;


public class ATM {

	private static ATM atmObject;
	private int atmBalance;
	private int noOfFiveHundredRupeeNotes;
	private int noOfHundredRupeeNotes;
	
	private ATM() {
		
	}
	
	
	
	public static ATM getAtmObject() {
		return atmObject;
	}



	public static void setAtmObject(ATM atmObject) {
		ATM.atmObject = atmObject;
	}



	public int getAtmBalance() {
		return atmBalance;
	}



	public void setAtmBalance(int atmBalance) {
		this.atmBalance = atmBalance;
	}



	public int getNoOfFiveHundredRupeeNotes() {
		return noOfFiveHundredRupeeNotes;
	}



	public void setNoOfFiveHundredRupeeNotes(int noOfFiveHundredRupeeNotes) {
		this.noOfFiveHundredRupeeNotes = noOfFiveHundredRupeeNotes;
	}



	public int getNoOfHundredRupeeNotes() {
		return noOfHundredRupeeNotes;
	}



	public void setNoOfHundredRupeeNotes(int noOfHundredRupeeNotes) {
		this.noOfHundredRupeeNotes = noOfHundredRupeeNotes;
	}



	public ATM getInstance() {
		if(atmObject == null) {
			atmObject = new ATM();
		}
		return atmObject;
	}
	
    public void printCurrentATMStatus(){
        System.out.println("Balance: " + atmBalance);
        System.out.println("500Notes: " + noOfFiveHundredRupeeNotes);
        System.out.println("100Notes: " + noOfHundredRupeeNotes);

    }
}

//CheckingAccount.java

import java.util.Scanner;

public class CheckingAccount implements HasMenu{
	double balance = 100.00;
	private static final java.util.Scanner input = new java.util.Scanner(System.in);

	//Create constructors
	
	public CheckingAccount(){
		this.start();
	}//End constructor 

	public CheckingAccount(double balance){
		this.balance = balance;
		this.start();
	}//End double constructor

	//Implementing methods of HasMenu
	
	public String menu(){
		System.out.println("0) Quit");
		System.out.println("1) Check balance");
		System.out.println("2) Make a deposit");
		System.out.println("3) Make a withdrawal");
		System.out.print("Please enter 0-3: ");

		String checkingResponse = input.nextLine();
		return checkingResponse;
	} //end menu

	public void start(){
		boolean keepGoing = true;
		while(keepGoing){
			String menuResponse = menu();
			if (menuResponse.equals("0")){
				System.out.println("Exiting...");
				keepGoing = false;
			} //end exit condition
			else if (menuResponse.equals("1")){
				System.out.println("Checking balance...");
				checkBalance();
			} //end checkBalance condition
			else if (menuResponse.equals("2")){
				System.out.println("Making a deposit...");
				makeDeposit();
			} //end makeDeposit condition
			else if (menuResponse.equals("3")){
				System.out.println("Making a withdrawal...");
				makeWithdrawal();
			} //end makeWithdrawal condition
		} //end while loop
	} //end start()

	public static void main(String[] args){
		CheckingAccount c = new CheckingAccount();
	} //end main()

	public double getBalance(){
		return balance;
	} //end balance getter

	public String getBalanceString(){
		return String.format("$%.2f", balance); 
	} //end getBalanceString

	public void setBalance(double balance){
		this.balance = balance;
	} //end setBalance()

	public void checkBalance(){
		String sBalance = getBalanceString();
		System.out.println("Current Balance: " + sBalance);
	} //end checkBalance
	
	public void makeDeposit(){
		System.out.println("How much to deposit? ");
		String sDepositAmt = input.nextLine();
		int depositAmt = Integer.parseInt(sDepositAmt);
		double balance = getBalance();
		double newBalance = (balance + depositAmt);
		setBalance(newBalance);
		System.out.println("New Balance: " +  getBalanceString());
	} //end makeDeposit()

	public void makeWithdrawal(){
		System.out.println("How much to withdrawal? ");
		String sWithdrawalAmt = input.nextLine();
		int withdrawalAmt = Integer.parseInt(sWithdrawalAmt);
		double balance = getBalance();

		if (withdrawalAmt > balance){
			System.out.println("Not enough money...");
		} //end overdraft condition
		else {
			double newBalance = (balance - withdrawalAmt);
			setBalance(newBalance);
			System.out.println("New Balance: " + getBalanceString());
		} //end withdraw
	} //end makeWithdrawal
} //end checkingAccount class


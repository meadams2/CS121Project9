//CheckingAccount.java

import java.util.Scanner;

public class CheckingAccount implements HasMenu{
	double balance = 100.0d;
	private static final java.util.Scanner input = new java.util.Scanner(System.in);

	//Create constructors
	
	public CheckingAccount(){
		this.start();
	}//End constructor 

	public CheckingAccount(double balance){
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
			} //end checkBalance condition
			else if (menuResponse.equals("2")){
				System.out.println("Making a deposit...");
			} //end makeDeposit condition
			else if (menuResponse.equals("3")){
				System.out.println("Making a withdrawal...");
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
		return String.format("$%,.2f", balance); 
	} //end getBalanceString


} //end checkingAccount class


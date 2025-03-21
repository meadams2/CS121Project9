//Customer.java

import java.util.Scanner;

class Customer extends User {
//	CheckingAccount checking = new CheckingAccount(100d);
//	SavingsAccount savings = new SavingsAccount(100d, 0.02);
	protected String userName;
	protected String PIN;
	protected CheckingAccount checking;
	protected SavingsAccount savings;
	
	java.util.Scanner input = new java.util.Scanner(System.in);

	public static void main(String[] args){
		Customer alice = new Customer("Alice", "0000");
		alice.start();
	} //End main

	public Customer(){
		super("Alice", "0000");
		this.checking = new CheckingAccount(100d);
		this.savings = new SavingsAccount(100d, 0.02);
	} //end constructor

	public Customer(String userName, String sPIN){
		super(userName, sPIN);
		this.checking = new CheckingAccount(100d);
		this.savings = new SavingsAccount(100d, 0.02);
//		this.userName = userName;
//		this.PIN = sPIN;
	} //End dual parameter constructor
	
	@Override
	public String menu(){
		String menuResponse;

		System.out.println("0) Exit");
		System.out.println("1) Manage Checking Account");
		System.out.println("2) Manage Savings Account");
		System.out.println("3) Change PIN");
		System.out.print("Action (0-3): ");

		menuResponse = input.nextLine();
		return menuResponse;
	} //End menu()

	public void start(){
		if (login()){
			boolean keepGoing = true;
			while(keepGoing){
				String menuInput = this.menu();
				if(menuInput.equals("0")){
					keepGoing = false;
				} //End exit condition
				else if(menuInput.equals("1")){
					System.out.println("Checking Account");
					//checking.start();
				} //End Checking Account condition
				else if(menuInput.equals("2")){
					System.out.println("Savings Account");
					//savings.start();
				} //End Savings Account condition
				else if(menuInput.equals("3")){
					System.out.println("Change PIN.");
					//this.changePin();
				} //End Change PIN condition
				else {
					System.out.println("Invalid Input");
				} //User is an idiot condition
			} //End while loop
		} //End login condition
		else {
			System.out.println("Please login.");
		} //End else	
	} //End start()

	@Override
	public String getReport(){
		String userReport = ("User Report: " + this.userName + ", Checking Balance: " + checking.getBalance() + ", Savings Balance: " + savings.getBalance());
	       return userReport;
	} //End getReport class	       

} //End class definition

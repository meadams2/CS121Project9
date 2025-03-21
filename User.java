//User.java

import java.util.Scanner;

public abstract class User implements HasMenu {
	String userName = "";
	String PIN = "";
	java.util.Scanner input = new java.util.Scanner(System.in);	
	public boolean login(){
		boolean login; 
		System.out.print("Username: ");
		sUsername = input.nextLine();
		System.out.print("PIN: ");
		sPIN = input.nextLine();

		if (sUsername.equals(this.userName)){
			if (sPIN.matches("^\\d{4}$")){
				if (sPIN.equals(this.PIN)){
					login = true;
					System.out.println("Login Successful");
				} //Correct PIN
				else {
					System.out.println("Incorrect PIN");
					login = false;
				} //Incorrect PIN
			} //End PinLength
			else {
				System.out.println("Incorrect PIN Length");
				login = false;
			} //End Incorrect PinLength
		} //End correct userName
		else {
			login = false;
		} //End incorrect userName	

		return login;
	} //End login() 

	public boolean login(String userName, String PIN){
		boolean login;
		if (userName.equals(this.userName)){
			if(PIN.equals(this.PIN)){
				login = true;
				System.out.println("Login Successful");
			} //Correct PIN
			else {
				login = false;
			} //Incorrect PIN
		} //End correct userName
		else {
			login = false;
		} //Incorrect userName


		return login;
	} //End login(userName, PIN)
	
	public String menu(){
		String menuResponse;

		System.out.println("0) Exit");
		System.out.println("1) Manage Checking Account");
		System.out.println("2) Manage Savings Account");
		System.out.println("3) Change PIN");
		System.out.print("Action (0-3):");
		
		menuResponse = input.nextLine;
	} //End menu()

	public void setUserName(String userName){
		this.userName = userName;
	} //End setUserName()

	public String getUserName(){
		return this.userName;
	} //End getUserName()

	public void setPIN(String sPIN){
		if (sPIN.matches("^\\d{4}$)){
			this.PIN = sPIN;
		}
		else{
			System.out.println("PIN must be numeric with 4 digits. Changing PIN to 0000.");
		} 
	} //End setPIN()

	public void getPIN(){
		return this.PIN;
	} //End getPIN()

	public abstract String getReport();
} //End class definition

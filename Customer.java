//Customer.java

import java.util.Scanner;

class Customer extends User {
	CheckingAccount checking = new CheckingAccount(100d);
	SavingsAccount savings = new SavingsAccount(100d, 0.02);


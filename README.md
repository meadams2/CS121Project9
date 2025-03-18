# CS121 Project 9 - Bank on It Pt 1 

The goal of this project is to build an ATM style system with different capabilities for the customer and the administrator. This part of the project focuses on writing and implementing the customer. We are given the following UML diagram to implement an ATM software. 

![image](https://github.com/user-attachments/assets/6669c324-11cf-43ab-bacc-92058a14a92d)

## HasMenu

HasMenu is an interface that is not instantiated and is instead implemented by other classes. A class that implements HasMenu must have a menu() and start() methods. 

```
interface HasMenu 
  ====================
  ====================
  string menu()
  void start()
  ====================
```
## CheckingAccount

```
class CheckingAccount implements HasMenu
  ====================
    double balance
  ====================
    CheckingAccount()
    CheckingAccount(double balance)
    main()
    string menu()
    void start()   
    double getBalance()
    string getBalanceString()
    void setBalance(double balance)
    void checkBalance()
    private double getDouble()
    void makeDeposit()
    void makeWithdrawal
  ====================
```
**Notes:**
- The checking account might be the first object to build (after the interface)
- It is mainly a wrapper around the balance, which is a double
- It has two constructors: one with and one without a double
- It will have a main so we can test it before building the other classes
- menu will print out the menu and get a response
- start will repeat the menu, send control to other methods, and exit as appropriate
- Standard getters and setters for balance
- Special getBalanceString returns balance as a nicely formatted string (String.format())
- getDouble() is a convenience function.  It tries to read in a double from the user with an exception handler. if the user inputs improper data, it will return a 0.
- checkBalance(), makeDeposit(), and makeWithdrawal() are all called by menu choices
- Later we will add serialization for data storage

### Main()

Calls start(). 

### Menu()
```
Print the following:
"""
   0) Quit
   1) Check Balance
   2) Make a deposit
   3) Make a withdrawal

   Please enter 0-3:
"""
Use a scanner for user input. Store in String checkingResponse.
Return checkingResponse.
```
### Start()

```
keepGoing = true
while keepGoing:
    menuResponse = menu()
    if menuResponse == "0":
        Print "Exiting..."
        keepGoing = false
    else if menuResponse == "1":
        Print "Checking balance..."
        checkBalance()
    else if menuResponse == "2":
        Print "Making a deposit..."
        makeDeposit()
        
    else if menuResponse == "3":
        Print "Making a withdrawal..."
        makeWithdrawal()
```
### checkBalance()

```
Print "Current balance: " + balance
```
### makeDeposit()
```
Print "How much to deposit?".
Use scanner to check for input. Store input in depositAmount.
balance += depositAmount
```
### makeWithdrawal()
```
Print "How much to withdrawal?" Check for input. Store input in withdrawalAmount.
If withdrawalAmount > balance:
    Print "Not enough money."
else:
    balance -= withdrawalAmount
```
### getBalanceString()




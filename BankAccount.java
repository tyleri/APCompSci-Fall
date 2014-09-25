public class BankAccount {

	// Instance variables
	private String fullName;
	private String password;
	private int pinNumber;
	private int accountNumber;
	private double accountBalance;

	// Main method
	public static void main( String[] args ) {
		BankAccount b = new BankAccount( "Tyler Ishikawa", "Mr. DW is cool", 1234, 123456789, 200 );
		b.printInfo();

		b.setName("JonAlf Dyrland-Weaver");
		b.setPassword("Hello World!");
		b.setPin(9876);
		b.setAccountNum(987654321);
		b.setBalance(1000000);
		b.printInfo();

		b.deposit(500);
		b.printInfo();
		b.withdraw(800);
		b.printInfo();
	}

	// Constructor
	public BankAccount( String name, String pass, int pin, int accNum, double balance ) {
		fullName = name;
		password = pass;
		pinNumber = pin;
		accountNumber = accNum;
		accountBalance = balance;
	}

	// Setters

	public void setName( String name ) {
		fullName = name;
	}

	public void setPassword( String pass ) {
		password = pass;
	}

	public void setPin( int pin ) {
		pinNumber = pin;
	}

	public void setAccountNum( int accNum ) {
		accountNumber = accNum;
	}

	public void setBalance( double balance ) {
		accountBalance = balance;
	}

	// Prints all account information
	public void printInfo() {
		System.out.printf("Full name: %s\n", fullName);
		System.out.printf("Password: %s\n", password);
		System.out.printf("ATM pin number: %d\n", pinNumber);
		System.out.printf("Account number: %d\n", accountNumber);
		System.out.printf("Account balance: $%,.2f\n\n", accountBalance);
	}

	// Deposits money into account
	public void deposit( double money ) {
		accountBalance += money;
	}

	// Withdraws money from account
	public void withdraw( double money ) {
		accountBalance -= money;
	}

}

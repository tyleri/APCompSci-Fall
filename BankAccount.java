public class BankAccount {

	// Instance variables
	private String fullName;
	private String password;
	private int pinNumber;
	private int accountNumber;
	private double accountBalance;

	// Main method
	public static void main( String[] args ) {
		BankAccount b = new BankAccount( "Tyler Ishikawa", "Mr. DW is cool", 12345, 1234567890, 200 );
		b.printInfo();

		b.setName("JonAlf Dyrland-Weaver");
		b.setPassword("Hello World!");
		b.setPin(9876);
		b.setAccountNum(987654321);
		b.setBalance(1000000);
		b.printInfo();

		b.deposit(500);
		b.printInfo();
		b.withdraw(2000000000);
		b.printInfo();

		System.out.println(b.authenticate(987654321, "Hello World!"));
	}

	// Constructor
	public BankAccount( String name, String pass, int pin, int accNum, double balance ) {
		fullName = name;
		password = pass;

		if (pin < 1000 || accNum > 9998) {
			System.out.println("Error: PIN invalid");
			pinNumber = 9999;
		} else {
			accountNumber = accNum;
		}

		if (accNum < 100000000 || accNum > 999999998) {
			System.out.println("Error: Account number invalid");
			accountNumber = 999999999;
		} else {
			accountNumber = accNum;
		}

		accountBalance = balance;
	}

	// Mutators

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
	public boolean withdraw( double money ) {
		if (money > accountBalance) {
			System.out.println("Error: not enough money in account");
			return false;
		} else {
			accountBalance -= money;
			return true;
		}
	}

	// Checks if account number matches password
	public boolean authenticate( int accNum, String pass ) {
		return accountNumber == accNum && password == pass;
	}

}

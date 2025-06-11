package pandey.ujjwal.concepts.classTypes;

public class AbstractExample {
	public static void main(String[] args) {
		var sa = new SavingsAccount(2.0, "220022", "Ujjwal Pandey", 100.0);
		var ca = new CheckingAccount(200.0, "110011", "Ujjwal Pandey", 100.0);

		sa.deposit(100);
		sa.withdraw(20);
		sa.displayAccountInfo();

		ca.deposit(200);
		ca.withdraw(30);
		ca.displayAccountInfo();
	}
}

abstract class BankAccount {
	private String accountNumber;
	private String accountHolder;
	private double balance;

	BankAccount(String accountNumber, String accountHolder, Double bal) {
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.balance = bal;
	}

	public void setAccountNumber(String accN) {
		this.accountNumber = accN;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountHolder(String acHolder) {
		this.accountHolder = acHolder;
	}

	public String getAccountHolder() {
		return this.accountHolder;
	}

	public void setBalance(Double amount) {
		this.balance = amount;
	}

	public Double getBalance() {
		return this.balance;
	}

	public abstract void deposit(double amount); // - to deposit money into the account.

	public abstract void withdraw(double amount); // - to withdraw money from the account.

	public abstract void displayAccountInfo(); // - to display the account information.

}

class SavingsAccount extends BankAccount {

	private double interestRate;

	SavingsAccount(double interestRate, String accountNumber, String accountHolder, Double bal) {
		super(accountNumber, accountHolder, bal);
		this.interestRate = interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return this.interestRate;
	}

	@Override
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	}

	@Override
	public void withdraw(double amount) {
		var finalBal = getBalance() - amount;
		if (finalBal > 0)
			setBalance(getBalance() - amount);
		else
			System.out.println("Insufficient balance");
	}

	@Override
	public void displayAccountInfo() {
		System.out.println("Info: accountNumber: " + getAccountNumber() + ", accountHolder: " + getAccountHolder()
				+ ", balance: " + getBalance() + ", interestRate: " + getInterestRate());
	}

}

class CheckingAccount extends BankAccount {

	private double overdraftLimit;

	CheckingAccount(double overdraftLimit, String accountNumber, String accountHolder, Double bal) {
		super(accountNumber, accountHolder, bal);
		this.overdraftLimit = overdraftLimit;
	}

	public void setOverDraft(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}

	public double getOverDraft() {
		return this.overdraftLimit;
	}

	@Override
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	}

	@Override
	public void withdraw(double amount) {
		var finalBal = getBalance() - amount;
		if (finalBal > 0)
			setBalance(getBalance() - amount);
		else
			System.out.println("Insufficient balance");
	}

	@Override
	public void displayAccountInfo() {
		System.out.println("Info: accountNumber: " + getAccountNumber() + ", accountHolder: " + getAccountHolder()
				+ ", balance: " + getBalance() + ", overDraft: " + getOverDraft());
	}

}

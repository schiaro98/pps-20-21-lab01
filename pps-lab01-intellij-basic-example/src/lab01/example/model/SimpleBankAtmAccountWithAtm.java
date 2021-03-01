package lab01.example.model;

public class SimpleBankAtmAccountWithAtm implements BankAccountWithAtm{

	private static final int ATM_TRANSACTION_FEE = 1;
	private final AccountHolder holder;
	private double balance;

	public SimpleBankAtmAccountWithAtm(AccountHolder holder, double balance) {
		this.holder = holder;
		this.balance = balance;
	}

	@Override
	public AccountHolder getHolder() {
		return this.holder;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

	@Override
	public void deposit(final int usrID, final double amount) {
		if (checkUser(usrID)) {
			this.balance += amount;
		}
	}

	public void depositWithAtm(final int usrID, final double amount) {
		if (checkUser(usrID)) {
			this.balance += amount - ATM_TRANSACTION_FEE;
		}
	}

	@Override
	public void withdrawWithAtm(int usrID, double amount) {
		double realAmount = amount + ATM_TRANSACTION_FEE;
		if (checkUser(usrID) && isWithdrawAllowed(realAmount)) {
			this.balance -= realAmount;
		}
	}

	@Override
	public void withdraw(final int usrID, final double amount) {
		if (checkUser(usrID) && isWithdrawAllowed(amount)) {
			this.balance -= amount;
		}
	}

	private boolean isWithdrawAllowed(final double amount){
		return this.balance >= amount;
	}

	private boolean checkUser(final int id) {
		return this.holder.getId() == id;
	}


}

package lab01.example.model;
/**
 * This interface defines the concept of a very basic bank account (with Atm transaction fees).
 */
public interface BankAccountWithAtm extends BankAccount{

	/**
	 * Allows the deposit of an amount on the account, if the given usrID corresponds to the register holder ID
	 * of the bank account. This ID acts like an "identification token" .
	 *
	 * @param usrID the id of the user that wants do the deposit
	 * @param amount the amount of the deposit
	 */
	void depositWithAtm(int usrID, double amount);

	/**
	 * Allows the withdraw of an amount from the account, if the given usrID corresponds to the register holder ID
	 * of the bank account. This ID acts like an "identification token" .
	 *
	 * @param usrID the id of the user that wants do the withdraw
	 * @param amount the amount of the withdraw
	 */
	void withdrawWithAtm(int usrID, double amount);
}

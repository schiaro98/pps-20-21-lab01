import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccountWithAtm;
import lab01.example.model.SimpleBankAtmAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleBankAccountWithAtmTest{

	private AccountHolder accountHolder;
	private BankAccountWithAtm bankAccount;

	@BeforeEach
	void beforeEach(){
		this.accountHolder = new AccountHolder("Mario", "Rossi", 1);
		this.bankAccount = new SimpleBankAtmAccountWithAtm(accountHolder, 0);
	}

	@Test
	void testAtmDeposit(){
		bankAccount.depositWithAtm(accountHolder.getId(), 100);
		assertEquals(99, bankAccount.getBalance());
		bankAccount.deposit(accountHolder.getId(), 100);
		assertEquals(199, bankAccount.getBalance());
	}

	@Test
	void testAtmWithdraw(){
		bankAccount.deposit(accountHolder.getId(), 100);
		bankAccount.withdrawWithAtm(accountHolder.getId(), 99);
		assertEquals(0, bankAccount.getBalance());
		bankAccount.deposit(accountHolder.getId(), 100);
		bankAccount.withdrawWithAtm(accountHolder.getId(), 100);
		assertEquals(100, bankAccount.getBalance());
	}

	@Test
	void testInitialBalance() {
		assertEquals(0, bankAccount.getBalance());
	}

	@Test
	void testDeposit() {
		bankAccount.deposit(accountHolder.getId(), 100);
		assertEquals(100, bankAccount.getBalance());
	}

	@Test
	void testWrongDeposit() {
		bankAccount.deposit(accountHolder.getId(), 100); //Questo va
		bankAccount.deposit(2, 50); //Questo non va
		assertEquals(100, bankAccount.getBalance()); //
	}

	@Test
	void testWithdraw() {
		bankAccount.deposit(accountHolder.getId(), 100);
		bankAccount.withdraw(accountHolder.getId(), 70);
		assertEquals(30, bankAccount.getBalance());
	}

	@Test
	void testWrongWithdraw() {
		bankAccount.deposit(accountHolder.getId(), 100);
		bankAccount.withdraw(2, 70);
		assertEquals(100, bankAccount.getBalance());
	}
}

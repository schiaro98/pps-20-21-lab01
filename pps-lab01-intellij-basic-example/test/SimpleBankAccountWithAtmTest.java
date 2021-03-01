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
}

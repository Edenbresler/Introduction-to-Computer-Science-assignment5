import java.util.Comparator;

public class AccountComparatorByNumber implements Comparator<BankAccount>{

	@Override
	public int compare(BankAccount account1, BankAccount account2) {
		// task 2b
		Integer accountN1=(Integer)account1.getAccountNumber();
		Integer accountN2=(Integer)account2.getAccountNumber();
		return accountN1.compareTo(accountN2);
	}

}

public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}
	
	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}
	
	// END OF Given code -----------------------------------
	
	// Complete the methods from here on

	public boolean add(BankAccount newAccount) {
		// task 6a
		//Assume that newAccount is not null
		//Check that there are no accounts with the same name or account number.
		boolean ans =false;
		String nameOfNewAccount =newAccount.getName();
		BankAccount nameExists=lookUp(nameOfNewAccount);
		int numberOfNewAccount =newAccount.getAccountNumber();
		BankAccount numberExists=lookUp(numberOfNewAccount);
		if(nameExists==null & numberExists==null) {
			ans =true;
			//Add the same account to the two defined trees in the class fields.
			this.namesTree.insert(newAccount);
			this.accountNumbersTree.insert(newAccount);
		}
		return ans;
	}

	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		// complete this:

		// task 6b
		boolean ans =false;
		if(toRemove != null) {
			this.namesTree.remove(toRemove);
			this.accountNumbersTree.remove(toRemove);
			ans=true;
		}
		return ans;
	}
	
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:

		// task 6c
		boolean ans =false;
		if(toRemove != null) {
			this.namesTree.remove(toRemove);
			this.accountNumbersTree.remove(toRemove);
			ans=true;
		}
		return ans;

	}

	public boolean depositMoney(int amount, int accountNumber){
		// task 6d
		boolean ans= false;
		BankAccount deposit =lookUp(accountNumber);
		if(deposit != null) {
			ans=deposit.depositMoney(amount);
		}
		return ans;
	}

	public boolean withdrawMoney(int amount, int accountNumber){
		// task 6e
		boolean ans= false;
		BankAccount withdraw =lookUp(accountNumber);
		if(withdraw != null) {
			ans=withdraw.withdrawMoney(amount);
		}
		return ans;
	}	
	
	public boolean transferMoney(int amount, int accountNumber1, int accountNumber2) {
		// task 6f
		boolean ans= false;
		ans =withdrawMoney(amount, accountNumber1);
		if(ans) {
			ans =depositMoney(amount,accountNumber2);
		}
		return ans;
	}	
	public boolean transferMoney(int amount, int accountNumber, String name) {
		// task 6g
		boolean ans= false;
		BankAccount accuntToDeposit= lookUp(name);
		BankAccount accuntToTake=lookUp(accountNumber);
		//Check that these accounts exist
		if(accuntToDeposit != null & accuntToTake!=null ) {
			int numberAccuntToDeposit= accuntToDeposit.getAccountNumber();
			ans= transferMoney(amount, accountNumber, numberAccuntToDeposit);
		}
		return ans;
	}	
}



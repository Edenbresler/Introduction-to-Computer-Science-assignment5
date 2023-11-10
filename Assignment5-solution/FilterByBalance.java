public class FilterByBalance implements Filter<BankAccount>{
	private int balanceThreshold;
	public FilterByBalance(int balanceThreshold) {
        // task 5c
		this.balanceThreshold=balanceThreshold;
		
	}
	@Override
	public boolean accept(BankAccount elem) {
		// task 5c
		boolean accept= false;
		int element=elem.getBalance();
		if(element >= balanceThreshold ) {
			accept =true;
			
		}
		return accept;
	}
}


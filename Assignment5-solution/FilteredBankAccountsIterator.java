import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilteredBankAccountsIterator implements Iterator<BankAccount> {

	private BinaryTreeInOrderIterator<BankAccount> iterator;
	private Filter<BankAccount> filter;
    private BankAccount current;
    
    public FilteredBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree, Filter<BankAccount> filter) {
        // task 5c
    	this.filter=filter;
    	this.iterator = new BinaryTreeInOrderIterator<BankAccount>(bankAccountsTree.root);
    	boolean foundnext=false;
    	//"cuurent" is the first node that meets the conditions of the filter
    	this.current = null;
    	while(iterator.hasNext() & !foundnext) {
    		BankAccount next =iterator.next();
    		if(filter.accept(next)) {
    			this.current = next;
    			foundnext= true;
    		}
    	}
    }

    //Complete the following method
    @Override
    public boolean hasNext() {
        // task 5c
    	return current != null;
    }

    //Complete the following method
    @Override
    public BankAccount next() {
        // task 5c
    	//"current" represents the following next
    	//"res" represents the current next
    	boolean foundnext=false;
    	BankAccount res=current;
    	if(!hasNext())
    		throw new  NoSuchElementException("The input is illegal");
    	while(iterator.hasNext() & !foundnext) {
    		current =iterator.next();
    		if(filter.accept(current)) {
    			foundnext=true;
    		}
    	}
    	if(!foundnext) {
    		current=null;
    	}
	return res;
	}
}


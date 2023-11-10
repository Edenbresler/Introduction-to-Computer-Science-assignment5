import java.util.Comparator;
import java.util.Iterator;

//import task2.Bit;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	// Complete the following methods
	public void balance(){
		// task 5b
		//Create a new list and insert all the nodes using the inOrder method
		List<BankAccount> list = new DynamicArray<BankAccount>();
		Iterator<BankAccount> iter = this.iterator();
    	while (iter.hasNext()) {
    		BankAccount nextAccount = (BankAccount)iter.next();
    		list.add(nextAccount);
    	}
    	//Create a new BankAccountsBinarySearchTree and activating "buildBalancedTree" function on it.
    	//Defining the original tree to be the new tree
    	BankAccountsBinarySearchTree newTree =new BankAccountsBinarySearchTree(this.comparator);
    	newTree.buildBalancedTree(list, 0, list.size()-1);
    	super.root=newTree.root;
	}
	
	private void buildBalancedTree(List<BankAccount> list, int low, int high){
		// task 5b
		//Stop condition
		if(low==high)
			insert(list.get(low));
		//Find the middle node in the list
		//Inserting the middle vertex into the tree
		//Apply the method to the entire right and left parts of the middle node in the list
		else if (low<high){
			int lengthOfList = high+low +1;
			int midIndex = lengthOfList/2;
			BankAccount theData =list.get(midIndex);
			insert(theData);
			buildBalancedTree(list, midIndex+1, high );
			buildBalancedTree(list, low, midIndex-1);
		}
	}
}

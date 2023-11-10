import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringIterator implements Iterator<String> {
   
	//Complete the following methods
	private String start;
	private String next;

    public StringIterator(String start){
    	// task 0
    	//Assume that "start" is a valid string
    	//The constructor gets an initial string which is also the initial next
    	this.start=start;
    	this.next=start;
    }
    //Assume that the iterator will not be required to return strings that are longer than the maximum value that can be represented by a variable of type int.
    public boolean hasNext(){
    	// task 0
    	return true;
    }

    public String next(){
    	// task 0
    	//"this.next" represents the following next
    	//"nextString" represents the current next
    	String nextString=this.next;
    	char lastChar=0;
    	int lastIndex= this.next.length()-1;
    	if(lastIndex!=-1) {
    		lastChar = this.next.charAt(lastIndex);
    	}
    	if(this.next.equals("")) {
    		this.next="a";
    	}
    	else if(lastChar != 'Z' & lastChar != 'z') {
    		lastChar =(char)((int)lastChar +1);
    		this.next =this.next.substring(0, lastIndex) + lastChar;
    	}
    	else if(lastChar == 'z') {
    		lastChar='A';
    		this.next =this.next.substring(0, lastIndex) + lastChar;
    	}
    	else {
    		if(this.next.length()==1) {
    			this.next="aa";
    		}
    		else {
    			String firstPart =start.substring(0,lastIndex);
    			StringIterator newOne = new StringIterator(firstPart);
    			newOne.next();
    			firstPart =newOne.next();
    			String lastPart= "a";
    			this.next = firstPart+lastPart;
    		}
    	}
    	return nextString;
    }
}

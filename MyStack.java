package dictionary;

/*
 * @author Tabetha Boushey and Kelsey O'Keefe
 * @version 4/2/2012
 * Out Lab 5
 */

import java.util.*;

public class MyStack {
     //Create arraylist myarray
    ArrayList<String> myArray;
    
    public MyStack() {
        //Initialize arraylist myarray
        myArray = new ArrayList<String>();
        
    }
    //This method will add a new character to the top of the array
    public void push(String c) {
         myArray.add(c);  
    }
    
    // This method will remove a character from the top of the array
    public String pop() {
        String c = myArray.get(myArray.size()-1);
        myArray.remove(myArray.size()-1);
        return c;
    }
    
    /**
     * This method will return and print the character at the top of the array
     * @return 
     */
    public String peek(){
        int i = myArray.size();
        String c = myArray.get(i-1);
        return c;
    }
    /**
     * This method returns the size of the array
     * @return 
     */
    public int size(){
        int i = myArray.size();
        return i;
    }
}

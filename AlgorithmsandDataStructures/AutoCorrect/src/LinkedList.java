
/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 9, AutoCorrect
 */

import java.util.HashSet;

/**
 * 
 * @author ahaggard2013
 *
 * @param <Key> key used to find value
 * @param <Value> value held
 */
public class LinkedList<Key, Value> {

    private int N;           // number of key-value pairs
    private Node first;      // the linked list of key-value pairs

    /**
     * helper class for linked list
     * @author ahaggard2013
     *
     */
    private class Node {
        // a helper linked list data type
        private Key key;		
        private Value val;
        private Node next;		// pointer to the next Node

        /**
         *  constructor for helper class
         * @param key key value for node
         * @param val value held
         * @param next next falue held
         */
        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * adds a value to the list
     * @param key key to access value
     * @param val value held
     */
    public void add(Key key, Value val) {
		// add new Key-Value pair to the linked list
    	Node node = new Node(key, val, null);
    	if (this.first == null) {
    		this.first = node;
    	}
    	else {
    		Node temp = this.first;
    		while (temp.next != null) temp = temp.next;
    		temp.next = node;
    	}
    	this.N++;
    	
    }

    // return number of key-value pairs
    /**
     * returns size of linked list
     * @return size of list
     */
    public int size() {
        return N;
    }

    // is the symbol table empty?
    /**
     * Checks if table is empty
     * @return true of false if table is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Checks if a key exists in list
     * @param key key to check for
     * @return true or false if key is in list
     */
    public boolean contains(Key key) {
        // return true if the key is in the list, false otherwise
    	Node temp = this.first;
    	while (temp != null) {
    		if (temp.key.equals(key))
    			return true;
    		else
    			temp = temp.next;
    	}
    	return false;
    }

    /**
     * Gets a value from list
     * @param key key to access value
     * @return value in table
     */
    public Value get(Key key) {
		 // return the value associated with the key, or null if the key is not present
    	Node temp = this.first;
    	while (temp != null) {
    		if (temp.key.equals(key))
    			return temp.val;
    		else
    			temp = temp.next;
    	}
    	return null;
    }
    
    /**
     * returns a hashset of unique keys
     * @return hashset of unique keys
     */
    public HashSet<Key> getKeys(){
    	// return set of unique keys. Nothing to implement here
    	Node firstNode=first;
    	
    	HashSet<Key> s = new HashSet<Key>();
    	
    	while(firstNode!=null){
    		s.add(firstNode.key);
    		firstNode=firstNode.next;
    	}
    	return s;
    }

   /**
    * Deletes a value from the list
    * @param key key to access value
    */
    public void delete(Key key) {
         // remove key-value pair with given key
    	if (this.first == null)
    		throw new RuntimeException("Nothing found in List");
    	if (this.first.key.equals(key)) {
    		this.first = first.next;
    		return;
    	}
    	Node prev = null;
    	Node temp = this.first;
    	while (temp != null && !temp.key.equals(key)) {
    		prev = temp;
    		temp = temp.next;
    	}
    	
    	if (temp == null) 
    		throw new RuntimeException("Key not found in list");
    	prev.next = temp.next;
    }
    /**
     * returns String array representation of list
     * @return String array of list
     */
    public String[] getList() {
    	Node temp = this.first;
    	String[] result = new String[this.N];
    	result[0] = temp.val.toString();
    	for (int i = 1; i < result.length; i++) {
			temp = temp.next;
			if (temp == null)
				return result;
			result[i] = temp.val.toString();
		}
    	return result;
    }

    /**
     * toString method
     */
    public String toString() {
		//return string representation of the list. Nothing to implement here.
		
        Node var = this.first;
        String result="";
        while (var != null) {
            result+=var.key.toString() + "\t \t " + var.val+"\n";
            var = var.next;
        }
        
        return result;
    }
}

/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 7, MapReduce
 */

import java.util.HashSet;

/**
 * 
 * @author ahaggard2013
 *Class to create HashTable
 * @param <Key> value of key
 * @param <Value> value held by key
 */
public class HashTable<Key, Value> {

	private int N; // size of hash table
	private int M; // number of linked lists
	private LinkedList<Key, Value>[] lists; // Hash table with collision resolution by chaining
	@SuppressWarnings("unchecked")
	public HashTable(int M) {
		// M is the number of linked lists the table should be initialized with
		int N = 0;
		this.M = M;
		this.N = N;
		this.lists = new LinkedList[M];
		for (int i = 0; i < M; i++) {
			this.lists[i] = new LinkedList<Key, Value>();
		}
	}
	
	/**
	 * hashes the given key
	 * @param key key given
	 * @return hashValue
	 */
	private int hash(Key key) {
		
		String strKey = key.toString();
		int intKey = 0;
		int strLength = strKey.length();
		
		final int RADIX = 128; // See CLSR book for details
		
		for (int i = 0; i < strKey.length(); i++) {
			intKey = (int)(Math.pow(RADIX, (strLength - 1) - i)) * strKey.charAt(i) + intKey;
		}
		double A = (Math.sqrt(5) - 1) / 2;
		
		double res = intKey * A;
		res = res - Math.floor(res);
		int hashValue = (int) Math.floor(M * res);
		
		return hashValue;
	}
	
	/**
	 * finds a value with the given key
	 * @param key key to search
	 * @return value held by key
	 */
	public Value get (Key key) {
		//return Value, given key
		return this.lists[hash(key)].get(key);
	}
	
	/**
	 * checks if a certain key is in the HashTable
	 * @param key key passed in
	 * @return True of False if key is in table
	 */
	public boolean contains(Key key) {
		// true if key exists in the table, false otherwise
		if (this.lists[hash(key)].contains(key))
			return true;
		else
			return false;
	}
	
	/**
	 * Inserts a key value pair into table
	 * @param key key to pass into table
	 * @param val value to pass into table
	 */
	public void insert(Key key, Value val) {
		// insert Key-Value pair into hashtable
		this.lists[hash(key)].add(key, val);
		this.N++;
	}
	
	/**
	 * Deletes a value from the table
	 * @param key key of the value to delete
	 */
	public void delete(Key key) {
		// delete key from the hashtable.  
		// Should only delete the first occurence of the key if there is more than one
		this.lists[hash(key)].delete(key);
		this.N--;
	}
	
	/**
	 * Creates a Hashset containing unique keys of the hashtable
	 * @return hashset of hashtable
	 */
	public HashSet<Key> getKeys() {
		//return HashSet of unique keys in the HashTable
		HashSet<Key> hashset = new HashSet<Key>();
		for (int i = 0; i < M; i++) {
			HashSet<Key> set = this.lists[i].getKeys();	
			hashset.addAll(set);
		}
		
		return hashset;
	}
	
	/**
	 * toString method
	 */
	public String toString() {
		String result = "";
		// return string representation of the HashTable
		for (int i = 0; i < M; i++) {
			result += "List #" + (i + 1) + "\n";
			result += "--------------------" + "\n";
			result += this.lists[i].toString();
			result += "--------------------" + "\n";
		}
		return result;
	}
}

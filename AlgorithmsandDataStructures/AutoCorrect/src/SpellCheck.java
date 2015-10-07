/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 9, AutoCorrect
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;


public class SpellCheck {
	
	HashSet<String> dictionary;
	
	HashTable<String, String> shinglesDict;    // use dictionarySize * 4 as the number of linkedlists
	
	private final int shingleSize;
	
	private  final int dictionarySize=899981;  // use this number to initialize dictionary

	/**
	 * 
	 * @param dictionaryFilename where to find dictionary file
	 * @param shingleSize size of shingles to use
	 * @throws IOException throws exception
	 */
	public SpellCheck(String dictionaryFilename, int shingleSize) throws IOException{ // constructor which takes in name of the dictionary and shingle size
		BufferedReader reader = new BufferedReader(new FileReader(dictionaryFilename));
		this.dictionary = new HashSet<String>(this.dictionarySize);
	  	this.shinglesDict = new HashTable<String, String>(this.dictionarySize * 4);
		this.shingleSize = shingleSize;
		// creates dictionary
	  	while (reader.ready()) {
			this.dictionary.add(reader.readLine());
		}
		reader.close();
		// creates shingle dictionary
		for(String word: this.dictionary) {
			for (int i = 0; i < (word.length() - shingleSize) + 1; i++) {
				this.shinglesDict.insert(word.substring(i, i + shingleSize), word);
			}
		}
	}

	/**
	 * 
	 * @param s string to compare
	 * @param t string to compare
	 * @return leviathon distance
	 */
	public int distance(String s, String t){
		// calculate edit distance for strings s,t. Solution has to run in O(max{s.length,t.length}) time and space
		if (s == t) 
			return 0;
		else if (s.length() == 0) 
			return t.length();
		else if (t.length() == 0)
			return s.length();
		// row and column being used in two seperate arrays
		int [] dis1 = new int[t.length() + 1];
		int [] dis2 = new int[t.length() + 1];
		
		for (int i = 0; i < dis1.length; i++) {
			dis1[i] = i;
		}

		for (int i = 0; i < s.length(); i++) {
			
			dis2[0] = i + 1;
			
			for (int j = 0; j < t.length(); j++) {
				int cost;
				if (s.charAt(i) == t.charAt(j))
					cost = 0;
				else 
					cost = 1;
				dis2[j + 1] = Math.min(Math.min(dis2[j] + 1, dis1[j + 1] + 1), dis1[j] + cost);
			}
			
			for (int j = 0; j < dis1.length; j++) {
				dis1[j] = dis2[j];
			}
		}
		// returns far right corner
		return dis2[t.length()];
		
	}
	
	/**
	 *  scrolls through dictionary one by one comparing distance
	 * @param wordToCorrect word to correct
	 * @return pair of correct word and distance of correction
	 */
	public Pair<String, Integer> naiveCorrect(String wordToCorrect){
		// calculate best correction word using naive approach
		String correctWord = "";
		int correctDistance = Integer.MAX_VALUE;
		int valHolder;
		// scrolls through dictionary
		for (String word : this.dictionary) {
			valHolder = distance(wordToCorrect, word);
			if (valHolder < correctDistance) {
				correctWord = word;
				correctDistance = valHolder;
			}
		}
		Pair<String, Integer> result = new Pair<String, Integer>(correctWord, correctDistance);
		return result;
	}
	
	/**
	 * gets the shingles of a word
	 * @param word word to divide into shingles
	 * @return string array of shingles
	 */
	private String[] getShingles(String word) {
		String[] shingles = new String[word.length() - this.shingleSize + 1];
		// splits word into desired shingle length
		for (int i = 0; i < (word.length() - this.shingleSize) + 1; i++) {
			shingles[i] = word.substring(i, i + this.shingleSize);
		}
		
		return shingles;
	}

	/**
	 * uses shingles to correct word
	 * @param word word to correct
	 * @return pair of correct word and distance length
	 */
	public Pair<String, Integer> fastCorrect(String word) {
		// calculate best correction using shingles approach
		String[] shingles = getShingles(word);
		int valHolder;
		int correctDistance = Integer.MAX_VALUE;
		String correctWord = "";
		//loops through all shingles
		for (String string : shingles) {
			if (this.shinglesDict.contains(string)) {
				valHolder = distance(word, this.shinglesDict.get(string));
				if (valHolder < correctDistance) {
					correctWord = this.shinglesDict.get(string);
					correctDistance = valHolder;
				}
				String[] words = {};
				//gets all words in that shingles list
				words = this.shinglesDict.getList(string);
				// compares words in shingle list and word to correct
				for (int j = 0; j < words.length; j++) {
					valHolder = distance(word, words[j]);
					if (valHolder < correctDistance) {
						correctWord = words[j];
						correctDistance = valHolder;
					}
				}
			}
		}
		Pair<String, Integer> result = new Pair<String, Integer> (correctWord, correctDistance);
		return result;
	}


}

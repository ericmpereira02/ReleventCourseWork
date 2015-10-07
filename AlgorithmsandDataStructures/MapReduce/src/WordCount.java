/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 7, MapReduce
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Counts number of words in a given string
 * @author ahaggard2013
 * 
 */
public class WordCount {

	MapReduce<String, Integer> mapReduce; // needed for map(), reduce()
											// functions

	int numMappers; // number of computers for map function
	int numReducers; // number of computers for reduce function

	HashTable<String, Integer> mapHashTable; // HashTable with <word,cpu>
	HashTable<Integer, Pair<String, ArrayList<Integer>>> reduceHashTable; // HashTable
																			// with
																			// <cpu,<word,list(word
																			// counts)>>
	/**
	 * wordCount constructor
	 * @param numMappers_ number of computers of map function
	 * @param numReducers_ number of computers for reduce function
	 * @param mapReduce_ needed for map and reduce functions
	 */
	public WordCount(int numMappers_, int numReducers_,
			MapReduce<String, Integer> mapReduce_) {
		// constructor
		HashTable<String, Integer> mapHashTable_ = new HashTable<String, Integer>(
				numMappers_);
		HashTable<Integer, Pair<String, ArrayList<Integer>>> reduceHashTable_ = new HashTable<Integer, Pair<String, ArrayList<Integer>>>(
				numMappers_);
		this.mapReduce = mapReduce_;
		this.numMappers = numMappers_;
		this.numReducers = numReducers_;
		this.mapHashTable = mapHashTable_;
		this.reduceHashTable = reduceHashTable_;
	}

	/**
	 * Divides List into chunks
	 * @param key key to find list to divide
	 * @return array list of divided words
	 */
	public ArrayList<String> divide(String key) {
		// divide string into list of chunks( lines in this case ). Nothing to
		// implement here.
		String[] tokens = key.split("\n");
		ArrayList<String> stringList = new ArrayList<String>(tokens.length);

		for (int i = 0; i < tokens.length; i++) {
			stringList.add(tokens[i]);
		}

		return stringList;
	}

	/**
	 * Assigns cpus to values to map
	 * @param key key to find values needed
	 * @return Hashtable of cpus to words
	 */
	public HashTable<Integer, ArrayList<String>> assignMapJobs(String key) {

		ArrayList<String> jobs = this.divide(key);

		HashTable<Integer, ArrayList<String>> mapJobs = new HashTable<Integer, ArrayList<String>>(
				this.numMappers);
		String[] words;
		int cpu = 0;
		// assigns map jobs to computers
		for (int i = cpu; i < jobs.size(); i++) {
			words = jobs.get(i).replaceAll("[^a-zA-Z ]", "").toLowerCase()
					.split("\\s+");
			ArrayList<String> list = new ArrayList<String>();
			for (String word : words) {
				list.add(word);
			}
			mapJobs.insert(cpu, list);
			cpu = (cpu + 1) % this.numMappers;
		}
		return mapJobs;

	}

	/**
	 * Proccesses assigned map jobs
	 * @param cpuVsWords list of computers vs words to proccess
	 */
	public void processMapJobs(HashTable<Integer, ArrayList<String>> cpuVsWords) {
		
		ArrayList<Pair<String, Integer>> mapJ = null;
		HashSet<Integer> cpus = cpuVsWords.getKeys();
		// inserts map jobs into map hashtable
		for (int i = 0; i < cpus.size(); i++) {
			while (cpuVsWords.get(i) != null) {
				mapJ = this.mapReduce.map(cpuVsWords.get(i));
				cpuVsWords.delete(i);
				for (Pair<String, Integer> pair : mapJ) {
					mapHashTable.insert(pair.getFirst(), pair.getSecond());
				}
			}
		}
	}

	/**
	 * Assigns jobs to reduce 
	 * @return Hashtable of jobs to reduce
	 */
	public HashTable<Integer, Pair<String, ArrayList<Integer>>> assignReduceJobs() {
		
		int cpu = 0;
		Pair<String, ArrayList<Integer>> pair = null;
		HashSet<String> keys = this.mapHashTable.getKeys();
		HashTable<Integer, Pair<String, ArrayList<Integer>>> cpuToReduceJob = new HashTable<Integer, Pair<String, ArrayList<Integer>>>(
				this.numReducers);
		Iterator<String> itr = keys.iterator();
		// assigns jobs to the cpus
		for (int i = cpu; i < keys.size(); i++) {

			String word = itr.next().toString();
			ArrayList<Integer> counts = new ArrayList<Integer>();
			while (mapHashTable.contains(word)) {
				counts.add(mapHashTable.get(word));
				mapHashTable.delete(word);
				pair = new Pair<String, ArrayList<Integer>>(word, counts);
			}
			cpuToReduceJob.insert(cpu, pair);
			cpu = (cpu + 1) % numReducers;
		}
		// returns table of jobs to reduce
		return cpuToReduceJob;
	}

	/**
	 * Processes jobs to reduce
	 * @param reduceJobs table of jobs to reduce
	 * @return map of jobs to reduce
	 */
	public ArrayList<Pair<String, Integer>> processReduceJobs(
			HashTable<Integer, Pair<String, ArrayList<Integer>>> reduceJobs) {

		ArrayList<Pair<String, Integer>> mapJ = new ArrayList<Pair<String, Integer>>();
		Pair<String, Integer> temp = null;
		HashSet<Integer> cpus = reduceJobs.getKeys();
		// inserts jobs to reduce into table
		for (int i = 0; i < cpus.size(); i++) {
			
			while (reduceJobs.get(i) != null) {
				temp = this.mapReduce.reduce(reduceJobs.get(i));
				mapJ.add(temp);
				reduceJobs.delete(i);
				for (Pair<String, Integer> pair : mapJ) {
					mapHashTable.insert(pair.getFirst(), pair.getSecond());
				}
			}
		}
		return mapJ;
	}
}

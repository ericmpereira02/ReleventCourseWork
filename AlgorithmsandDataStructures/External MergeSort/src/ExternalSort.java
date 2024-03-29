/*
 * Author : Austin Haggard, ahaggard2013@my.fit.edu
 * Course : CSE 2010, Section 01, Fall 2014
 * Project: Lab 6, External MergeSort
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

// ExternalSort.java
/**
 * 
 * @author ahaggard2013
 *
 */
public class ExternalSort {

     private static final int DNE = -1;		//used if only one file is being combined
	private int chunkSize ;                // size of the chunks
     private String directory;              // directory where temporary files will be saved to
    /**
     * constructor
     * @param directory_ directory where temp files will be saved
     * @param chunkSize_ size of chunks to be sorted
     */
    public ExternalSort(String directory_, int chunkSize_) {
        // implement constructor
    	this.directory = directory_;
    	this.chunkSize = chunkSize_;
    }
    /**
     * splits array
     * @param a array to be split
     * @param first first index of array
     * @param last last index of array
     * @return
     */
	public int split(int[] a, int first, int last) {
		// finds the middle index of list
		int middle = first + (last - first) / 2;
		return middle;
	}
	/**
	 * sorts numbers
	 * @param a array to be sorted
	 * @param from first index location to be sorted
	 * @param to last index location to be sorted
	 */
	public void mergeSort(int[] a, int from, int to) {
		int middle;
		// Recursively performs merge sort
		if (from < to) {
			middle = split(a, from, to);
			mergeSort(a, from, middle);
			mergeSort(a, middle + 1, to);
			combine(a, from, middle, to);
		}

	}
	/**
	 * Combines the split portions of the list together
	 * @param a list to be combined
	 * @param first first index location of what to sort
	 * @param middle middle index of the array
	 * @param last last index to sort in the array
	 */
	public void combine(int[] a, int first, int middle, int last) {
		int[] temp = new int[a.length];
		// assigns needed elements to temporary list
		for (int i = first; i <= last; i++) {
			temp[i] = a[i];
		}
		int low_index = first;
		int mid = middle + 1;
		int start_index = first;
		// reassembles the broken apart array in a sorted order
		while (low_index <= middle && mid <= last) {
			if (temp[low_index] <= temp[mid]) {
				a[start_index] = temp[low_index];
				low_index++;
			} else {
				a[start_index] = temp[mid];
				mid++;
			}
			start_index++;
		}
		while (low_index <= middle) {
			a[start_index] = temp[low_index];
			start_index++;
			low_index++;
		}
	}
	/**
	 * combines files together to work around memory limitations
	 * @param a first file to be joined
	 * @param b second file to be joined
	 * @param mix makes it possible to make a new temp file with consistent naming
	 * @param newTemp number of temp file
	 * @throws NumberFormatException for when new line character is read
	 * @throws IOException for reader and writer
	 */
	public void combineFinal(File a, File b, int mix, int newTemp) throws NumberFormatException, IOException {
		BufferedReader fileA = null;
		BufferedReader fileB = null;
		boolean sortsLeft = true;
		try {fileA = new BufferedReader(new FileReader(a));	
		} catch(FileNotFoundException e){}
		
		try {fileB = new BufferedReader(new FileReader(b));
		} catch (FileNotFoundException e){}
		
		FileWriter writer = new FileWriter(this.directory + "\\"  + mix + "temp" + newTemp + ".txt" );
		int intA = 0;
		int intB = 0;
		try {intA = Integer.parseInt(fileA.readLine());
		} catch (NumberFormatException | NullPointerException e) {
			intA = DNE;
		}
		//if fileB doesn't exist A is merged with itself
		try {intB = Integer.parseInt(fileB.readLine());
		} catch (NumberFormatException | NullPointerException e) {
			intB = DNE;
		}
		//This is where A can be merged with itself
		if (intB == DNE) {
			while (fileA.ready()) {
				writer.write(intA + System.getProperty("line.separator"));
				try {intA = Integer.parseInt(fileA.readLine());
				} catch (NumberFormatException i) {
					break;
				}
		   }
			writer.write(intA + System.getProperty("line.separator"));
			fileA.close();
			writer.close();
		}
		else if (intA == DNE) {
			while (fileB.ready()) {
				writer.write(intB + System.getProperty("line.separator"));
				try {intB = Integer.parseInt(fileB.readLine());
				} catch (NumberFormatException i) {
					break;
				}
		   }
			writer.write(intB + System.getProperty("line.separator"));
			fileB.close();
			writer.close();
		}
		//Sorts both files into a new file
		else {
			while (sortsLeft) {
				while(intA <= intB) {
					writer.write(intA + System.getProperty("line.separator"));
					//If A reaches the end B is filled
					try { intA = Integer.parseInt(fileA.readLine());
					}
					catch (NumberFormatException e) {
						while (fileB.ready()) {
							writer.write(intB + System.getProperty("line.separator"));
							try { intB = Integer.parseInt(fileB.readLine());
							} catch (NumberFormatException i) {
								break;
							}
						}
						writer.write(intB + System.getProperty("line.separator"));
						fileA.close();
						fileB.close();
						writer.close();
						sortsLeft = false;
						break;
					}
				}
				while(intB <= intA) {
					writer.write(intB + System.getProperty("line.separator"));
					//If B reaches an end A is filled
					try { intB = Integer.parseInt(fileB.readLine());
					}
					catch (NumberFormatException e) {
						while (fileA.ready()) {
							writer.write(intA + System.getProperty("line.separator"));
							try {intA = Integer.parseInt(fileA.readLine());
							} catch (NumberFormatException i) {
								break;
							}
						}
						writer.write(intA + System.getProperty("line.separator"));
						fileA.close();
						fileB.close();
						writer.close();
						sortsLeft = false;
						break;
					}
				}
			}
			}
		
	}
	/**
	 * Creates ease of sorting
	 * @param a array to be sorted
	 */
	public void mergeSort(int[] a) {
		// sorts the full list
		mergeSort(a, 0, a.length - 1);

	}
	  /**
	   * Sorts arrays to large to be held in memory
	   * @param inputFile file to be sorted
	   * @param outputFile where sorted file will be outputted
	   * @throws IOException for reader and writer
	   */
      public void completeSort(String inputFile,String outputFile) throws IOException {
      // inputFile - filename of the input file
      // outputFile - filename of the output file ( new file which is a sorted version of the input)
      // implement external 2-way merge sort 
    	  File file = new File(inputFile);
    	  BufferedReader reader = new BufferedReader(new FileReader(file));
    	int fileNum = 0;
    	// Splits file into smaller files of given chunk size
		while (true) {
			if (reader.ready()) {
				File tempFile = new File(this.directory + "\\temp" + fileNum +".txt"); 
				fileNum++;
				FileWriter write = new FileWriter(tempFile);
				int[] shortA = null;
				int[] a = new int[this.chunkSize];
				int counter = 0;
				//Creates array to write to file
				while (counter < this.chunkSize) {
					String newInt = reader.readLine();
					if (newInt != null) {
					a[counter] = Integer.parseInt(newInt);
					}
				//incase array is smaller than chunk size
					else {
						shortA = new int[counter];
						shortA = Arrays.copyOf(a, counter);
						break;
					}
					counter++;
				}
				//sorts small array
				if (counter != this.chunkSize) {
				mergeSort(shortA);
				for(int num: shortA) {
					write.append(String.valueOf(num));
				}
				}
				//sorts full sized array
				else {
					mergeSort(a);
					for(int num: a) {
						write.write(String.valueOf(num) + System.getProperty("line.separator"));
					}
				}
				write.close();
			}
			else {
				reader.close();
				break;
			}
		}
		int origFileNum = fileNum;
		int mix = 0;
		//combines all files into larger files
		while (fileNum >= 1) {
			int counter = 0;
				while (counter < fileNum && origFileNum == fileNum) {
					File a = new File(this.directory + "\\temp" + counter + ".txt");
					File b = new File(this.directory + "\\temp" + ++counter +".txt");
					combineFinal(a,b, mix, counter/2);
					counter++;
				}
				while (counter < fileNum && origFileNum != fileNum) { 
					File a = new File(this.directory + "\\" + mix + "temp" + counter + ".txt");
					File b = new File(this.directory + "\\" + mix + "temp" + ++counter +".txt");
					combineFinal(a,b, mix + 1, counter/2);
					counter++;
				}
				if (origFileNum != fileNum)
					mix++;
			//deletes all temp files and creates output file
			if (fileNum  == 1) {
				File dest = new File(outputFile);
				File finalOutput = new File(this.directory + "\\" + mix++ + "temp" + 0 + ".txt");
				finalOutput.renameTo(dest);
				File temp = new File(this.directory);
				String[] files;
				if (temp.isDirectory()) {
					files = temp.list();
					for (String doc: files) {
						File del = new File (temp, doc);
						del.deleteOnExit();
					}
				}
			}
			fileNum = fileNum / 2;
		}
		}
    /**
     *   
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
		ExternalSort externalsort = new ExternalSort("C:\\Users\\AJ\\Documents\\FIT\\DataStruc\\TEMP\\Downloads\\temp", 10000);
		externalsort.completeSort("C:\\Users\\AJ\\Documents\\FIT\\DataStruc\\TEMP\\Downloads\\input\\testcase2.txt", "C:\\Users\\AJ\\Documents\\FIT\\DataStruc\\TEMP\\Downloads\\output\\output2.txt");
		
	}
      
}
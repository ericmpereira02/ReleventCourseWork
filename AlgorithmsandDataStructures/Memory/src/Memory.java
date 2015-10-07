/*
* Author : Austin Haggard, ahaggard2013@my.fit.edu
* Course : CSE 2010, Section 01, Fall 2014
* Project: Lab 3, Memory
*/

import java.util.Arrays;

/**
 * @author ahaggard2013
 *         <p>
 *         makes it possible to edit and create memory
 */
public class Memory {
	/**
	 * Constant used for <code>Integer</code> addition
	 */
	private static final int INTEGER_BYTES = 4;
	/**
	 * Contains everything put into memory
	 */
	public byte[] memoryArray;
	/**
	 * States if memory is occupied or not
	 */
	public boolean[] occupiedMemory; // boolean array representing which bytes
										// are occupied
	/**
	 * Shows where the last free byte of memory is
	 */
	public int indexOfFreeMemory = 0; // index where next object will be stored
										// in the memory

	/**
	 * Constructs an object to hold memory
	 * 
	 * @param size
	 *            how many bytes the object can hold
	 */
	public Memory(final int size) { // Constructor
		this.memoryArray = new byte[size];
		this.occupiedMemory = new boolean[size];
	}

	/**
	 * Frees memory to prepare for copying memory into the array
	 * 
	 * @param num
	 *            number of elements to allocate for
	 * @param cls
	 *            type of this element
	 * @return index of the first element
	 */
	int allocate(int num, Class<?> cls) {
		// allocate num elements of type cls in the memory array. Index of the
		// first element should be returned.
		// Class<?> cls is simply a way to pass class type in a variable
		int fill;
		int firstElement = indexOfFreeMemory;
		for (int i = 0; i < num; i++) {

			fill = TypeConverter.numberOfBytesPerClass(cls);

			for (int j = 0; j < fill; j++) {

				occupiedMemory[indexOfFreeMemory] = true;

				indexOfFreeMemory++;
			}

		}
		return firstElement;
	}

	/**
	 * Function for convenience
	 * 
	 * @param a
	 *            object to pass in
	 * @return Index of the first element
	 */
	final int allocate(Object[] a) { // convenience function - nothing to
										// implement
		// here
		return allocate(a.length, a[0].getClass());
	}

	/**
	 * Puts the bytes into the memory array
	 * 
	 * @param pointer
	 *            tells you where to start copying bytes
	 * @param objs
	 *            this is the object to copy into the memory array
	 * @return returns true when there is room to be copied (Specified that
	 *         there will always be room)
	 */
	final boolean copy(int pointer, Object[] objs) { // copy objs into memory
														// starting
		// at index pointer. True should
		// be returned if it is possible
		// (there is enough memory to
		// store all the objects), false
		// otherwise.
		byte[] bytes = new byte[objs.length
				* TypeConverter.numberOfBytesPerClass(objs[0].getClass())];
		// copies bytes into one new array
		for (int i = 0; i < objs.length; i++) {
			System.arraycopy(
					TypeConverter.toByteArray(objs[i]),
					0,
					bytes,
					TypeConverter.numberOfBytesPerClass(objs[0].getClass()) * i,
					TypeConverter.toByteArray(objs[i]).length);
		}
		// copies byte array into memory
		System.arraycopy(bytes, 0, this.memoryArray, pointer, bytes.length);
		return true;
	}

	/**
	 * Reads bytes from a specific point in the memory
	 * 
	 * @param pointer
	 *            Where to begin reading from memory
	 * @param cls
	 *            Type of class you are going to read
	 * @param num
	 *            number of elements to read from memory
	 * @return A byte array containing what was to be read
	 */
	public final byte[][] read(int pointer, Class<?> cls, int num) {
		// read array of size num of the objects of type cls starting at pointer
		// and return it
		byte[][] bytes = new byte[num][TypeConverter.numberOfBytesPerClass(cls)];
		for (int i = 0; i < num; i++) {
			System.arraycopy(this.memoryArray,
					pointer + TypeConverter.numberOfBytesPerClass(cls) * i,
					bytes[i], 0, TypeConverter.numberOfBytesPerClass(cls));
		}
		return bytes;
	}

	/**
	 * Frees all memory from memorry array
	 */
	public final void free() {
		// free everything from the memory
		Arrays.fill(this.occupiedMemory, false);
		Arrays.fill(this.memoryArray, (byte) 0);
		this.indexOfFreeMemory = 0;
	}

	/**
	 * Frees a specific location in memory
	 * 
	 * @param pointer
	 *            Specifies where to begin clearing
	 * @param cls
	 *            Type of Class to be cleared
	 * @param num
	 *            Number of elements to be cleared
	 */
	public final void free(int pointer, Class<?> cls, int num) {
		// free objects array of size num of type cls starting at pointer
		Arrays.fill(this.occupiedMemory, pointer,
				pointer + num * TypeConverter.numberOfBytesPerClass(cls), false);
		Arrays.fill(this.memoryArray, pointer,
				pointer + num * TypeConverter.numberOfBytesPerClass(cls),
				(byte) 0);
	}

	/**
	 * Makes it possible to print out your object
	 */
	public final String toString() {
		// print out which elements of the memory array are occupied and which
		// are not
		StringBuilder memory = new StringBuilder();
		memory.setLength(this.memoryArray.length);
		// finds if memory is occupied then inserts a character to represent it
		for (int i = 0; i < this.memoryArray.length; i++) {
			if (this.occupiedMemory[i])
				memory.insert(i, 'x');
			else
				memory.insert(i, 'o');
		}
		return memory.toString();
	}

	/**
	 * Prints a specific location in memory
	 * 
	 * @param pointer
	 *            Specifies where to begin printing
	 * @param cls
	 *            Type of class that will be printed
	 * @param num
	 *            number of elements to be printed
	 * @return returns a string representation of where the memory is located
	 */
	final String printLocationInMemory(int pointer, Class<?> cls, int num) {
		// return a string representing location in the memory of object array
		// of size num of type cls starting at pointer
		StringBuilder memoryLoc = new StringBuilder();
		memoryLoc.setLength(this.memoryArray.length);
		for (int i = 0; i < this.memoryArray.length; i++) {
			memoryLoc.insert(i, 'o');
		}
		for (int i = pointer; i < pointer + num
				* TypeConverter.numberOfBytesPerClass(cls); i++) {
			memoryLoc.deleteCharAt(i);
			memoryLoc.insert(i, 'x');
		}
		return memoryLoc.toString();
	}

	/**
	 * Adds two integer arrays together
	 * 
	 * @param pointer1
	 *            location of the first set of integers in memory
	 * @param pointer2
	 *            Location of the second set of integers in memory
	 * @param num
	 *            number of integers that need to be added
	 * @return Index of where the two added integers begins
	 */
	public final int addIntArrays(int pointer1, int pointer2, int num) {
		// Given two pointers of Integer array of the same size add them,
		// allocate and store result in the memory array and return it's pointer
		int newPointer = allocate(num, Integer.class);
		int[] firstNumbers = new int[num];
		int[] secondNumbers = new int[num];
		Integer[] sum = new Integer[num];
		byte[][] bytesOne = new byte[num][INTEGER_BYTES];
		byte[][] bytesTwo = new byte[num][INTEGER_BYTES];
		bytesOne = read(pointer1, Integer.class, num);
		bytesTwo = read(pointer2, Integer.class, num);
		// adds the numbers together
		for (int i = 0; i < num; i++) {
			firstNumbers[i] = TypeConverter.byteArrayToInt(bytesOne[i]);
			secondNumbers[i] = TypeConverter.byteArrayToInt(bytesTwo[i]);
			sum[i] = firstNumbers[i] + secondNumbers[i];
		}
		copy(newPointer, sum);
		return newPointer;
	}

}
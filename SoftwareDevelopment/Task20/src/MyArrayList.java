import java.util.AbstractList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: interface
 */
public class MyArrayList extends AbstractList<Integer> {
    private static final int DEFAULT = 10;
    private int[] myArray;
    private int[] myArrayTemp;
    private int size = 0;
    private int removedElement;

    private void checkRange (final int index) {
        if (size < index || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
    /*Increases the capacity of the array,
     * if necessary, to ensure that it can hold
     * at least the number of elements specified
     * by the argument
     */
    private void ensureCapacity (final int minCapacity) {
        if (myArray.length == size) {
            myArray = Arrays.copyOf(myArray, minCapacity * 2);
        }
    }
    //Constructs an empty list with an initial capacity of ten
    public MyArrayList () {
        myArray = new int[DEFAULT];
    }
    //Constructs an empty list with the specified initial capacity
    public MyArrayList (final int initialCapacity) {
       myArray = new int[initialCapacity];
    }
    /*Inserts the specified element
     * at the end of the list, return true
     * if it succeeded
     */
    public final boolean add (final Integer element) {
        ensureCapacity(size);
        myArray[size] = element;
        size++;
        return true;
    }
    //Returns the element at the specified position in this list
    public final Integer get (final int index) {
        checkRange(index);
        return myArray[index];
    }
    /*Replaces the element at the specified position in
     * this list, should return the removed element value
     */
    public final Integer set (final int index, final Integer element) {
        checkRange(index);
        removedElement = myArray[index];
        myArray[index] = element;
        return removedElement;
    }
    /*Removes the element at index specified by
     * the argument, return the removed element value.
     */
    public final Integer remove (final int index) {
        checkRange(index);
        removedElement = myArray[index];
        myArrayTemp = Arrays.copyOfRange(myArray, index + 1, size);
        for (int i = index; i < size; i++) {
            myArray[i] = myArrayTemp[i - index];
        }
        size--;
        return removedElement;
    }
    /*Find and Remove the first occurrence of the specified
     * element from this list, if it is present.
     */
    public final boolean remove (final Integer element) {
        for (int i = 0; i < size; i++) {
            if (myArray[i] == element) {
                remove(i);
                return true;
            }
        }
        return false;
    }
    //Returns the number of elements in this list
    public final int size () {
        return size;
    }
    //Removes all of the elements from this list.
    public final void clear () {
        for (int i = 0; i < size; i++) {
            remove(i);
        }
    }

    public final void add (final int index, final Integer element) {
        checkRange(index);
        ensureCapacity(index);
        final int[] temp = Arrays.copyOf(myArray, size + 1);
        for (int i = size; i > index; i--) {
            temp[i] = temp[i - 1];
        }
        size++;
        myArray[index] = element;
        for (int i = index + 1; i < size; i++) {
            myArray[i] = temp[i];
        }
    }

    public final String toString () {
        final int[] temp = new int[size];
        String stringArray = null;
        for (int i = 0; i < size; i++) {
            temp[i] = myArray[i];
        }
        stringArray = Arrays.toString(temp);
        return stringArray;
    }
}
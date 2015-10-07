/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: interface
 */

import java.util.Collections;
import java.util.List;
import java.util.Random;


public class SelectionSort {

private static final Random RNG = new Random (Long.getLong ("seed", System.nanoTime()));
    //method for selection sort
    public static void sort (final List<Integer> data) {
      int min = 0, first = 0, tempIndex = 0;
      for (int i = 0; i < data.size(); i++) {
          first = data.get(i);
          min = first;
          for (int e = i; e < data.size(); e++) {
              if (data.get(e) < min) {
                  min = data.get(e);
                  tempIndex = e;
              }
          }
      data.set(i, min);
      data.set(tempIndex, first);
      }
    }

    public static void main (final String[] args) {
        //Specifies list of length N
       final int listLength = Integer.parseInt(args[0]);
       final List<Integer> arrList = new MyArrayList();
       //creates the actual list of length N
       for (int i = 1; i < listLength + 1; i++) {
           arrList.add(i);
       }
       //shuffles arraylist
       Collections.shuffle(arrList, RNG);
       //Prints shuffled and sorted list
       System.out.printf("%s%n%s%n", "Shuffled:", arrList.toString());
       sort(arrList);
       System.out.printf("%s%n%s", "Sorted:", arrList.toString());
   }

}

/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: homework
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Homework implements Comparable<Homework> {
    int time;
    int weight;
    double ratio;
    // Creates the homework object
    public Homework(final int timeT, final int weightT, final double ratioT) {
        time = timeT;
        weight = weightT;
        ratio = ratioT;
    }
    /* overrides compareTo when sort is called
     * Then sorts based on the ratio of homework to weight
     */
    @Override
    public final int compareTo (final Homework item) {
        if (this.ratio < item.ratio) {
            return -1;
        }
        if (this.ratio > item.ratio) {
            return 1;
        } else {
            return 0;
          }
    }
    @SuppressWarnings({ "resource" })
    public static void main (final String[] args) {
        final List<Homework> probList = new ArrayList<Homework>();
        final Scanner kb = new Scanner(System.in);
        final int testCases = kb.nextInt();
        String fullTimes;
        String fullWeights;
        // loops for how many cases there are
        for (int i = 0; i < testCases; i++) {
            // loops for number of problems
            final int problemNumber = kb.nextInt();
              kb.nextLine();
              fullTimes = kb.nextLine();
              fullWeights = kb.nextLine();
              // splits the line of time and weight into an array
              final String[] times = fullTimes.split("\\s");
              final String[] weights = fullWeights.split("\\s");
              // Adds time and weight to the Homework object and sorts them by ratio
              for (int e = 0; e < problemNumber; e++) {
                final Homework problem = new Homework(
                        Integer.parseInt(times[e]),
                        Integer.parseInt(weights[e]),
                        (Double.parseDouble(times[e]) / Double
                                .parseDouble(weights[e])));
                      probList.add(problem);
                      Collections.sort(probList);
              }
              // finds the smallest sum possible
              int sumTime = 0;
              int sum = 0;
              for (int e = 0; e < problemNumber; e++) {
                  sumTime += probList.get(e).time;
                  sum += sumTime * probList.get(e).weight;
              }
         System.out.println(sum);
         probList.clear();
        }
    }
}

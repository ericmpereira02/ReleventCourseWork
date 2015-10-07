/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 002, Spring
 * Project: poem
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomPoem {

    private static final int FOURTH_ARG = 4;
    private static final int THIRD_ARG = 3;
    private static final Random RNG = new Random(Long.getLong("seed", System.nanoTime()));

    public static void main (final String[] args) {
        //Takes in arguements for the poem
        final int wordCount = Integer.parseInt(args[0]);
        final int verseCount = Integer.parseInt(args[1]);
        final String suffix1 = args[2];
        final String suffix2 = args[THIRD_ARG];
        final String rhymeSchema = args[FOURTH_ARG];
        final int verseLines = args[FOURTH_ARG].length();
        /*creates three array lists for the inputed words
         *separates them by rhyming suffixes.
         */
        final ArrayList<String> firstSuffix = new ArrayList<String>();
        final ArrayList<String> secondSuffix = new ArrayList<String>();
        final ArrayList<String> leftOverWords = new ArrayList<String>();
        final Scanner stdIn = new Scanner(System.in);
        //scans through input and separates into array lists
          while (stdIn.hasNextLine()) {
            final String wordTest = stdIn.nextLine();
            if (wordTest.endsWith(suffix1)) {
                firstSuffix.add(wordTest);
            } else if (wordTest.endsWith(suffix2)) {
                secondSuffix.add(wordTest);
            } else {
                leftOverWords.add(wordTest);
            }
        }
          /*triple nested loop for the number of verses, number of lines,
           *and words in lines
           */
        for (int i = 0; i < verseCount; i++) {
            for (int j = 0; j < verseLines; j++) {
                for (int e = 0; e < wordCount; e++) {
                    if (e == wordCount - 1) {
                        if (rhymeSchema.charAt(j) == 'A') {
                        System.out.printf
                        ("%s", firstSuffix.get(RNG.nextInt(firstSuffix.size())));
                        } else {
                            System.out.printf
                            ("%s", secondSuffix.get(RNG.nextInt(secondSuffix.size())));
                        }
                    } else {
                        if (e == 0) {
                            final String firstWordTemp =
                                    leftOverWords.get(RNG.nextInt(leftOverWords.size()));
                            final String capitol =
                                    Character.toString
                                    (firstWordTemp.charAt(0)).toUpperCase();
                            final String firstWord = capitol + firstWordTemp.substring(1);
                            System.out.printf("%s ", firstWord);
                        } else {
                            System.out.printf
                            ("%s ", leftOverWords.get(RNG.nextInt(leftOverWords.size())));

                        }
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}

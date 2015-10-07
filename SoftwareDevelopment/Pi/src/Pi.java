/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 01/02, Fall 2012
 * Project: pi
 */

import java.util.Random;

public class Pi {

    private static final int FULLSIZEPIE = 4;
    //creates a random object for throwing darts
    private static final Random RNG = new Random(Long.getLong("seed", System.nanoTime()));

    public static void main (final String[] args) {
        final int numOfDarts = Integer.parseInt(args[0]);
        double xcord, ycord, pi;
        int dartsInCircle = 0, dartsNotInCircle = 0;
        //Randomly throws the "dart" between the point 0 and 1
        for (int i = 0; i < numOfDarts; i++) {
            xcord = RNG.nextDouble();
            ycord = RNG.nextDouble();
            final double circle = (xcord * xcord) + (ycord * ycord);
            //checks if the dart hits within the circle
            if (circle <= 1) {
                dartsInCircle++;
            }
            dartsNotInCircle++;
        }
       /*calculates pi using the number of in the circle divided
        *by the number of darts thrown multiplied by four
        */
        pi = FULLSIZEPIE * ((double) dartsInCircle / (double) dartsNotInCircle);
        System.out.printf("%.6f", pi);
    }
}

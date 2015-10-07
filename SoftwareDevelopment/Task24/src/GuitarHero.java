/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: guitar
 */

import java.util.Scanner;


public class GuitarHero {

    private static final int TWELVE = 12;
    public static final int SAMPLE_RATE = 44100;

    public static void main (final String[] args) {
        final Scanner kb = new Scanner(System.in);
        //Scans through all the input
        while (kb.hasNextInt()) {
            final double i = kb.nextInt();
            final double  dur = kb.nextDouble();
            final double tone = 440.0;
            //calculates frequency
            final double frequency = (tone * Math.pow(2, (i / TWELVE)));
            final GuitarString string = new GuitarString(frequency);
            final double[] buffer = new double[(int) (SAMPLE_RATE * dur)];
            string.pluck();
            //loops through taking the front of the queue
            for (int j = 0; j < buffer.length; j++) {
                buffer[j] = string.sample() * 10000;
                string.tic();
            }
            StdAudio.play(buffer);
       }
    }
}

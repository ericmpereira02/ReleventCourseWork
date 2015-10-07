/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 01/02/03/04, Fall/Spring Year
 * Project: shuffle
 */
import java.util.Random;


public class ShuffleTest {

    private static final Random RNG = new Random
            (Long.getLong ("seed", System.nanoTime()));

    public static void main (final String[] args) {
        //Declare variables needed
        final int N = Integer.parseInt(args[0]);
        final int M = Integer.parseInt(args[1]);
        final int[] deck = new int[M];
        final int[][] output = new int[M][M];
        int row = 0;
        //shuffle the cards and count number of times i was in the j position
        //(my numbers would not equal the output and I am unsure why)
        for (int j = 0; j < M; j++) {
            for (int e = 0; e < M; e++) {
                for (int i = 0; i < M; i++) {
                   final int r = i + RNG.nextInt(M - i);
                   final int t = deck[r];
                   deck[r] = deck[i];
                   deck[i] = t;
                   output[row][r]++;
                }
            }
            row++;
        }
        //outputs the answer
        for (int e = 0; e < M; e++) {
            for (int i = 0; i < M; i++) {
             System.out.printf("%4d", output[e][i]);
            }
        System.out.println();
        }
    }
}

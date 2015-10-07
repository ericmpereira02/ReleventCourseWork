/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 01/02/03/04, Fall/Spring Year
 * Project: table
 */

public class Table {

    private static final int CHANGE_TO_PRECENT = 100;

    public static void main (final String[] args) {
        final int rowNum = Integer.parseInt(args[0]);
        // runs loop inputed amount of times
        for (int i = 0; i < rowNum; i++) {
            final int count = i + 1;
            // figures log base 2
            final double logBaseTwo = Math.log(count * count) / Math.log(2);
            // figures percent
            final double percent = ((double) count / rowNum) * CHANGE_TO_PRECENT;
            // prints in required format
            System.out.printf("%-,7d 0X%04X%,9d%,9d%9.3f%8.0f%%%n", count,
                    count, count * count, count * count * count, logBaseTwo,
                    percent);
        }
    }
}

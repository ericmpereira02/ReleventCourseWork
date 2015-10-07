/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: performance
 */
import java.util.Collections;
import java.util.Random;

public class SortTest {

    private static final int ACCURACY_OF_TEST = 25;
    private static final Random RNG = new Random(Long.getLong("seed",
            System.nanoTime()));

    public static void main (final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        final int listLength = Integer.parseInt(args[0]);
        //takes cmd line input for list type
        final Class<?> clazz = Class.forName(args[1]);
        @SuppressWarnings("unchecked")
        final
        java.util.List<Integer> list = (java.util.List<Integer>) clazz
                .newInstance();
        final StopWatch sw = new StopWatch(true);
        //creates list of length N
        for (int i = 0; i < listLength; i++) {
            list.add(i, i);
        }
        //stores time it takes to sort
        for (int j = 0; j < ACCURACY_OF_TEST; j++) {
            Collections.shuffle(list, RNG);
            sw.start();
            SelectionSort.sort(list);
            sw.stop();
        }
        //outputs avg time
        final double averageTime = sw.getAverageTime();
        System.out.printf("%.2e%n", averageTime);
    }
}

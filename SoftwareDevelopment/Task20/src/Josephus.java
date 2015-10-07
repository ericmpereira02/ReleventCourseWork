/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: josephus
 */

import java.util.List;
import java.util.ListIterator;


public class Josephus {

    private static final int TEST_ACCURACY = 10;

    public static final int kill (final List<Integer> list, final int killCount,
            final int soldiers) {
        int count = 1;
        //Do this until one soldier is left
        while (list.size() > 1) {
        final ListIterator<Integer> iter = list.listIterator();
        //move through list and remove after a certain amount of skip
            while (iter.hasNext()) {
                iter.next();
                if (count % killCount == 0) {
                    iter.remove();
                }
            count++;
            }
        }
        return list.get(0);
    }

    public static void main (final String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        int lastSoldier = 0;
        //Take command line arguments
        final int soldiers = Integer.parseInt(args[0]);
        final int killCount = Integer.parseInt(args[1]);
        //Takes necessary list from command line arguments
        final Class<?> clazz = Class.forName(args[2]);
        @SuppressWarnings("unchecked")
        final java.util.List<Integer> list = (java.util.List<Integer>) clazz
                .newInstance();
        final StopWatch sw = new StopWatch(true);
        //Loops the desired amount of times to determine accuracy
        for (int j = 0; j < TEST_ACCURACY; j++) {
            //Creates new "soldiers" every loop
            list.clear();
            for (int i = 1; i < soldiers + 1; i++) {
                list.add(i);
            }
            //Finds the last soldier alive and times it
            sw.start();
            lastSoldier = kill(list, killCount, soldiers);
            sw.stop();
        }
        //output
        System.out.printf("%s%d%n%s%f%n", "Last Soldier: ", lastSoldier,
                "Average Running Time: ", sw.getAverageTime());
    }
}

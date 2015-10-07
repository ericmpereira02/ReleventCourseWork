import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main implements Comparable<Main> {
    int time;
    int destroyed;
    double ratio;
    // constructs an object that holds time amount of flowers destroyed, and the ratio
    public Main (final int timeT, final int destroyedD, final double ratioR) {
     time = timeT;
     destroyed = destroyedD;
     ratio = ratioR;
    }
    // overrides sort and organizes the list by ratio

    public final int compareTo (final Main item) {
        if (this.ratio < item.ratio) {
            return -1;
        }
        if (this.ratio > item.ratio) {
            return 1;
        } else {
            return 0;
          }
    }

    public static void main (final String[] args) {
        final List<Main> cows = new ArrayList<Main>();
        final Scanner kb = new Scanner(System.in);
        int totalFlowers = 0;
        int time = 0;
        int destroyed = 0;
        final int numberOfCows = kb.nextInt();
        int count = numberOfCows;
        // takes input and creates all of the 'cows' and adds them to the list
        while (count > 0) {
            final int mins = kb.nextInt();
            final int destroy = kb.nextInt();
           final Main cow = new Main(mins, destroy, (double) mins / destroy);
            cows.add(cow);
            count--;
        }
        // sorts the cows
        for (int i = 0; i < numberOfCows; i++) {
            Collections.sort(cows);
        }
        // finds the total number of flowers destroyed
        for (int j = 0; j < numberOfCows; j++) {
            time = cows.get(j).time * 2;
            for (int i = j + 1; i < numberOfCows; i++) {
               destroyed = cows.get(i).destroyed;
               totalFlowers += time * destroyed;
            }

        }
        System.out.printf("%d", totalFlowers);
    }
}
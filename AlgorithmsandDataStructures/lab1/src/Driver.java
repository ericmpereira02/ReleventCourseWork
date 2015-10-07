import java.util.Random;

public class Driver {

    public static void main (String[] args) {

        final int seed = 1;
        final Random random = new Random(seed);

        final int n = 200;

        final double[][] points = new double[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = random.nextDouble() * 100;
            points[i][1] = random.nextDouble() * 100;
        }

        TriangleProblem triangleproblem = new TriangleProblem(points);

        double start = 0, end = 0;
        Triangle solution;

        System.out.println("Smallest area Triangle:");

        start = System.currentTimeMillis();
        solution = triangleproblem.calculateLowestAreaTriangle();
        end = System.currentTimeMillis();

        System.out.println(solution.toString());
        System.out.println((end - start) / 1000 + " seconds");

        System.out.println("Largest area triangle:");

        start = System.currentTimeMillis();
        solution = triangleproblem.calculateHighestAreaTriangle();
        end = System.currentTimeMillis();

        System.out.println(solution.toString());
        System.out.println((end - start) / 1000 + " seconds");
    }

}

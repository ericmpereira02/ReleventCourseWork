/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 2010, Section 02, Fall 2014
 * Project: lab 1
 */

public class Triangle {
    private static final int FOUR = 4;
    private static final double ONE_FOURTH = .25;
    private static final int POWER = 2;

    double[] a;
    double[] b;
    double[] c;
    double area;
    // creates a triangle
    public Triangle(final double[] a2, final double[] b2, final double[] c2,
            final double area2) {
        this.a = a2;
        this.b = b2;
        this.c = c2;
        this.area = area2;
    }
    // converts triangle to a String value
    public final String toString () {
        final String solution;
        solution = String
                .format("Point A: %.15f %.15f%nPoint B: %.15f %.15f%n"
                        + "Point C: %.15f %.15f%nArea: %e",
                        a[0], a[1], b[0], b[1], c[0], c[1], area);
        return solution;

    }
    // Calculates the area of the triangle
    public final double calculateArea
        (final double side1, final double side2, final double side3) {

        return ONE_FOURTH
                * Math.sqrt(FOUR
                        * Math.pow(side1, POWER)
                        * Math.pow(side2, POWER)
                        - Math.pow(
                                Math.pow(side1, POWER) + Math.pow(side2, POWER)
                                        - Math.pow(side3, POWER), POWER));

    }
}

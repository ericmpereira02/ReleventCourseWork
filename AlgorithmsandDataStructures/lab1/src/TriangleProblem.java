/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 2010, Section 02, Fall 2014
 * Project: lab 1
 */

public class TriangleProblem {

    private static final int POWER = 2;
    double[][] points;

    // constructor for Triangle problem
    public TriangleProblem(final double[][] points2) {
        this.points = points2;
    }

    public final Triangle calculateLowestAreaTriangle () {
        // Implement the function which would find the triangle of the smallest
        // area.
        // Triangle is made from 3 distinct points
        double x1, y1, x2, y2, x3, y3;
        double side1, side2, side3;
        double temp = Double.MAX_VALUE, area = 0;
        final double[] a = new double[2];
        final double[] b = new double[2];
        final double[] c = new double[2];
        final Triangle triangle = new Triangle(a, b, c, area);
        // this loop calculates the x and y points then calculates the side lengths
        for (int i = 0; i < points.length; i++) {
            x1 = points[i][0];
            y1 = points[i][1];
            for (int j = 1; j < points.length; j++) {
                x2 = points[j][0];
                y2 = points[j][1];
                side1 = Math.sqrt(Math.pow((x2 - x1), POWER)
                        + Math.pow((y2 - y1), POWER));
                for (int e = 2; e < points.length; e++) {
                    x3 = points[e][0];
                    y3 = points[e][1];
                    // exempts instances of when 2 sides are equal
                    if (j != e && e != i && i != j) {
                        side2 = Math.sqrt(Math.pow((x3 - x2), POWER)
                                + Math.pow((y3 - y2), POWER));
                        side3 = Math.sqrt(Math.pow((x3 - x1), POWER)
                                + Math.pow((y3 - y1), POWER));
                        area = triangle.calculateArea(side1, side2, side3);
                        // assigns point values when area is smaller
                        if (area <= temp) {
                            temp = area;
                            triangle.a[0] = x3;
                            triangle.a[1] = y3;
                            triangle.b[0] = x2;
                            triangle.b[1] = y2;
                            triangle.c[0] = x1;
                            triangle.c[1] = y1;
                            triangle.area = area;
                        }
                    }
                }
            }
        }
        return triangle;
    }

    public final Triangle calculateHighestAreaTriangle () {
        // Implement the function which would find the triangle of the largest
        // area.
        // Triangle is made from 3 distinct points
        double x1, y1, x2, y2, x3, y3;
        double side1, side2, side3;
        double temp = 0, area = 0;
        final double[] a = new double[2];
        final double[] b = new double[2];
        final double[] c = new double[2];
        final Triangle triangle = new Triangle(a, b, c, area);
        // this loop calculates the x and y points then calculates the side lengths
        for (int i = 0; i < points.length; i++) {
            x1 = points[i][0];
            y1 = points[i][1];
            for (int j = 1; j < points.length; j++) {
                x2 = points[j][0];
                y2 = points[j][1];
                side1 = Math.sqrt(Math.pow((x2 - x1), POWER)
                        + Math.pow((y2 - y1), POWER));
                for (int e = 2; e < points.length; e++) {
                    x3 = points[e][0];
                    y3 = points[e][1];
                    // exempts instances of when 2 sides are equal
                    if (j != e && e != i && i != j) {
                        side2 = Math.sqrt(Math.pow((x3 - x2), POWER)
                                + Math.pow((y3 - y2), POWER));
                        side3 = Math.sqrt(Math.pow((x3 - x1), POWER)
                                + Math.pow((y3 - y1), POWER));
                        area = triangle.calculateArea(side1, side2, side3);
                        // assigns point values when area is larger
                        if (area >= temp) {
                            temp = area;
                            triangle.a[0] = x3;
                            triangle.a[1] = y3;
                            triangle.b[0] = x2;
                            triangle.b[1] = y2;
                            triangle.c[0] = x1;
                            triangle.c[1] = y1;
                            triangle.area = area;
                        }
                    }
                }
            }
        }
        return triangle;
    }
}

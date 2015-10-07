/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: newtonchaos
 */
import java.awt.Color;

public class Newton {

    private static final int ITERATIONS = 100;

    public static Color pixColor (Complex number) {
        //creates a complex number for all of the colors
        final double range = 0.001;
        final Complex four = new Complex (4, 0);
        final Complex white = new Complex(1, 0);
        final Complex red = new Complex(-1, 0);
        final Complex blue = new Complex(0, 1);
        final Complex green = new Complex(0, -1);
        //iterates 100 times and changes colors depending on convergence
        for (int i = 0; i < ITERATIONS; i++) {
            final Complex z  =
                    number.times(number).times(number).times(number).minus(white);
            final Complex zDeriv = four.times(number).times(number).times(number);
            number = number.minus(z.divides(zDeriv));
            if (number.minus(white).abs() <= range) {
                return StdDraw.WHITE;
            }
            if (number.minus(red).abs() <= range) {
                return StdDraw.RED;
            }
            if (number.minus(blue).abs() <= range) {
                return StdDraw.BLUE;
            }
            if (number.minus(green).abs() <= range) {
                return StdDraw.GREEN;
            }
        }
        return StdDraw.BLACK;
    }

    public static void main (final String[] args) {
        StdDraw.show(0);
        //takes pixel size and max/min coords
        final int pix = Integer.parseInt(args[0]);
        final double min = -1;
        final double max = 1;
        final double size = 2;
        //adjusts scale and canvas size
        StdDraw.setCanvasSize(pix, pix);
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        //runs through every pixel and assigns a color
        for (int i = 0; i < pix; i++) {
           for (int e = 0; e < pix; e++) {
               final double x = min + i * size / pix;
               final double y = min + e * size / pix;
               final Complex number = new Complex(x, y);
              StdDraw.setPenColor(pixColor(number));
              StdDraw.point(x, y);
           }
        }
        StdDraw.show();
    }
}

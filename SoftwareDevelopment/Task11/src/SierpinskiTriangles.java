/* 
 * Author: Austin Haggard, ahaggard2013@my.fit.edu 
 * Course: CSE 1002, Section 02 Spring 
 * Project: sierpinskitriangles
 */
public class SierpinskiTriangles {

    private static final int FOUR = 4;
    private static final int THREE = 3;
    private static final double ONE = 1;
    //Two constants
    private static final double UPPER = Math.sqrt(THREE) / 2;

    public static void drawTriangle
    (final double x1, final double y1, final double x2,
            final double y2, final double x3, final double y3) {
        //Draws the triangle
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);
        StdDraw.show();
    }


     public static void draw
     (final int depth, final double x1, final double y1,
             final double x2, final double y2, final double x3, final double y3) {
         //ends after depth is == -1
         if (depth == -1) {
             return;
         }
         drawTriangle(x1, y1, x2, y2, x3, y3); //Draws the triangle with inputted numbers
         //calculates numbers for the bottom left square
         draw(depth - 1, x1 / 2, y1 / 2, x2 / 2, y2 / 2, x3 / 2, y3 / 2);
         //calculates numbers for the bottom right square
         draw(depth - 1, x1 / 2 + ONE / 2, y1 / 2, x2 / 2 + ONE / 2,
                 y2 / 2, x3 / 2 + ONE / 2, y3 / 2);
         //calculates the upper square
         draw(depth - 1, x1 / 2 + 5 / FOUR, y1 / 2 + UPPER / 2, x2 / 2 + ONE / FOUR,
                 y2 / 2 + UPPER / 2, x3 / 2 + ONE / FOUR, y3 / 2 + UPPER / 2);
     }

    public static void main (final String[] args) {
        //Finds the wanted depth
        final int depth = Integer.parseInt(args[0]);
        //Starting numbers
        final double x1 = 0, y1 = 0, y2 = 0, x3 = 0.5;

        draw(depth, x1, y1, ONE, y2, x3, UPPER);
    }
}

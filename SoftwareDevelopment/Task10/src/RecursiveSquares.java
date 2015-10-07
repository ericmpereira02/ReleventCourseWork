/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: recursivesquares
 */
public final class RecursiveSquares {

    private static final int FIRST_CHOICE = 1;
    private static final int SECOND_CHOICE = 2;
    private static final int THIRD_CHOICE = 3;
    private static final double SQUARE_SIZE = 0.5;
    private static final double SIZE_RATIO = 2.2;

    //Draws the squares on the screen
    public static void square (final double x, final double y, final double r) {
        StdDraw.setPenColor(StdDraw.GRAY);
        StdDraw.filledSquare(x, y, r / 2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, r / 2);
    }

    //Creates the overlapping squares from the first choice
    public static void allOverlapping
    (final double x, final double y, final double r, final int treeSize) {
        if (treeSize == 0) {
            return;
        }
        square(x, y , r);  //calling square first makes everything overlap
        //Recursively draws the squares
        allOverlapping(x - r / 2, y - r / 2, r / SIZE_RATIO, treeSize - 1);
        allOverlapping(x - r / 2, y + r / 2, r / SIZE_RATIO, treeSize - 1);
        allOverlapping(x + r / 2, y - r / 2, r / SIZE_RATIO, treeSize - 1);
        allOverlapping(x + r / 2, y + r / 2, r / SIZE_RATIO, treeSize - 1);
    }

    //Second choice where only the bottom squares overlap
    public static void onlyBottomOverlapping
    (final double x, final double y, final double r, final int treeSize) {
        if (treeSize == 0) {
            return;
        }
        //Recursively draws the squares
        onlyBottomOverlapping(x - r / 2, y + r / 2, r / SIZE_RATIO, treeSize - 1);
        onlyBottomOverlapping(x + r / 2, y + r / 2, r / SIZE_RATIO, treeSize - 1);
        square(x, y , r); //Calling square after the above two creates the wanted effect
        onlyBottomOverlapping(x - r / 2, y - r / 2, r / SIZE_RATIO, treeSize - 1);
        onlyBottomOverlapping(x + r / 2, y - r / 2, r / SIZE_RATIO, treeSize - 1);
    }

    //This method leaves the top right square overlapping
    public static void topRightOver
    (final double x, final double y, final double r, final int treeSize) {
        if (treeSize == 0) {
            return;
        }
        //Recursively draws the squares
        topRightOver(x - r / 2, y - r / 2, r / SIZE_RATIO, treeSize - 1);
        topRightOver(x - r / 2, y + r / 2, r / SIZE_RATIO, treeSize - 1);
        topRightOver(x + r / 2, y - r / 2, r / SIZE_RATIO, treeSize - 1);
        square(x, y , r); //Calling square here creates the desired effect
        topRightOver(x + r / 2, y + r / 2, r / SIZE_RATIO, treeSize - 1);
    }

    public static void main (final String[] args) {
        //Chooses which pattern to draw
        final int whichToDraw = Integer.parseInt(args[0]);
        //How many times the squares should repeat
        final int treeSize = 4;
        //Dimensions of the square
        final double x = SQUARE_SIZE, y = SQUARE_SIZE, r = SQUARE_SIZE;
        //all of the below if statements choose which pattern to draw
        if (whichToDraw == FIRST_CHOICE) {
            allOverlapping(x, y, r, treeSize);
        }
        if (whichToDraw == SECOND_CHOICE) {
            onlyBottomOverlapping(x, y, r, treeSize);
        }
        if (whichToDraw == THIRD_CHOICE) {
            topRightOver(x, y, r, treeSize);
        }
    }

}

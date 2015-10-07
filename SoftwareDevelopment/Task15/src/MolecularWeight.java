import java.io.File;
/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02 Spring
 * Project: molecularweight
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MolecularWeight {
    // Creates a custom class for String and double
    public static class Entry {
        String element;
        double weight;

        public Entry (final String theElement, final double theWeight) {
            this.element = theElement;
            this.weight = theWeight;
        }

        // method to get my element
        public final String getElement () {
            return element;
        }

        // method to get the weight
        public final double getWeight () {
            return weight;
        }
    }

    // checks if the string variable is a number
    public static boolean isNumber (final String split) {
        try {
            final int temp = Integer.parseInt(split);
        } catch (final NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main (final String[] args) throws IOException {
        // assigning scanner variables
        final File file = new File(args[0]);
        final Scanner fileInput = new Scanner(file);
        final Scanner stdIn = new Scanner(System.in);
        // creates arraylist with the custom class
        final ArrayList<Entry> strList = new ArrayList<Entry>();
        // assign delimiters
        fileInput.useDelimiter(",");
        stdIn.useDelimiter("\\.");
        // skips first line of the file
        fileInput.nextLine();
        // repeats until file is read
        while (fileInput.hasNextLine()) {
            // Skips to the symbol
            fileInput.next();
            fileInput.next();
            // Assigns symbol to element variable
            final String element = fileInput.next();
            // does the same with weight
            final double weight = fileInput.nextDouble();
            // creates an object with the two variables
            final Entry e = new Entry(element, weight);
            // adds the object to the arraylist
            strList.add(e);
            // skips to a new line
            fileInput.nextLine();
        }
        // runs while there is a next line
        while (stdIn.hasNextLine()) {
            // assigning variables to reset at the beginning of the loop
            double molWeight = 0;
            int count = 0;
            boolean unknownVar = false;
            // takes input
            final String input = stdIn.next();
            // splits it all into an array
            final String[] splited = input.trim().split("\\s+");
            // loops to check if it is an element, number, or unknown
            for (int j = 0; j < splited.length; j++) {
                for (int i = 0; i < strList.size(); i++) {
                    if (strList.get(i).getElement().equals(splited[j])) {
                        count = i;
                        molWeight = molWeight + strList.get(i).getWeight();
                        break;
                    } else if (isNumber(splited[j])) {
                        final int tempNum = Integer.parseInt(splited[j]);
                        molWeight = molWeight - strList.get(count).getWeight();
                        molWeight = molWeight + strList.get(count).getWeight()
                                * tempNum;
                        count = 0;
                        break;
                    } else if (i == strList.size() - 1) {
                        unknownVar = true;
                        break;
                    }
                }
            }
            // prints the information or prints unknown
            if (!unknownVar) {
                System.out.printf("%s %s %s %.2f %n", "Molecular weight of",
                        input.trim(), "=", molWeight);
            } else { // unknownVar = true;
                System.out.println("Unknown Molecular equation");

            }
        }
    }
}

/* 
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 01/02/03/04, Fall/Spring Year 
 * Project: students 
 */

import java.util.Scanner;


public class Students {

    private static final double NEGATIVE_TWO = -2.0;
    private static final double NEGATIVE_ONE = -1.0;
    private static final double ONE = 1.0;
    private static final double ZERO = 0.0;

    public static void main (final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int numberOfStudents = sc.nextInt();
        //creates all of the needed variables
        final String[] firstName = new String[numberOfStudents];
        final String[] lastName = new String[numberOfStudents];
        final String[] fullName = new String[numberOfStudents];
        final String[] grades = new String[numberOfStudents];
        final double[] numGrades = new double[numberOfStudents];
        final double[] deviation = new double[numberOfStudents];
        double mean = 0;
        double devStep1 = 0, devStep2 = 0;
        double stndDeviation;
        //takes in the first and last name along with the grades
        for (int i = 0; i < numberOfStudents; i++) {
            firstName[i] = sc.next();
            lastName[i] = sc.next();
            grades[i] = sc.next();
            fullName[i] = firstName[i] + " " + lastName[i];
            numGrades[i] = Integer.parseInt(grades[i]);
            mean += numGrades[i];
        }
        //calculates average
        mean = mean / numberOfStudents;
        //begins steps in finding standard deviation
        for (int i = 0; i < numberOfStudents; i++) {
            devStep1 += (numGrades[i] - mean) * (numGrades[i] - mean);
        }
        devStep2 = devStep1 / numberOfStudents;
        stndDeviation = Math.sqrt(devStep2);
        //calculates the deviation for each student
        for (int i = 0; i < numberOfStudents; i++) {
            deviation[i] = (numGrades[i] - mean) / stndDeviation;
        }
        //Assigns a letter grade based on all the scores
        for (int i = 0; i < numberOfStudents; i++) {
            if (deviation[i] > 1.0) {
                grades[i] = "A";
            }
            else if (deviation[i] <= ONE && deviation[i] > ZERO) {
                grades[i] = "B";
            }
            else if (deviation[i] <= ZERO && deviation[i] > NEGATIVE_ONE) {
                grades[i] = "C";
            }
            else if (deviation[i] <= NEGATIVE_ONE && deviation[i] > NEGATIVE_TWO) {
                grades[i] = "D";
            }
            else {
                grades[i] = "F";
            }
        }
        //formats the output
        //I was not in class so I am unsure of exact spacing, I spaced it how it looked
        System.out.printf("%-15s%11s%10s%n", "Name", "Grade", "Letter");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("%-21s%5.0f%10s%n", fullName[i], numGrades[i], grades[i]);
        }
        System.out.printf("%-21s%5.2f", "Average", mean);
    }
}

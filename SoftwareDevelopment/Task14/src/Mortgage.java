/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: bigdecimal
 */
import java.math.BigDecimal;
import java.util.Scanner;


public class Mortgage {

    private static final int ZERO = 0;

    public static void main (final String[] args) {
        Scanner input = new Scanner(System.in);
        String balSign;
        BigDecimal loanAmount = new BigDecimal (args[0]);
        final BigDecimal interestRate = new BigDecimal (args[1]);
        loanAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
        interestRate.setScale(2, BigDecimal.ROUND_HALF_UP);
        while (input.hasNext()) {
            final String inputTemp = input.next();
            if (inputTemp.equalsIgnoreCase("balance")) {
                if (loanAmount.intValue() > ZERO) {
                    balSign = "left";
                } else {
                    balSign = "over";
                }
                System.out.printf("%s: %.2f %s %n", "Balance", loanAmount.abs(), balSign);
            } else if (loanAmount.intValue() == ZERO) {
                System.out.println("0.00");
            } else {
                final BigDecimal payment = new BigDecimal(inputTemp);
                payment.setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal newLoanAmount = loanAmount.multiply(interestRate);
                newLoanAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
                newLoanAmount = loanAmount.add(newLoanAmount);
                loanAmount = newLoanAmount.subtract(payment);
            }
        }
    }
}

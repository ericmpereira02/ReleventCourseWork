/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: complex
 */

import java.util.Scanner;

public class Complex {
    private static final int POWER3 = 3;
    private final double re;   // the real part
    private final double im;   // the imaginary part

    public Complex (final double real, final double imag) {
        re = real;
        im = imag;
    }

    public final String toString () { //changes to string
        return String.format ("%.2f%c%.2fi",
            re, im >= 0 ? '+' : '-', Math.abs (im));
    }

    public final double abs () { // Math.sqrt(re*re + im*im)
        return Math.hypot (re, im);
    }

    public final Complex plus (final Complex b) { //adds complex nums
        final double real = re + b.re;
        final double imag = im + b.im;
        return new Complex (real, imag);
    }

    public final Complex times (final Complex b) { //multiplies complex nums
        final double real = re * b.re - im * b.im;
        final double imag = re * b.im + im * b.re;
        return new Complex (real, imag);
    }

    public final double theta () { //finds the angle
        return Math.atan2(im, re);
    }

    public final Complex minus (final Complex b) { //subtracts complex nums
        final double real = re - b.re;
        final double imag = im - b.im;
        return new Complex (real, imag);
    }

    final Complex conjugate () { //finds the conjugate
        final double real = re;
        final double imag = (im - im) - im;
        return new Complex (real, imag);
    }

    final Complex divides (final Complex b) { //divides complex nums
        final double real = ((re * b.re) + (im * b.im))
                /
                ((b.re * b.re) + (b.im * b.im));
        final double imag = ((im * b.re) - (re * b.im))
                /
                ((b.re * b.re) + (b.im * b.im));
        return new Complex (real, imag);

    }

    final Complex power (final int b) { //finds the power
        Complex pow = new Complex (re, im);
        for (int i = 0; i < b - 1; i++) {
            pow = pow.times(this);
        }
        return pow;
    }

    public static void main (final String[] args) { //initializes program
        final Scanner kb = new Scanner(System.in);
        double a, b, c, d; // inputs complex nums
        a = kb.nextDouble();
        b = kb.nextDouble();
        c = kb.nextDouble();
        d = kb.nextDouble();
        final Complex var = new Complex (a, b);
        final Complex var1 = new Complex (c, d);

        System.out.printf("%s%.2f%n", "angle(a) = ", var.theta());
        System.out.printf("%s%.2f%n", "angle(b) = ", var1.theta());
        System.out.println("minus = " + var.minus(var1));
        System.out.println("conjugate = " + var.conjugate());
        System.out.println("division = " + var.divides(var1));
        System.out.println("power2 = " + var.power(2));
        System.out.println("power3 = " + var.power(POWER3));


    }
}

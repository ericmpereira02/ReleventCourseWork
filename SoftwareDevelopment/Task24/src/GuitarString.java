/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: guitar
 */

import java.util.ArrayDeque;


public class GuitarString {
    private static final double HALF = .5;
    private static final double ENERGY_DECAY = .996;
    protected static final double SAMPLE_RATE = 44100;
    private final double freq;
    ArrayDeque<Double> deck;
    //Constructs guitar string
    public GuitarString (final double frequency) {
        freq = frequency;
        deck = new ArrayDeque<Double>();
    }
    //sets buffer to white noise
    final void pluck () {
        final double numberOfRnd = SAMPLE_RATE / freq;
        for (int i = 0; i < numberOfRnd; i++) {
            deck.add(Math.random());
        }
    }
    //uses the Karplus Strong algorithm
    final void tic () {
        final double first = deck.peek();
        deck.poll();
        final double second = deck.peek();
        final double avg = ((first + second) / 2) * ENERGY_DECAY;
        deck.add(avg);
    }
    //returns the front of the queue
    final double sample () {
       return deck.peek();
    }
}

/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: ringBuffer
 */

import java.util.Scanner;


public class MyQueue<T> implements Queue<T> {
    T[] ringBuffer;
    int count = 0;
    int front = 0;
    @SuppressWarnings({ "unchecked" })
    public MyQueue(final int size) {
        ringBuffer = (T[]) new Object[size];
    }
    // required by interface
    @Override
    public final boolean isEmpty () {
        // TODO Auto-generated method stub
        return false;
    }
    // takes an item from the queue
    @Override
    public final T dequeue () throws BufferEmptyException {
        T ans;
        if (count < 1) {
            throw new BufferEmptyException();
        } else {
            count--;
            ans = ringBuffer[front];
            // slides the queue over
            for (int i = 0; i < ringBuffer.length; i++) {
                if (i < ringBuffer.length - 1) {
                    ringBuffer[i] = ringBuffer[i + 1];
                } else {
                    ringBuffer[i] = null;
                }
            }
            return ans;
        }
    }
    // places an item in the queue
    @Override
    public final void enqueue (final T item) throws BufferFullException {
        final int size = ringBuffer.length - 1;
        if (count > size) {
            throw new BufferFullException();
        } else {
            ringBuffer[count] = item;
            count++;
        }

    }

    public static void main (final String[] args) {
        final int size = Integer.parseInt(args[0]);
        final Scanner kb = new Scanner(System.in);
        final Queue<Integer> buffer = new MyQueue<Integer>(size);
        while (kb.hasNext()) {
            final String enqOrDeq = kb.next();
            // places an item in the queue
            if (enqOrDeq.equals("enqueue")) {
                final int n = kb.nextInt();
                try {
                    buffer.enqueue(n);
                    System.out.println("enqueue " + n);
                } catch (final BufferFullException ex) {
                    System.out.println("Queue is full");
               }
            // takes an item from the queue
            } else {
                try {
                    System.out.println("Dequeue " + buffer.dequeue());
                } catch (final BufferEmptyException ex) {
                    System.out.println("Queue is empty");
                }
            }
        }
    }

}

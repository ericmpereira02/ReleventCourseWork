/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: ringBuffer
 */

import java.util.Scanner;


public class MyDeque<T> implements Deque<T> {
    T[] ringBuffer;
    int front = 0;
    int back = -1;
    int sizeBuffer = 0;
    @SuppressWarnings({ "unchecked" })
    public MyDeque(final int size) {
        ringBuffer = (T[]) new Object[size];
    }
    // Adds an item to the first place in the deque
    @Override
    public final void addFirst (final T item) throws BufferFullException {
        if (sizeBuffer >= ringBuffer.length) {
            throw new BufferFullException();
        }
        // if any numbers are in the front this slides them down
        if (ringBuffer[front] != null) {
            for (int i = ringBuffer.length - 1; i > 0; i--) {
                if (i > 0) {
                    ringBuffer[i] = ringBuffer[i - 1];
                } else {
                    ringBuffer[i] = null;
                }
            }
        }
        ringBuffer[front] = item;
        back++;
        sizeBuffer++;
    }
    // adds an item to the end of the deque
    @Override
    public final void addLast (final T item) throws BufferFullException {
        if (sizeBuffer >= ringBuffer.length) {
            throw new BufferFullException();
        }
        back++;
        ringBuffer[back] = item;
        sizeBuffer++;
    }
    // removes the last item in the deque 
    @Override
    public final T removeLast () throws BufferEmptyException {
        if (sizeBuffer == 0) {
            throw new BufferEmptyException();
        }
        final T ans = ringBuffer[back];
        ringBuffer[back] = null;
        back--;
        sizeBuffer--;
        return ans;
    }
    // removes the first item in the deque
    @Override
    public final T removeFirst () throws BufferEmptyException {
        if (sizeBuffer == 0) {
            throw new BufferEmptyException();
        }
        final T ans = ringBuffer[front];
        for (int i = 0; i < ringBuffer.length; i++) {
            if (i < ringBuffer.length - 1) {
                ringBuffer[i] = ringBuffer[i + 1];
            } else {
                ringBuffer[i] = null;
            }
        }
        back--;
        sizeBuffer--;
        return ans;
    }

    // required by interface
    @Override
    public final boolean isEmpty () {
        // TODO Auto-generated method stub
        return false;
    }

    public static void main (final String[] args) {
        final int size = Integer.parseInt(args[0]);
        final Scanner kb = new Scanner(System.in);
        final Deque<Integer> buffer = new MyDeque<Integer>(size);
        while (kb.hasNext()) {
            final String command = kb.next();
            // adds the frist number
            if (command.equals("addfirst")) {
                final int n = kb.nextInt();
                try {
                    buffer.addFirst(n);
                    System.out.println("addfirst " + n);
                } catch (final BufferFullException ex) {
                    System.out.println("Deque is full");
               }
              // adds the last number
            } else if (command.equals("addlast")) {
                final int n = kb.nextInt();
                try {
                    buffer.addLast(n);
                    System.out.println("addlast " + n);
                } catch (final BufferFullException ex) {
                    System.out.println("Deque is full");
               }
              // removes the last number
            } else if (command.equals("removelast")) {
                try {
                    System.out.println("removelast " + buffer.removeLast());
                } catch (final BufferEmptyException ex) {
                    System.out.println("Deque is empty");
               }
              // removes the first number
            } else if (command.equals("removefirst")) {
                try {
                    System.out.println("removefirst " + buffer.removeFirst());
                } catch (final BufferEmptyException ex) {
                    System.out.println("Deque is empty");
               }
            }
        }
    }
}

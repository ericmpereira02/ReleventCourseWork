/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 02, Spring
 * Project: stack
 */

import java.util.Scanner;

public class MyStack<T> implements Stack<T> {
    private int count = 0;
    T[] ringBuffer;
    // Contructor for my stack
    @SuppressWarnings({ "unchecked" })
    public MyStack(final int size) {
        ringBuffer = (T[]) new Object[size];
    }

    @Override
    public final boolean isEmpty () {
        // TODO Auto-generated method stub
        return false;
    }
    // Removes one item from the Stack
    @Override
    public final T pop () throws BufferEmptyException {
        if (count < 1) {
            throw new BufferEmptyException();
        } else {
            count--;
            return ringBuffer[count];
        }
    }
    // Puts an item on to the stack
    @Override
    public final void push (final T item) throws BufferFullException {
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
        final Stack<Integer> buffer = new MyStack<Integer>(size);
        // Loops until there is no more input
        while (kb.hasNext()) {
            final String pushOrPop = kb.next();
            // if the input is "push" than it pushes it onto the stack
            if (pushOrPop.equals("push")) {
                final int n = kb.nextInt();
                try {
                    buffer.push(n);
                    System.out.println("push " + n);
                } catch (final BufferFullException ex) {
                    System.out.println("Stack is full");
                }
             // if the input isn't "push" it must be pop.
             // here we remove an item from the stack
            } else {
                try {
                    System.out.println("pop " + buffer.pop());
                } catch (final BufferEmptyException ex) {
                    System.out.println("Stack is empty");
                }
            }
        }

    }
}

package com.thestapler.examples;

public class ComplexExample {

    public static void main(final String[] args) {
        System.out.println("ComplexExample start");
        
        MsgGenerator generator = new MsgGenerator();
        
        Thread thread = new Thread(generator);
        thread.start();
        
        try {
            synchronized(generator) {
                generator.wait();
            }
        } catch (InterruptedException ie) {
            System.err.println("Generator Wait Interupted!!!");
            ie.printStackTrace();
        } finally {
            System.out.println("Generator Wait End");
        }
        
        generator.printList();
        
        System.out.println("ComplexExample end");
        
    }
}

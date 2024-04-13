package com.kartheek.java.deadlock;

public class A {
    public synchronized void foo(B b) {
        System.out.println("Thread1 starts execution of foo() method");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        System.out.println("Thread1 trying to call b.last()");
        b.last();
    }

    public synchronized void last() {
        System.out.println("Inside Class A, this is last()method");
    }
}

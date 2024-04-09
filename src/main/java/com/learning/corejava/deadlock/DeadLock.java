package com.learning.corejava.deadlock;

public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();

    DeadLock() {
        Thread t = new Thread(this);
        t.start();
        System.out.println("Current Thread name -> "+Thread.currentThread().getName());
        a.foo(b);//main thread
    }
    @Override
    public void run() {
        System.out.println("Current Thread name -> "+Thread.currentThread().getName());
        b.bar(a);//child thread
    }

    public static void main(String[] args) {
        new DeadLock();//main thread
    }

}

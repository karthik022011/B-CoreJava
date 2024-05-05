package com.kartheek.multithreading.completablefuture.run;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunAsyncExample {
    public void runAsyncDefault(){
        Runnable runnable1 = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread Name" + Thread.currentThread().getName());
                System.out.println("Running task asynchronously...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        CompletableFuture<Void> taskCompletableFuture = CompletableFuture.runAsync(runnable1);
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("runAsync: " + taskCompletableFuture.isDone());
        taskCompletableFuture.join();
    }

    public void runAsyncOwnThreadPool(){
        Runnable runnable1 = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread Name" + Thread.currentThread().getName());
                System.out.println("Running task asynchronously...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<Void> taskCompletableFuture = CompletableFuture.runAsync(runnable1,executorService);
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("runAsync: " + taskCompletableFuture.isDone());
        taskCompletableFuture.join();
        executorService.shutdown();
    }
}

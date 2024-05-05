package com.kartheek.multithreading.completablefuture.parallel;

import java.util.concurrent.CompletableFuture;

public class SupplyAsyncRunParallelExample {

    public void supplyAsyncParallel(){
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try{
                // Some long-running operation
                Thread.sleep(1000);
                System.out.println("Thread Name in future1: " + Thread.currentThread().getName());
                return "Result 1";
            }catch (Exception e){
                e.printStackTrace();
                return "Exception in future1";
            }
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try{
                // Some long-running operation
                Thread.sleep(2000);
                System.out.println("Thread Name in future2: " + Thread.currentThread().getName());
                return "Result 2";
            }catch (Exception e){
                e.printStackTrace();
                return "Exception in future2";
            }
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            try{
                // Some long-running operation
                Thread.sleep(3000);
                System.out.println("Thread Name in future3: " + Thread.currentThread().getName());
                return "Result 3";
            }catch (Exception e){
                e.printStackTrace();
                return "Exception in future3";
            }
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        System.out.println("Hello from Main::" + Thread.currentThread().getName());
        allFutures.thenRun(() -> {
            // All futures completed
            String result1 = future1.join();
            String result2 = future2.join();
            String result3 = future3.join();
            System.out.println(result1 + ", " + result2 + ", " + result3);
        });
    }
}

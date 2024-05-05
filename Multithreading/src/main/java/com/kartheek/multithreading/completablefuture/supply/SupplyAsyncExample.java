package com.kartheek.multithreading.completablefuture.supply;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class SupplyAsyncExample {

    public void supplyAsyncDefault(){
        Supplier<String> supplier = () -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            return "Hi Karthik";
        };
        CompletableFuture<String> taskCompletableFuture = CompletableFuture.supplyAsync(supplier);
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("supplyAsync: " + taskCompletableFuture.isDone());
        String value = taskCompletableFuture.join();
        System.out.println("Value 1::" + value);
    }

    public void supplyAsyncOwnThreadPool(){
        Supplier<String> supplier = () -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            return "Hi Karthik";
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletableFuture<String> taskCompletableFuture = CompletableFuture.supplyAsync(supplier);
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        System.out.println("supplyAsync: " + taskCompletableFuture.isDone());
        String value = taskCompletableFuture.join();
        System.out.println("Value 1::" + value);
        executorService.shutdown();
    }

    public void supplyAsyncGet(){
        Supplier<String> supplier = () -> {
            try{
                Thread.sleep(2000);
                System.out.println("Thread Name in Supplier: " + Thread.currentThread().getName());
                return "Hi Karthik";
            }catch (Exception e){
                e.printStackTrace();
                return "Exception";
            }
        };
        CompletableFuture<String> taskCompletableFuture = CompletableFuture.supplyAsync(supplier);
        System.out.println("Started asynchronous task");
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        String value = null;
        try {
            value = taskCompletableFuture.get();
        } catch (Exception e) {
           e.printStackTrace();
        }
        System.out.println("Value 1::" + value);
    }

    public void supplyAsyncGetNow(){
        Supplier<String> supplier = () -> {
            try{
                Thread.sleep(2000);
                System.out.println("Thread Name in Supplier: " + Thread.currentThread().getName());
                return "Hi Karthik";
            }catch (Exception e){
                e.printStackTrace();
                return "Exception";
            }
        };
        CompletableFuture<String> taskCompletableFuture = CompletableFuture.supplyAsync(supplier);
        System.out.println("Started asynchronous task");
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        String value = null;
        try {
            value = taskCompletableFuture.getNow("Hi Default Value");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Value 1::" + value);
    }
}

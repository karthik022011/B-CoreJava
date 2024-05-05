package com.kartheek.multithreading.completablefuture.callback;

import java.util.concurrent.CompletableFuture;

public class SupplyAsyncAcceptExample {

    public void supplyAsyncThenAcceptAsync(){
        CompletableFuture<String> taskCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello ::supplyAsync::" + Thread.currentThread().getName());
            return "Hey";
        });
        System.out.println("Hello from Main::" + Thread.currentThread().getName());
        CompletableFuture<String> stringCompletableFuture = taskCompletableFuture.thenApplyAsync(data -> {
            System.out.println("Hello ::thenApplyAsync::" + Thread.currentThread().getName());
            return data + " Developers!";
        });
        String result = stringCompletableFuture.join();
        System.out.println(result);
    }

    public void supplyAsyncThenAccept(){
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello World");
        future.thenAccept(s -> System.out.println(s));
    }
}

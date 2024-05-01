package com.kartheek.multithreading.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncServiceImpl implements AsyncService{

    @Async
    @Override
    public void asyncMethod() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Calling other service..");
        System.out.println("Thread: " + Thread.currentThread().getName());
    }
}

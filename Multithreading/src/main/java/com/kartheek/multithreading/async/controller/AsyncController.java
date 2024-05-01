package com.kartheek.multithreading.async.controller;

import com.kartheek.multithreading.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;
    @GetMapping("/async")
    public String asyncCallerMethod() throws InterruptedException {
        long start = System.currentTimeMillis();
        asyncService.asyncMethod();
        String response = "task completes in :" +
                (start -   System.currentTimeMillis()) + "milliseconds";
        return response;
    }
}

package com.kartheek.java8.lambda.foreach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ForEachApplication {
    public static void main(String[] args) {
       // SpringApplication.run(ForEachApplication.class, args);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //traditional for-each
        for (Integer number : list) {
            System.out.println(number);
        }

        //using lambda
        //Lambda Expression with single paraameter
        list.forEach(number -> System.out.println(number));
        // Without lambda expression, using method reference
        list.forEach(System.out::println);
    }
}

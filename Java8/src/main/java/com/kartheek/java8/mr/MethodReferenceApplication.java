package com.kartheek.java8.mr;


import com.kartheek.java8.mr.constructor.Person1;
import com.kartheek.java8.mr.constructor.PersonConstructor;
import com.kartheek.java8.mr.object.Display;
import com.kartheek.java8.mr.object.Person;
import com.kartheek.java8.mr.staticmethod.Multiplication;
import com.kartheek.java8.mr.staticmethod.MultiplyFunction;
import java.util.function.Supplier;

public class MethodReferenceApplication {
    public static void main(String[] args) {
        //Static Method
        MultiplyFunction multiplyFunction  = Multiplication::toMultiply;
        int result = multiplyFunction.multiply(5, 3);
        System.out.println("Result of multiplication: " + result);//15

        //Object Method Using Custom Functional Interface
        Person person = new Person("Karthik");
        Display printName = person::getName;
        String name = printName.display();
        System.out.println(name);//Karthik

        //Using Constructor
        PersonConstructor personConstructor = Person1::new;
        Person1 person1 = personConstructor.create("Karthik Reddy");
        System.out.println(person1.getName());//Karthik Reddy
    }
}

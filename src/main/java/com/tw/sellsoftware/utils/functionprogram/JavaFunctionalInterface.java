package com.tw.sellsoftware.utils.functionprogram;

import java.util.function.Consumer;
import java.util.function.Function;

public class JavaFunctionalInterface {

    public static void main(String[] args) {
        consumerTest();
        functionTest();
    }

    public static void consumerTest() {
        Consumer consumer1 = System.out::println;
        Consumer consumer2 = o -> System.out.println("consumer2:" + o);
        consumer1.andThen(consumer2).accept("Today is friday!");
        consumer1.andThen(consumer1).andThen(consumer1).andThen(consumer2).accept("Tomorrow is Saturday");
    }

    public static void functionTest() {
        Function<Integer, Integer> function1 = num -> ++num;
        Function<Integer, Integer> function2 = num -> num * 2;
        System.out.println(function1.compose(function2).apply(1));
        System.out.println(function1.andThen(function2).apply(2));
        System.out.println(Function.identity().apply(3));
    }
}

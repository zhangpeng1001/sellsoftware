package com.tw.sellsoftware.utils.functionprogram;

import java.util.function.Consumer;

public class JavaFunctionalInterface {

    public static void main(String[] args) {
        consumerTest();
    }
    public static void consumerTest() {
        Consumer consumer1 = System.out::println;
        Consumer consumer2 = o->System.out.println("consumer2:"+o);
        consumer1.andThen(consumer2).accept("Today is friday!");
        consumer1.andThen(consumer1).andThen(consumer1).andThen(consumer2).accept("Tomorrow is Saturday");
    }
}

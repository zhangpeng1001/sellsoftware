package com.tw.sellsoftware.utils.functionprogram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JavaStream {

    public static void main(String[] args) {

    }

    public static void streamCreate() {
        Stream stream1 = Stream.empty();
        List<String> list = Arrays.asList("1", "2", "3", "4");
        Stream stream2 = list.stream();
        Stream parallStream = list.parallelStream();
    }

    public void studyStreamOfJava8() {
        Stream<String> stream = Stream.of("t1", "t2", "t3", "t4");
    }
}

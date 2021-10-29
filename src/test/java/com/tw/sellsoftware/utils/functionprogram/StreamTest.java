package com.tw.sellsoftware.utils.functionprogram;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTest {

    @Test
    public void streamCreate() {
        Stream stream1 = Stream.empty();
        assertEquals(0, stream1.count());
        List<String> list = Arrays.asList("1", "2", "3", "4");
        Stream stream2 = list.stream();
        Stream parallStream = list.parallelStream();
        Stream stream3 = Stream.of("1", "2", "3");
        assertEquals(4, stream2.count());
        assertEquals(true, parallStream.isParallel());
        assertEquals(3, stream3.count());
    }

    @Test
    public void streamOfFilter() {
        Stream<String> stream = getStream();
        assertEquals(4, stream.filter(s -> s.contains("t")).count());
    }

    @Test
    public void streamOfMap() {
        Stream<String> stream = getStream();
        assertEquals(true, stream.map(s -> s.concat("a")).allMatch(s -> s.contains("a")));
    }

    @Test
    public void streamOfFlatMap() {
        Stream<String> stream = getStream();
        assertEquals(9, stream.flatMap(s -> Stream.of(s.split(""))).count());
    }

    @Test
    public void streamOfReduceOfOptional() {
        Stream<String> stream = getStream();
        assertEquals(true, stream.reduce((a, b) -> a + "|" + b).isPresent());
    }

    @Test
    public void streamOfReduceOfBinaryOperator() {
        Stream<String> stream = getStream();
        assertEquals("|t1|t2|t3|t4|1", stream.reduce("", (a, b) -> a + "|" + b));
    }

    @Test
    public void streamOfReduceOfBinaryOperatorAndCombiner() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        assertEquals("25",stream.reduce("10",(a,b)->{
            b = Integer.parseInt(a) +b;
            return b.toString();
        },(a,b)->null));
    }

    @Test
    public void streamOfMapReduceOfBinaryOperatorAn() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        assertEquals(30,stream.map(a->a*2).reduce(0,(a,b)->a+b));
    }

    private Stream<String> getStream() {
        return Stream.of("t1", "t2", "t3", "t4", "1");
    }
}

package org.prcode.functional.stream.middle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamDataPickDemo {

    @Test
    public void filterTest() {
        Stream<Integer> stream = Stream.of(1, 23, 4, 5, 6);
        List<Integer> result = stream.filter(i -> i > 5).collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void distinctTest() {
        Stream<Integer> stream = Stream.of(1, 1, 2, 2, 4);
        List<Integer> result = stream.distinct().collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void limitTest() {
        Stream<Integer> stream = Stream.of(1, 3, 5, 7, 5);
        List<Integer> result = stream.limit(4).collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void skipTest() {
        Stream<Integer> stream = Stream.of(1, 3, 5, 7, 5);
        List<Integer> result = stream.skip(3).collect(Collectors.toList());
        System.out.println(result);
    }
}

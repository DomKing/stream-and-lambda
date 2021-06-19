package org.prcode.functional.stream.create;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author kangd001
 * @date 2021/6/15 15:41
 */
public class StreamCreateDemo {

    @Test
    public void arraysCreateTest() {
        String[] strings = {"I", "am", "arrays", "demo"};
        int[] nums = {1, 0, 0, 8, 6};
        Arrays.stream(strings).forEach(System.out::println);
        Arrays.stream(nums, 2, 5).forEach(System.out::println);
    }

    @Test
    public void collectionCreateTest() {
        List<Integer> integers = Arrays.asList(1, 2, 9, 11, 5, 7, 3);
        integers.stream().sorted().forEach(System.out::println);
        integers.parallelStream().sorted().forEachOrdered(System.out::println);
    }

    @Test
    public void emptyTest(){
        Stream<Integer> empty = Stream.empty();
        System.out.println(empty.findFirst().orElse(-1));

        empty = Stream.empty();
        empty.forEach(System.out::println);
    }

    @Test
    public void endlessGenerateTest() {
        Stream<Integer> generate = Stream.generate(() -> new SecureRandom().nextInt());
        AtomicLong al = new AtomicLong(0);
        generate.forEach(integer -> System.out.println(al.incrementAndGet() + " : " + integer));
    }

    @Test
    public void limitGenerateTest() {
        Stream<Integer> generate = Stream.generate(() -> {
            System.out.println("#######");
            return new SecureRandom().nextInt();
        });
        AtomicLong al = new AtomicLong(0);
        generate.limit(3).forEach(integer -> System.out.println(al.incrementAndGet() + " : " + integer));
    }

    @Test
    public void ofTest() {
        Stream<String> strStream = Stream.of("this is stream.of demo");
        strStream.forEach(System.out::println);

        Stream<Integer> intStream = Stream.of(1, 0, 0, 8, 6);
        intStream.forEach(System.out::println);

        List<String> list = Arrays.asList("i", "am", "list", "of", "method");
        Stream<List<String>> listStream = Stream.of(list);
        listStream.forEach(System.out::println);
    }

    @Test
    public void iterateTest() {
        Stream.iterate(1, iter -> iter + 3).limit(5).forEach(System.out::println);
    }

    @Test
    public void concatTest1() {
        Stream<Integer> first = Stream.of(1, 3, 5);
        Stream<Integer> second = Stream.of(2, 3, 4);
        System.out.println(Stream.concat(first, second).parallel().findFirst().orElse(-1));
    }

    @Test
    public void concatTest2() {
        Stream<Integer> first = Stream.of(1, 3, 5).parallel();
        Stream<Integer> second = Stream.of(2, 3, 4);
        Stream.concat(first, second).map(i -> i + " ").forEach(System.out::print);
    }

    @Test
    public void concatTest3() {
        Stream<Integer> first = Stream.of(1, 3, 5);
        Stream<Integer> second = Stream.of(2, 3, 4);
        System.out.println(Stream.concat(first, second).collect(Collectors.toList()));
        Stream.concat(first, second).map(i -> i + " ").forEach(System.out::print);
    }

}

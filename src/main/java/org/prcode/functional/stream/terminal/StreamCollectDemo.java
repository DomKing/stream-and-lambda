package org.prcode.functional.stream.terminal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kangd001
 * @date 2021/7/12 20:49
 */
public class StreamCollectDemo {

    @Test
    public void collectTest() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        ArrayList<Integer> collect = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(collect);
    }

    @Test
    public void collectTest2() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        List<Integer> collect = stream.collect(Collectors.toList());
        System.out.println(collect);
    }

}

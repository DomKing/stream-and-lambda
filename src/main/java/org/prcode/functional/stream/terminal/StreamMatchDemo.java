package org.prcode.functional.stream.terminal;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author kangd001
 * @date 2021/6/28 21:29
 */
public class StreamMatchDemo {


    @Test
    public void matchTest() {
        List<Integer> integers = Arrays.asList(1, 23, 4, 5, 6, 7, 0);
        System.out.println(integers.stream().allMatch(i -> i > 5));
        System.out.println(integers.stream().anyMatch(i -> i > 5));
        System.out.println(integers.stream().noneMatch(i -> i > 5));
    }

    @Test
    public void emptyStreamMatchTest() {
        List<Integer> integers = Collections.emptyList();
        //预计返回 false，实际是 true
        System.out.println(integers.stream().allMatch(i -> i > 5));
        System.out.println(integers.stream().anyMatch(i -> i > 5));
        System.out.println(integers.stream().noneMatch(i -> i > 5));
    }

    @Test
    public void myAllMatchTest() {
        List<Integer> integers = Collections.emptyList();
        System.out.println(allMatch(integers, i -> i > 5));
    }

    public boolean allMatch(List<Integer> integers, Predicate<Integer> p) {
        Objects.requireNonNull(integers);
        boolean b = true;
        for (Integer integer : integers) {
            if (!p.test(integer)) {
                b = false;
                break;
            }
        }
        return b;
    }
}

package org.prcode.functional.stream.terminal;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author kangd001
 * @date 2021/6/28 22:29
 */
public class StreamFindDemo {

    @Test
    public void findAnyTest() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().findAny().ifPresent(System.out::println);
        integers.parallelStream().findAny().ifPresent(System.out::println);
    }

    @Test
    public void findFirstTest() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.stream().findFirst().ifPresent(System.out::println);
        integers.parallelStream().findFirst().ifPresent(System.out::println);
    }
}

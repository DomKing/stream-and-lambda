package org.prcode.functional.stream.terminal;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author kangd001
 * @date 2021/6/29 21:24
 */
public class StreamCountDemo {

    @Test
    public void countTest() {
        long count = Stream.of(1, 1, 2, 2, 3).count();
        System.out.println(count);
    }

    @Test
    public void minMaxTest() {
        Optional<Integer> min = Stream.of(1, 2, 3, 4, 5).min(Comparator.naturalOrder());
        System.out.println(min.get());

        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5).max(Comparator.naturalOrder());
        System.out.println(max.get());
    }
}

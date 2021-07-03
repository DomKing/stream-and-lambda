package org.prcode.functional.stream.terminal;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

/**
 * @author kangd001
 * @date 2021/6/29 17:27
 */
public class StreamForeach {

    @Test
    public void foreachTest() {
        List<String> strings = Arrays.asList("this", "is", "foreachTest");

        System.out.println("原始顺序");
        strings.forEach(s -> System.out.print(s + " "));

        System.out.println("\n\n串行流的 foreach");
        strings.stream().forEach(
                s -> System.out.println(Thread.currentThread().getName() + ":" + s)
        );

        System.out.println("\n并行流的 foreach");
        strings.parallelStream().forEach(
                s -> System.out.println(Thread.currentThread().getName() + ":" + s)
        );

        System.out.println("\n串行流的 foreachOrdered");
        strings.stream().forEachOrdered(
                s -> System.out.println(Thread.currentThread().getName() + ":" + s)
        );

        System.out.println("\n并行流的 foreachOrdered");
        strings.parallelStream().forEachOrdered(
                s -> System.out.println(Thread.currentThread().getName() + ":" + s)
        );

        String[] strings1 = strings.parallelStream().toArray(value -> {
            System.out.println(value);
            return new String[]{"this", "is", "test"};
        });
        System.out.println(strings1);
    }
}

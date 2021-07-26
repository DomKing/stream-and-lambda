package org.prcode.functional.stream.ifelse;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kangd001
 * @date 2021/7/14 20:22
 */
public class IfElseDemo {

    @Test
    public void ifFilterDemo() {
        List<String> names = Arrays.asList("zhangs", "lis", "wangw", "zhaol");
        List<String> newNames = names.stream().filter(s -> s.contains("s")).collect(Collectors.toList());
        System.out.println(newNames);
    }

    @Test
    public void ifElseDemo() {
        List<String> names = Arrays.asList("zhangs", "lis", "wangw", "zhaol");

        names.forEach(s -> {
            if (s.contains("s")) {
                System.out.println(s + " contains s");
            } else {
                System.out.println(s + " not contains s");
            }
        });
        System.out.println("----------------");

        List<String> names1 = names.stream().filter(s -> s.contains("s")).collect(Collectors.toList());
        List<String> names2 = names.stream().filter(s -> !s.contains("s")).collect(Collectors.toList());
        names1.forEach(s -> System.out.println(s + " contains s"));
        names2.forEach(s -> System.out.println(s + " not contains s"));
        System.out.println("----------------");

        Map<Boolean, List<String>> nameParts =
                names.stream().collect(Collectors.partitioningBy(s -> s.contains("s")));
        nameParts.get(true).forEach(s -> System.out.println(s + " contains s"));
        nameParts.get(false).forEach(s -> System.out.println(s + " not contains s"));
        System.out.println("----------------");

        Map<Integer, List<String>> collect = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect);
    }

    @Test
    public void ifElseifElseDemo() {
        List<String> names = Arrays.asList("zhangs", "lis", "wangwu", "zhaol");
        names.stream().map(IfElseCondition::of).forEach(
                e ->
                        e.ifTrue(s -> s.contains("s"), s -> System.out.println(s + " contains s"))
                                .elsif(s -> s.length() > 5, s -> System.out.println(s + ".length > 5"))
                                .otherwise(s -> System.out.println(s + " not contains s")));
    }

}

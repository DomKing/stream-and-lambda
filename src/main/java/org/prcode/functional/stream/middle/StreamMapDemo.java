package org.prcode.functional.stream.middle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kangd001
 * @date 2021/6/22 23:14
 */
public class StreamMapDemo {

    @Test
    public void mapTest() {
        Stream<Integer> of = Stream.of(1, 23, 4);
        List<String> result = of.map(i -> "my value is " + i).collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void flatmapTest() {
        String[] strs = {"this", "is", "flatmap"};

        //将每个字符串后加上空格输出
        Arrays.stream(strs).map(str -> str + " ").forEach(System.out::print);
        System.out.println();

        //将所有的字符依次输出
        //这种没用flatmap结果就不对，简单使用map把字符串变成字符数组，流里的元素还是数组
        Arrays.stream(strs).map(str -> str.split("")).forEach(System.out::print);
        System.out.println();

        //使用flatmap，把每个字符数组再变成一个流，此时就可以正确输出
        Arrays.stream(strs).map(str -> str.split("")).flatMap(Arrays::stream).forEach(System.out::print);
        System.out.println();

        //也可以直接flatmap，把字符串直接变成一个流，输出也正确
        Arrays.stream(strs).flatMap(str -> Arrays.stream(str.split(""))).forEach(System.out::print);
    }
}

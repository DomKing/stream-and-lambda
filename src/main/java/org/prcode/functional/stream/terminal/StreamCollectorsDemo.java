package org.prcode.functional.stream.terminal;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kangd001
 * @date 2021/7/19 21:42
 */
public class StreamCollectorsDemo {

    @Test
    public void collectorTest() {
        //Collectors.toCollection 传入一个承载结果的 Supplier
        ArrayList<String> toCollection = getStrStream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Collectors.toCollection 转成 ArrayList 结果：" + toCollection);

        //Collectors.toList
        List<String> toList = getStrStream().collect(Collectors.toList());
        System.out.println("Collectors.toList 结果：" + toList);

        //Collectors.toSet
        Set<String> toSet = getStrStream().collect(Collectors.toSet());
        System.out.println("Collectors.toSet 去重后结果：" + toList);

        //Collectors.toMap 前两个参数，分别是 key 和 value 的处理
        //key 如果有重复会报错，value 如果是 null 也会报错
        //Map<String, Integer> toMap = strings.stream().collect(Collectors.toMap(
        //        Function.identity(), s -> s == null ? null : s.length()));

        //第三个参数是合并函数，我们可以用这个来去重
        Map<String, Integer> toMap = getStrStream().collect(Collectors.toMap(
                Function.identity(),
                s -> s == null ? 0 : s.length(),
                (k1, k2) -> k2));
        System.out.println("Collectors.toMap 默认 HashMap 乱序结果：" + toMap);

        //第四个参数是指定承载元素的Map，默认是使用HashMap，不过我们可以根据情况改
        toMap = getStrStream().collect(Collectors.toMap(
                Function.identity(),
                s -> s == null ? 0 : s.length(),
                (k1, k2) -> k2,
                LinkedHashMap::new));
        System.out.println("Collectors.toMap LinkedHashMap 有序结果：" + toMap);

        //toConcurrentMap 和 toMap 用法基本相同
        //注意 ConcurrentHashMap 本身 key 和 value 都不可以为null
        ConcurrentMap<String, Integer> toConcurrentMap = getStrStream().collect(Collectors.toConcurrentMap(
                //使用 Function.identity() 会报NPE
                String::valueOf,
                s -> s == null ? 0 : s.length(),
                (k1, k2) -> k2));
        System.out.println("Collectors.toConcurrentMap 结果：" + toConcurrentMap);

        // 等效于 Stream.count
        Long count = getStrStream().collect(Collectors.counting());
        System.out.println("Collectors.counting 计数结果：" + count);

        // joining 可带分隔符和左右的开始终止符
        String join = getStrStream().collect(Collectors.joining());
        System.out.println("Collectors.joining 无分隔符结果：" + join);
        join = getStrStream().collect(Collectors.joining(","));
        System.out.println("Collectors.joining 有分隔符结果：" + join);
        join = getStrStream().collect(Collectors.joining(",", "[", "]"));
        System.out.println("Collectors.joining 有分隔符和左右护法结果：" + join);

        // 等效于 Stream.min
        Optional<String> min = getStrStream().map(String::valueOf)
                .collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("Collectors.minBy 结果：" + min.orElse(""));

        // 等效于 Stream.max
        Optional<String> max = getStrStream().map(String::valueOf)
                .collect(Collectors.minBy(Comparator.reverseOrder()));
        System.out.println("Collectors.maxBy 结果：" + max.orElse(""));

        //等效于 Stream.reduce
        String reduce = getStrStream().collect(Collectors.reducing("", (s1, s2) -> s1 + "\t" + s2));
        System.out.println("Collectors.reducing 结果：" + reduce);

        Double average = getStrStream().collect(
                Collectors.averagingInt(value -> String.valueOf(value).length()));
        System.out.println("Collectors.averagingInt 平均值结果：" + average);

        IntSummaryStatistics summarizingInt = getStrStream().collect(Collectors.summarizingInt(value -> String.valueOf(value).length()));
        System.out.println("Collectors.summarizingInt 结果：" + summarizingInt);

        Integer collectingAndThen = getStrStream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
        System.out.println("Collectors.collectingAndThen 先转List再取size 结果：" + collectingAndThen);

        //等效于 Stream.map().collect()
        List<String> mapping = getStrStream().collect(
                Collectors.mapping(String::valueOf, Collectors.toList()));
        System.out.println("Collectors.mapping 结果：" + mapping);

        Map<Integer, List<String>> groupingBy = getStrStream().collect(
                Collectors.groupingBy(s -> String.valueOf(s).length()));
        System.out.println("Collectors.groupingBy 按字母个数分组结果：" + groupingBy);

        Map<Integer, Long> groupingBy2 = getStrStream().collect(
                Collectors.groupingBy(s -> String.valueOf(s).length(), Collectors.counting()));
        System.out.println("Collectors.groupingBy 按字母个数分组，分组统计个数，结果：" + groupingBy2);

        LinkedHashMap<Integer, Long> groupingBy3 = getStrStream().collect(
                Collectors.groupingBy(s -> String.valueOf(s).length(),
                        LinkedHashMap::new, Collectors.counting()));
        System.out.println("Collectors.groupingBy 按字母个数分组，分组统计个数，存放在LinkedHashMap结果：" + groupingBy3);

        //groupingByConcurrent 和 groupingBy 用法是基本是一样的
        Map<Integer, List<String>> groupingByConcurrent = getStrStream().collect(
                Collectors.groupingByConcurrent(s -> String.valueOf(s).length()));
        System.out.println("Collectors.groupingByConcurrent 按字母个数分组结果：" + groupingByConcurrent);

        //partitioningBy 和 groupingBy 的主要区别是，只能按布尔类型来分组
        Map<Boolean, List<String>> partitioningBy = getStrStream().collect(
                Collectors.partitioningBy(s -> String.valueOf(s).length() > 3));
        System.out.println("Collectors.partitioningBy 按字母长度分块，结果：" + partitioningBy);

        Map<Boolean, Long> partitioningBy2 = getStrStream().collect(Collectors.partitioningBy(s -> String.valueOf(s).length() > 3, Collectors.counting()));
        System.out.println("Collectors.partitioningBy 按字母个数分块并统计结果：" + partitioningBy2);
    }

    private Stream<String> getStrStream() {
        return Stream.of("this", "is", "the", "the", "test", null);
    }
}

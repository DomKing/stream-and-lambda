package org.prcode.functional.stream.terminal;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author kangd001
 * @date 2021/7/7 23:05
 */
public class StreamReduceDemo {

    @Test
    public void reduceTest1() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> reduce = stream.reduce(Integer::sum);
        System.out.println("sum result is " + reduce.get());

        stream = Stream.of(1, 2, 3, 4, 5);
        reduce = stream.reduce(Integer::max);
        System.out.println("max num is " + reduce.get());
    }

    @Test
    public void reduceTest2() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Integer seqSum = integers.stream().reduce(10, Integer::sum);
        System.out.println("串行流求和结果为：" + seqSum);

        Integer parallelSum = integers.parallelStream().reduce(10, Integer::sum);
        System.out.println("并行流求和结果为：" + parallelSum);

        // identity 的值在并行流时不能乱设置，不然会导致重复计算。
        // 如果要得到预期结果，要保证 accumulator.apply(identity, t) 的结果还是 t
        Integer reduce = integers.parallelStream().reduce(10, (a, b) -> {
            System.out.println(Thread.currentThread().getName() + " : a = " + a + ", b=" + b + ", sum=" + (a + b));
            return a + b;
        });
        System.out.println("并行流求和结果为：" + reduce);
    }

    @Test
    public void reduceTest3() {
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5).parallel();
        Integer reduce = intStream.reduce(3, (i1, i2) -> {
            System.out.println(Thread.currentThread().getName() + ": i1 = " + i1 + ", i2 = " + i2 + ", result = " + Math.max(i1, i2));
            return Math.max(i1, i2);
        }, (i1, i2) -> {
            System.err.println(Thread.currentThread().getName() + "# i3 = " + i1 + ", i4 = " + i2 + ", result = " + (i1 + i2));
            return i1 + i2;
        });
        System.out.println("final result is " + reduce);
    }

    @Test
    public void reduceTest4() {
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);
        Integer reduce = intStream.reduce(3, (i1, i2) -> {
            System.out.println(Thread.currentThread().getName() + ": i1 = " + i1 + ", i2 = " + i2 + ", result = " + Math.max(i1, i2));
            return Math.max(i1, i2);
        }, (i1, i2) -> {
            System.err.println(Thread.currentThread().getName() + "# i3 = " + i1 + ", i4 = " + i2 + ", result = " + (i1 + i2));
            return i1 + i2;
        });
        System.out.println("final result is " + reduce);
    }

    public static void main(String[] args) {
        ArrayList<Integer> accResult = Stream.of(1, 3, 5, 7).parallel()
                .reduce(new ArrayList<>(),
                        (integers, item) -> {
                            System.out.println("before add: " + integers);
                            System.out.println("item= " + item);
                            integers.add(item);
                            System.out.println("after add : " + integers);
                            System.out.println("In BiFunction");
                            return integers;
                        }, (integers, integers2) -> {
                            integers.addAll(integers2);
                            System.out.println("integers: " + integers);
                            System.out.println("integers2: " + integers2);
                            System.out.println("In BinaryOperator");
                            return integers;
                        });
        System.out.println("accResult: " + accResult.size());
    }

}

package org.procde.functional.functionalinterface.jdk;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * @author kangd001
 * @date 2021/6/7 17:22
 */
public class BinaryOperatorDemo {

    @Test
    public void multiply() {
        BinaryOperator<Integer> multiply = (i1, i2) -> i1 * i2;
        System.out.println(multiply.apply(3, 5));
    }

    @Test
    public void div() {
        BinaryOperator<Integer> div = (i1, i2) -> i1 / i2;
        System.out.println(div.apply(10, 5));
    }

    @Test
    public void sum() {
        BinaryOperator<Integer> sum = Integer::sum;
        System.out.println(sum.apply(2, 3));
    }

    @Test
    public void sub() {
        BinaryOperator<Integer> sub = (i1, i2) -> i1 - i2;
        System.out.println(sub.apply(4, 3));
    }

    @Test
    public void compare() {
        BinaryOperator<Integer> min = BinaryOperator.minBy(Comparator.comparingInt(i -> i));
        BinaryOperator<Integer> max = BinaryOperator.maxBy(Comparator.comparingInt(i -> i));
        System.out.println(min.apply(1,2));
        System.out.println(max.apply(1,2));
    }
}

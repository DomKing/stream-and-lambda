package org.prcode.functional.functionalinterface.jdk;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * @author kangd001
 * @date 2021/6/7 17:13
 */
public class UnaryOperatorDemo {

    @Test
    public void unaryDemo() {
        Function<Integer, Integer> squareFunc = integer -> integer * integer;
        UnaryOperator<Integer> squareUnary = integer -> integer * integer;

        System.out.println(squareFunc.apply(9));
        System.out.println(squareUnary.apply(9));
    }
}

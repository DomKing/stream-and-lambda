package org.prcode.functional.functionalinterface.jdk;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

/**
 * @author kangd001
 * @date 2021/6/7 14:35
 */
public class PredicateDemo {

    @Test
    public static void demo() {
        Predicate<Integer> p1 = integer -> integer > 10;
        Predicate<Integer> p2 = integer -> integer < 5;

        System.out.println("7 > 10 :" + p1.test(7));
        System.out.println("7 !< 5 :" + p2.negate().test(7));
        System.out.println("7 > 10 && 7 < 5 : " + p1.and(p2).test(7));
        System.out.println("0 > 10 || 0 < 5 : " + p1.or(p2).test(0));
        System.out.println("null equals null : " + Predicate.isEqual(null).test(null));
    }
}

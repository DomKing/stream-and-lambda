package org.prcode.functional.functionalinterface.jdk;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author kangd001
 * @date 2021/6/7 15:19
 */
public class ConsumerDemo {

    @Test
    public void demo() {
        Consumer<String> c1 = str -> System.out.println("this is the first time, word is " + str);
        Consumer<String> c2 = str -> System.out.println("this is the second time, word is " + str);
        List<String> stringList = Arrays.asList("I", "am", "the", "demo");

        stringList.forEach(c1);
        stringList.forEach(c1.andThen(c2));
    }
}

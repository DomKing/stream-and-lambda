package org.prcode.functional.functionalinterface.jdk;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author kangd001
 * @date 2021/6/7 16:11
 */
public class SupplierDemo {

    @Test
    public void demo() {
        Supplier<Double> random = Math::random;
        System.out.println(random.get());

        Supplier<String> s = String::new;
        String result = Stream.of("this", "is", "is", "a", "demo").findFirst().orElseGet(s);
        System.out.println(result);
    }
}

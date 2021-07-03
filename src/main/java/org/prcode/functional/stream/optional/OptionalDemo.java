package org.prcode.functional.stream.optional;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author kangd001
 * @date 2021/6/28 17:53
 */
public class OptionalDemo {

    @Test
    public void getTest() {
        Optional<String> emptyOpt = Optional.empty();
        String emptyDefault = emptyOpt.orElse("emptyStr");
        Optional<String> demoOpt = Optional.of("demo");
        String demoStr = demoOpt.orElseGet(() -> "demoStr");
        System.out.println(emptyDefault);
        System.out.println(demoStr);
    }

    @Test
    public void exceptionTest() {
        Optional<String> emptyOpt = Optional.empty();
        String value = emptyOpt.orElseThrow(() -> new RuntimeException("xxx must have a value"));
        System.out.println(value);
    }
}

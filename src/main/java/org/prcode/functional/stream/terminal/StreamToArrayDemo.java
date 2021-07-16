package org.prcode.functional.stream.terminal;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

/**
 * @author kangd001
 * @date 2021/7/7 22:09
 */
public class StreamToArrayDemo {


    @Test
    public void toArrayWithFuncNormalTest() {
        Stream<String> stringStream = Stream.of("this", "is", "toArrayWithFuncTest");
        //String[]::new 等效于 size -> new String[size]
        String[] strings = stringStream.toArray(String[]::new);
        for (String str : strings) {
            System.out.print(str + " ");
        }
    }

    @Test
    public void toArrayWithFuncWrongSizeTest() {
        Stream<String> stringStream = Stream.of("this", "is", "toArrayWithFuncTest");
        String[] strings = stringStream.toArray(size -> new String[2]);
        for (String str : strings) {
            System.out.print(str + " ");
        }
    }

    @Test
    public void toArrayWithFuncWrongTypeTest() {
        Stream<String> stringStream = Stream.of("this", "is", "toArrayWithFuncTest");
        Integer[] nums = stringStream.toArray(Integer[]::new);
        for (Integer i : nums) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void toArrayTest() {
        Stream<String> stringStream = Stream.of("this", "is", "toArrayTest");
        Object[] objects = stringStream.toArray();
        for (Object obj : objects) {
            System.out.print(obj + " ");
        }
    }
}

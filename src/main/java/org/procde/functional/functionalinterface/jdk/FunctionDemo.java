package org.procde.functional.functionalinterface.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author kangd001
 * @date 2021/6/7 10:49
 */
public class FunctionDemo {

    @Test
    public void doubleNum() {
        Function<Integer, String> d = integer -> String.valueOf(2 * integer);
        System.out.println(d.apply(10));
    }

    @Test
    public void compose() {
        Function<Integer, String> d = integer -> {
            System.out.println("real double apply begins, param is " + integer);
            return String.valueOf(2 * integer);
        };
        //先将输入的字符串转为Integer，再乘法。compose的入参可以指定，输出一定要是apply的入参
        Function<String, String> compose = d.compose(s -> {
            System.out.println("compose begins, str to integer, str is " + s);
            return Integer.valueOf(s);
        });
        System.out.println("final result is " + compose.apply("10"));
    }

    @Test
    public void andThen() {
        Function<Integer, String> d = integer -> {
            System.out.println("real double apply begins, param is " + integer);
            return String.valueOf(2 * integer);
        };

        //andThen传入的是apply的结果，处理后的类型可以指定
        Function<Integer, String> andThen = d.andThen(s -> {
            System.out.println("and then begins");
            return "after and then, result is " + s;
        });

        System.out.println(andThen.apply(10));

    }

    @Test
    public void identify() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("1", "张三"));
        list.add(new Student("2", "李四"));

        Map<String, Student> map1 = list.stream().collect(Collectors.toMap(Student::getId, s -> s));
        Map<String, Student> map2 = list.stream().collect(Collectors.toMap(Student::getId, Function.identity()));

        System.out.println(map1);
        System.out.println(map2);
    }

    @AllArgsConstructor
    @Data
    class Student{
        String id;
        String name;
    }
}

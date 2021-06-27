package org.prcode.functional.stream.middle;

import org.junit.jupiter.api.Test;
import org.prcode.functional.stream.middle.pojo.StudentComparable;
import org.prcode.functional.stream.middle.pojo.StudentNotComparable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortedDemo {

    @Test
    public void sortedStringTest() {
        List<String> list = Arrays.asList("i", "am", "sorted");
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void sortedNotComparableTest() {
        List<StudentNotComparable> students = Arrays.asList(new StudentNotComparable("zhangsan", 15), new StudentNotComparable("lisi", 23));
        students.stream().sorted().forEach(s -> System.out.println(s.getAge()));
    }

    @Test
    public void sortedComparableTest() {
        List<StudentComparable> students = Arrays.asList(new StudentComparable("zhangsan", 15), new StudentComparable("lisi", 23));
        students.stream().sorted().forEach(s -> System.out.println(s.getAge()));
    }

    @Test
    public void sortedWithComparatorTest() {
        List<StudentNotComparable> students = Arrays.asList(new StudentNotComparable("zhangsan", 15), new StudentNotComparable("lisi", 23));
        students.stream().sorted((s1, s2) -> s1.getAge() - s2.getAge()).forEach(s -> System.out.println(s.getAge()));
    }

    @Test
    public void sortedWithComparatorTest2() {
        List<StudentComparable> students = Arrays.asList(new StudentComparable("zhangsan", 15), new StudentComparable("lisi", 23));
        students.stream().sorted((s1, s2) -> s2.getAge() - s1.getAge()).forEach(s -> System.out.println(s.getAge()));
    }

    @Test
    public void peekTest() {
        List<String> list = Arrays.asList("i", "am", "sorted");
        List<Integer> totalLength = list.stream().map(String::length).peek(System.out::println).collect(Collectors.toList());
        System.out.println(totalLength);
    }
}

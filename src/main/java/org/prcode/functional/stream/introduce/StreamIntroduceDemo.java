package org.prcode.functional.stream.introduce;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kangd001
 * @date 2021/6/11 11:00
 */
public class StreamIntroduceDemo {

    @Test
    public void oldMapType() {
        List<Integer> integers = Arrays.asList(1, 2, 5, 7, 9, 11, 3);
        List<String> resList = new ArrayList<>();
        for (Integer integer : integers) {
            resList.add(String.valueOf(integer));
        }
        System.out.println(resList);
    }

    @Test
    public void streamMapType() {
        List<Integer> integers = Arrays.asList(1, 2, 5, 7, 9, 11, 3);
        List<String> resList = integers.stream().map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(resList);
    }
}

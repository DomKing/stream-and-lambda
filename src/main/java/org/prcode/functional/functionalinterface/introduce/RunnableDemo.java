package org.prcode.functional.functionalinterface.introduce;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kangd001
 * @date 2021/6/4 22:38
 */
public class RunnableDemo {

    @Test
    public void oldWay() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("十万火急，借过借过");
            }
        });
    }

    @Test
    public void functionalWay() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(() -> System.out.println("I am functional way"));
    }

}

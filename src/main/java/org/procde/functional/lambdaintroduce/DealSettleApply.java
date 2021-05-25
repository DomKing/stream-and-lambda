package org.procde.functional.lambdaintroduce;

import org.junit.jupiter.api.Test;
import org.procde.functional.lambdaintroduce.pojo.Citizen;
import org.procde.functional.lambdaintroduce.strategy.SettleStrategy;
import org.procde.functional.lambdaintroduce.strategy.impl.CertificateSettleStrategy;
import org.procde.functional.lambdaintroduce.strategy.impl.SocialInsuranceSettleStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kangd001
 * @date 2021/5/25 10:01
 */
public class DealSettleApply {

    List<Citizen> initCitizens() {
        List<Citizen> citizens = new ArrayList<>();
        citizens.add(new Citizen("张三", 23, 11, 0));
        citizens.add(new Citizen("李四", 24, 13, 0));
        citizens.add(new Citizen("王五", 25, 15, 2));
        citizens.add(new Citizen("赵六", 26, 8, 3));
        citizens.add(new Citizen("刘七", 35, 12, 3));
        citizens.add(new Citizen("宋八", 41, 0, 2));
        return citizens;
    }

    List<Citizen> filterApply(List<Citizen> citizenList, SettleStrategy strategy) {
        List<Citizen> resList = new ArrayList<>();
        for (Citizen citizen : citizenList) {
            if (strategy.test(citizen)) {
                resList.add(citizen);
            }
        }
        return resList;
    }

    @Test
    public void testStrategy() {
        List<Citizen> citizens = filterApply(initCitizens(), new CertificateSettleStrategy());
        System.out.println(citizens);

        citizens = filterApply(initCitizens(), new SocialInsuranceSettleStrategy());
        System.out.println(citizens);
    }

    @Test
    public void testAnonymous() {
        List<Citizen> citizens = filterApply(initCitizens(), new SettleStrategy() {
            @Override
            public boolean test(Citizen citizen) {
                return citizen.getAge() <=40 && citizen.getSocialInsuranceMonth() >= 12;
            }
        });

        System.out.println(citizens);
    }

    @Test
    public void testLambda() {
        List<Citizen> citizens = filterApply(initCitizens(),
                citizen -> citizen.getAge() <=40 && citizen.getSocialInsuranceMonth() >= 12);
        System.out.println(citizens);
    }

    @Test
    public void testStream() {
        Citizen first = initCitizens().stream()
                .filter(citizen -> citizen.getAge() < 35)
                .findFirst()
                .orElse(null);
        System.out.println(first);
    }

    @Test
    public void test() {
        String[] s = {"123", "345"};
        Arrays.stream(s).forEach(System.out::println);
    }

}

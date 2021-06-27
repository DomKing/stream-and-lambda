package org.prcode.functional.lambdaintroduce.strategy.impl;

import org.prcode.functional.lambdaintroduce.pojo.Citizen;
import org.prcode.functional.lambdaintroduce.strategy.SettleStrategy;

/**
 * @author kangd001
 * @date 2021/5/25 09:41
 */
public class SocialInsuranceSettleStrategy implements SettleStrategy {
    @Override
    public boolean test(Citizen citizen) {
        //不超过40岁且累计社保超过一年
        return citizen.getAge() <= 40 && citizen.getSocialInsuranceMonth() >= 12;
    }
}

package org.procde.functional.lambdaintroduce.strategy.impl;

import org.procde.functional.lambdaintroduce.pojo.Citizen;
import org.procde.functional.lambdaintroduce.strategy.SettleStrategy;

/**
 * @author kangd001
 * @date 2021/5/25 09:40
 */
public class CertificateSettleStrategy implements SettleStrategy {
    @Override
    public boolean test(Citizen citizen) {
        //不超过40岁且有国家认证的证书
        return citizen.getAge() <=40 && citizen.getCertificateLevel() > 2;
    }
}

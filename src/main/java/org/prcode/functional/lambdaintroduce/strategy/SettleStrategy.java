package org.prcode.functional.lambdaintroduce.strategy;

import org.prcode.functional.lambdaintroduce.pojo.Citizen;

/**
 * @author kangd001
 * @date 2021/5/25 09:38
 */
public interface SettleStrategy {

    /**
     * 判断是否满足落户规则
     *
     * @param citizen 居民对象
     * @return 是否满足
     */
    boolean test(Citizen citizen);
}

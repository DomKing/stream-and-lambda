package org.prcode.functional.functionalinterface.introduce.shop.service;

import org.prcode.functional.functionalinterface.introduce.shop.pojo.PayMethodInfo;

/**
 * @author kangd001
 * @date 2021/6/5 16:21
 */
@FunctionalInterface
public interface PayMethodInfoService {
    PayMethodInfo getPayMethodInfo();
}

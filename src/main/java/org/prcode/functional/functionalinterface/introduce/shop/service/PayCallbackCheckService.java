package org.prcode.functional.functionalinterface.introduce.shop.service;

import org.prcode.functional.functionalinterface.introduce.shop.pojo.PayCallbackInfo;

/**
 * @author kangd001
 * @date 2021/6/5 16:37
 */
@FunctionalInterface
public interface PayCallbackCheckService {
    boolean verify(PayCallbackInfo info);
}

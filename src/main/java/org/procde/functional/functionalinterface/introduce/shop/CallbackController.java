package org.procde.functional.functionalinterface.introduce.shop;

import org.procde.functional.functionalinterface.introduce.shop.pojo.PayCallbackInfo;
import org.procde.functional.functionalinterface.introduce.shop.service.PayCallbackCheckService;

/**
 * @author kangd001
 * @date 2021/6/5 16:11
 */
//省去requestMapping
public class CallbackController {

    public void alipayCallback(PayCallbackInfo info) throws Exception {
        checkValid(info, info1 -> {
            System.out.println("this is alipay callback, it's invalid");
            return false;
        });
        //其他的一些逻辑处理
    }

    public void wechatCallback(PayCallbackInfo info) throws Exception {
        checkValid(info, info1 -> {
            System.out.println("this is wechat callback, it's valid");
            return true;
        });
        //其他的一些逻辑处理
    }

    private void checkValid(PayCallbackInfo info, PayCallbackCheckService service) throws Exception {
        if (!service.verify(info)) {
            throw new Exception("信息校验失败，非法回调");
        }

        Runnable r = () -> System.out.println("im am r1");
    }
}

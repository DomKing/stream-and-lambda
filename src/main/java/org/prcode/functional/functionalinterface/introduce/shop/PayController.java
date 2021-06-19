package org.prcode.functional.functionalinterface.introduce.shop;

import org.prcode.functional.functionalinterface.introduce.shop.pojo.PayMethodInfo;
import org.prcode.functional.functionalinterface.introduce.shop.service.PayMethodInfoService;

/**
 * @author kangd001
 * @date 2021/6/5 16:12
 */
//减少spring依赖，不写requestMapping
public class PayController {

    public PayMethodInfo getPreparePayInfo(int payMethod) throws Exception {
        PayMethodInfo info;
        switch (payMethod) {
            case 1 :
                info = getPreparePayInfo(() -> new PayMethodInfo(1, "支付宝支付", "12345"));
                break;
            case 2:
                info = getPreparePayInfo(() -> new PayMethodInfo(2, "微信支付", "12345"));
                break;
            default:
                throw new Exception("传入支付方式不正确");
        }
        return info;
    }

    private PayMethodInfo getPreparePayInfo(PayMethodInfoService payMethodInfoService) {
        return payMethodInfoService.getPayMethodInfo();
    }
}

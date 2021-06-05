package org.prcode.functional.lambdaintroduce.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author kangd001
 * @date 2021/5/25 09:33
 */

@Data
@ToString
@AllArgsConstructor
public class Citizen {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 交社保月数
     */
    private int socialInsuranceMonth;

    /**
     * 证书等级
     */
    private int certificateLevel;

}

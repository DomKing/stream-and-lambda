package org.prcode.functional.methodreference;

import java.util.Objects;

/**
 * @author kangd001
 * @date 2021/6/10 09:27
 */
public class MethodRef {

    private String methodName;

    public static boolean isNull(String str) {
        return str == null;
    }

    public MethodRef(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public boolean nameEquals(String name) {
        return Objects.equals(methodName, name);
    }

    @Override
    public String toString() {
        return "I am " + methodName;
    }
}

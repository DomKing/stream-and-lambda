package org.prcode.functional.methodreference;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author kangd001
 * @date 2021/6/10 09:25
 */
public class MethodRefDemo {

    @Test
    public void staticRef() {

        // 普通写法
        Function<String, Boolean> isNull = s -> MethodRef.isNull(s);
        System.out.println(isNull.apply("abc"));

        isNull = MethodRef::isNull;
        System.out.println(isNull.apply(null));

        Function<Boolean, String> boolean2String = b -> String.valueOf(b);
        System.out.println(boolean2String.apply(true));

        boolean2String = String::valueOf;
        System.out.println(boolean2String.apply(false));
    }

    @Test
    public void constructorRef() {
        Function<String, MethodRef> f = s -> new MethodRef(s);
        System.out.println(f.apply("commRef").toString());

        // 要有对应参数的构造器，才可以这么写
        f = MethodRef::new;
        System.out.println(f.apply("constructorRef").toString());
    }

    @Test
    public void instanceRef() {
        Arrays.asList("I", "am", "instanceRef").forEach(System.out::println);

        //使用了实例化对象的普通方法
        MethodRef ref = new MethodRef("instanceRef");
        Supplier<String> supplier = () -> ref.getMethodName();
        System.out.println(supplier.get());

        supplier = ref::getMethodName;
        System.out.println(supplier.get());
    }

    @Test
    public void objRef() {
        MethodRef objRef = new MethodRef("objRef");

        //实例化对象，是函数式接口的第一个参数
        Function<MethodRef, String> f = methodRef -> methodRef.getMethodName();
        System.out.println(f.apply(objRef));

        f = MethodRef::getMethodName;
        System.out.println(f.apply(objRef));

        //实例化对象，是函数式接口的第一个参数
        BiFunction<MethodRef, String, Boolean> bf = (methodRef, s) -> methodRef.nameEquals(s);
        System.out.println(bf.apply(objRef, "randomRef"));

        bf = MethodRef::nameEquals;
        System.out.println(bf.apply(objRef, "randomRef"));

        List<String> list = Arrays.asList("objRef2", "I", "am");
        list.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(list);
        list.sort(String::compareTo);
        System.out.println(list);
    }

}

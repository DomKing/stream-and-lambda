package org.prcode.functional.functionalinterface.introduce;

/**
 * @author kangd001
 * @date 2021/6/5 15:48
 */
@FunctionalInterface
interface InterfaceA {
    String name();
}

@FunctionalInterface
interface InterfaceB {
    String name();
}

public class ExplicitTypeDemo {

    public void sayHello(InterfaceA interfaceA) {
        System.out.print("hello, im am " + interfaceA.name());
    }

    public void sayHello(InterfaceB interfaceB) {
        System.out.print("hello, im am " + interfaceB.name());
    }

    public static void main(String[] args) {
        ExplicitTypeDemo example = new ExplicitTypeDemo();
        example.sayHello((InterfaceA) () -> "interfaceA");
    }
}

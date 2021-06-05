package org.procde.functional.functionalinterface.introduce;

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

public class ExplicitTypeExample {

    public void sayHello(InterfaceA interfaceA) {
        System.out.print("hello, im am " + interfaceA.name());
    }

    public void sayHello(InterfaceB interfaceB) {
        System.out.print("hello, im am " + interfaceB.name());
    }

    public static void main(String[] args) {
        ExplicitTypeExample example = new ExplicitTypeExample();
        example.sayHello((InterfaceA) () -> "interfaceA");
    }
}

package org.veentoo.features.method_discovery;

/**
 * @author nagornov
 */
public class ChooseMethod {
    private A a;

    ChooseMethod(A a) {
        System.out.println("A");
    }

    ChooseMethod(B b) {
        System.out.println("B");
    }

    public static void main(String[] args) {
        A b = new B();
        new ChooseMethod(b);    // prints A
    }
}

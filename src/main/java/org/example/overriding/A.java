package org.example.overriding;

import java.io.FileNotFoundException;
import java.io.IOException;

class B{
    // constructor
    Number print() throws Exception {
        System.out.println("Class B's print.");
        return 10L;
    }

}


public class A extends B {

    Long  print() throws FileNotFoundException {
        System.out.println("Class A's print.");
        return 20L;
    }
    public static void main(String[] args) {
try {
    A a = new A();
    a.print();
    B b = new A();
    b.print();

    b = new B();
    b.print();

} catch (IOException e) {
    throw new RuntimeException(e);
} catch (Exception e) {
    throw new RuntimeException(e);
}
    }
}



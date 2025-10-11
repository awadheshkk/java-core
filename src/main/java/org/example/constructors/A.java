package org.example.constructors;


import java.util.ArrayList;
import java.util.List;

class B{
    // constructor
    B(){
        System.out.println("Class B's without parameter constructor.");
    }
    // init block
    {
        System.out.println("Class B's inti block.");
    }
    // static block
    static {
        System.out.println("Class B's static block");
    }
}


public class A extends B{
    // constructor
    A(){
        System.out.println("Class A's without parameter constructor.");
    }
// init block
    {
        System.out.println("Class A's inti block.");
    }
    // static block
    static List<String> list = new ArrayList<>();
    static {
        list.add("NJ");
        list.add("NY");
        System.out.println("Class A's static block");
    }

    public static void main(String[] args) {

        A a =  new A();
        System.out.println("----------------------------");
        a =  new A();

        /*
        *   Class A's static block
            Class A's inti block.
            Class A's without parameter constructor.
            ----------------------------
            Class A's inti block.
            Class A's without parameter constructor.

        * */


        /*
        Class B's static block
        Class A's static block
        Class B's inti block.
        Class B's without parameter constructor.
        Class A's inti block.
        Class A's without parameter constructor.
        ----------------------------
        Class B's inti block.
        Class B's without parameter constructor.
        Class A's inti block.
        Class A's without parameter constructor.
        * */
        System.out.println("==================");
        B b  =  new B();
    }
}



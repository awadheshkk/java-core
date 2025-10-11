package org.example.interfaces;

public class B implements  A{
    public static void main(String[] args) {
        A a = new B();
        a.print();
    }


    public void print(){
        System.out.println("Class B's print.");
    }
    @Override
    public int add(int i, int j) {
        return i+j;
    }
}

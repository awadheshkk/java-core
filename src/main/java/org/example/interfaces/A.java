package org.example.interfaces;

public interface A {

    public abstract int add(int i, int j);

    public default void print(){
        System.out.println("Default print.");
    }
}

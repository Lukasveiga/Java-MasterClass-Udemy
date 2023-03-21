package com.masterclass.newcontent.section11.interfaceDefaultMeth;

public interface InterfaceB {

    default void printSomething(){
        System.out.println("I am inside B interface");
    }
}

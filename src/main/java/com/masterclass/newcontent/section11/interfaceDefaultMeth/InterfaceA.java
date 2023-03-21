package com.masterclass.newcontent.section11.interfaceDefaultMeth;

public interface InterfaceA {

    default void printSomething(){
        System.out.println("I am inside A interface");
    }
}

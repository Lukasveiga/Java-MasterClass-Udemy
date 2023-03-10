package com.masterclass.oldcontent.section09.interfaceExamples;

public class DeskPhone implements ICellPhone{

    @Override
    public void powerOn() {
        System.out.println("The method has not been implemented yet.");
        
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println("The method has not been implemented yet.");
        
    }

    @Override
    public void answer() {
        System.out.println("The method has not been implemented yet.");
        
    }

    @Override
    public void callPhone(int phoneNumber) {
        System.out.println("The method has not been implemented yet.");
        
    }

    @Override
    public boolean isRinging() {
        System.out.println("The method has not been implemented yet.");
        return false;
    }
    
}

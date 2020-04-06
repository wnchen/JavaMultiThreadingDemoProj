package com.tiandao.wenbin;

public class ImmutableCounter {

    private final int counter;

    ImmutableCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    // because counter is defined as final variable, can not modify it
//    public void addCounter() {
//        counter++;
//    }
}

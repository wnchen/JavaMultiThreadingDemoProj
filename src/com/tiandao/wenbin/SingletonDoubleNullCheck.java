package com.tiandao.wenbin;

public class SingletonDoubleNullCheck {

    private volatile static SingletonDoubleNullCheck singleton;

    private SingletonDoubleNullCheck() {

    }

    public static SingletonDoubleNullCheck getInstance() {
        if (singleton == null) {
            synchronized (SingletonDoubleNullCheck.class) {
                if (singleton == null) {
                    singleton = new SingletonDoubleNullCheck();
                }
            }
        }
        return singleton;
    }
}

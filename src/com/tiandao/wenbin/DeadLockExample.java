package com.tiandao.wenbin;

public class DeadLockExample {

    private static final String ZHANG_3 = "Zhang3";
    private static final String LI_4 = "Li4";
    private static final String CHOP_1 = "chop1";
    private static final String CHOP_2 = "chop2";

    public static void main(String[] args) {

        Chopstick chopstick1 = new Chopstick(CHOP_1);
        Chopstick chopstick2 = new Chopstick(CHOP_2);

        Person zhang3 = new Person(ZHANG_3, chopstick1, chopstick2);
        Person li4 = new Person(LI_4, chopstick2, chopstick1);

        Thread thread1 = new Thread(zhang3);
        Thread thread2 = new Thread(li4);
        thread1.start();
        thread2.start();

    }
}

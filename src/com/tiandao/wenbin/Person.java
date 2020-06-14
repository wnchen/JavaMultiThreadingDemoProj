package com.tiandao.wenbin;

public class Person implements Runnable {

    private final String name;
    private final Chopstick chopstick1;
    private final Chopstick chopstick2;

    Person(String name, Chopstick chopstick1, Chopstick chopstick2) {
        this.name = name;
        this.chopstick1 = chopstick1;
        this.chopstick2 = chopstick2;
    }

    @Override
    public void run() {
        System.out.println("person " + name + " try to get chop " + chopstick1.name);
        chopstick1.getChopstick();
        System.out.println("person " + name + " got chop " + chopstick1.name + " success");
        System.out.println("person " + name + " try to get chop " + chopstick2.name);
        chopstick2.getChopstick();
        System.out.println("person " + name + " got chop " + chopstick2.name + " success");
        System.out.println("person " + name + " start eating food");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chopstick1.releaseChopstick();
        chopstick2.releaseChopstick();
    }
}

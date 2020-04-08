package com.tiandao.wenbin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Runnable {

    private final String name;

    Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i<=5; i++) {
                if (i==0) {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    //prints the initialization time for every task
                    System.out.println("Initialization Time for" + " task name - "+ name +" = " +ft.format(d));
                }
                else {
                    Date d = new Date();
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                    // prints the execution time for every task
                    System.out.println("Executing Time for task name - "+ name +" = " +ft.format(d));
                }
                Thread.sleep(1000);
            }
            System.out.println(name+" complete");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

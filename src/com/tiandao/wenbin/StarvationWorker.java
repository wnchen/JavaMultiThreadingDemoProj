package com.tiandao.wenbin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StarvationWorker {

    public synchronized void work() {

        String name = Thread.currentThread().getName();
        String fileName = name + ".txt";

        try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        ) {
            writer.write("Thread " + name + " wrote this mesasge");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        while (true) {
            System.out.println(name + " is working");

//            try {
//                wait(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}

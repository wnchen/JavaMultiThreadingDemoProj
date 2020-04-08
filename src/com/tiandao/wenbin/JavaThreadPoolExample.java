package com.tiandao.wenbin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaThreadPoolExample {

    private static final int MAX_THREAD_NO = 3;

    public static void main(String[] args) {

        // creates five tasks
        Runnable runnable1 = new Task("task 1");
        Runnable runnable2 = new Task("task 2");
        Runnable runnable3 = new Task("task 3");
        Runnable runnable4 = new Task("task 4");
        Runnable runnable5 = new Task("task 5");

        // creates a thread pool with MAX_THREAD_NO no. of threads as the fixed pool size
        ExecutorService pool = Executors.newFixedThreadPool(MAX_THREAD_NO);

        // passes the Task objects to the pool to execute
        pool.execute(runnable1);
        pool.execute(runnable2);
        pool.execute(runnable3);
        pool.execute(runnable4);
        pool.execute(runnable5);

        // pool shutdown
        pool.shutdown();
    }
}

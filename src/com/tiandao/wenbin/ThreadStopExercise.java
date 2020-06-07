package com.tiandao.wenbin;

public class ThreadStopExercise {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("thread is running");
                }
            }
        });
        thread.start();
        System.out.println("just started new thread");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        thread.stop(); // deprecated: https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
        thread.interrupt();
    }
}

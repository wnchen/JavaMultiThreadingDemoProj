package com.tiandao.wenbin;

public class ThreadOOMDemo {

    private static final int COUNTER = 10000;

    public static void main(String[] args) {
        for (int i = 0; i < COUNTER; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}

package com.tiandao.wenbin;

public class JavaVolatileExample {

    private static final String WORKER_THREAD_1 = "worker_thread_1";
    private static final String WORKER_THREAD_2 = "worker_thread_2";

    private static boolean shouldExit = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("thread 1 printing value " + i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                shouldExit = true;
                System.out.println("thread 1 change shouldExit to " + shouldExit);
            }
        });
        thread1.setName(WORKER_THREAD_1);
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 1;
                while (!shouldExit) {
                    i++;
                }
                System.out.println("thread 2 Job Done " + i);
            }
        });
        thread2.setName(WORKER_THREAD_2);
        thread2.start();
    }
}

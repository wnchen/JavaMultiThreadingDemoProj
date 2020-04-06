package com.tiandao.wenbin;

import java.util.concurrent.BlockingQueue;

@SuppressWarnings("ALL")
public class PoolThread extends Thread {
    private final BlockingQueue taskQueue;

    public PoolThread(BlockingQueue taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            Runnable task = (Runnable) taskQueue.poll();
            if (task != null) {
                task.run();
            }
        }
    }
}

package com.tiandao.wenbin;

public class ThreadCreation {

    public static void main(String[] args) {
        System.out.println("starting a new thread with extend");
        ThreadCreationWithExtend threadCreationWithExtend = new ThreadCreationWithExtend();
        threadCreationWithExtend.start();

        System.out.println("starting a new thread with implementation");
        ThreadCreationWithImpl threadCreationWithImpl = new ThreadCreationWithImpl();
        Thread newThread = new Thread(threadCreationWithImpl);
        newThread.start();

        System.out.println("main() ended");
    }
}

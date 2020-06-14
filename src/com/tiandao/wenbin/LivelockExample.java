package com.tiandao.wenbin;

public class LivelockExample {

    public static void main(String[] args) {
        Police police = new Police();
        Criminal criminal = new Criminal();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                police.giveMoney(criminal);
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                criminal.releaseHostage(police);
            }
        };
        t2.start();
    }
}

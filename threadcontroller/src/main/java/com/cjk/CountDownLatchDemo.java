package com.cjk;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"国被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach_CountryEnum(i).getRetMessage()
            ).start();
        }

        countDownLatch.await();
        System.out.println("秦国统一");
    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                        System.out.println(Thread.currentThread().getName()+"上完晚自习，走人");
                        countDownLatch.countDown();
                    },String.valueOf(i)
            ).start();
        }

        countDownLatch.await();
        System.out.println("锁门");
    }
}

package com.cjk;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
    public static void main(String[] args) {


        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("******召唤神龙");
        });


        for (int i = 0; i < 7; i++) {
            final int tempInt = i;

            new Thread().start();
        }


    }
}

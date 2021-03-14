package com.lzw.conc.conc0301.op;

import java.util.concurrent.ThreadFactory;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/12 20:34
 * @Description: TODO
 */
public class WaitAndNotify {

    public static void main(String[] args) {
        MethodClass methodClass = new MethodClass();
        Thread t1 = new Thread(() -> {
            try {
                methodClass.product();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            try {
                methodClass.customer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        t1.start();
        t2.start();
    }
}

class MethodClass {
    // 定义产生最大量
    private final int MAX_COUNT = 20;
    int productCount = 0;

    public synchronized void product() throws InterruptedException {
        while (true) {
            System.out.println(Thread.currentThread().getName() + ":::run:::" + productCount);
            Thread.sleep(10);
            if (productCount >= MAX_COUNT) {
                System.out.println("货舱已满，不必再生产");
                wait();
            } else {
                productCount++;
            }
            notifyAll();
        }
    }

    public synchronized void customer() throws InterruptedException {
        while (true) {
            System.out.println(Thread.currentThread().getName() + ":::run:::" + productCount);
            Thread.sleep(10);
            if (productCount <= 0) {
                System.out.println("货舱已经无货。。。无法消费");
                wait();
            } else {
                productCount--;
            }
            notifyAll();
        }
    }

}

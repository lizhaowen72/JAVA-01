package com.lzw.conc.conc0301;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/12 21:03
 * @Description: TODO
 */
public class RunnerMain {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runner1());
        Thread thread2 = new Thread(new Runner2());
        thread1.start();
        thread2.start();

        thread2.interrupt();
        System.out.println(Thread.activeCount());
        Thread.currentThread().getThreadGroup().list();
        System.out.println(Thread.currentThread().getThreadGroup().getParent().activeGroupCount());
        Thread.currentThread().getThreadGroup().getParent().list();
    }
}

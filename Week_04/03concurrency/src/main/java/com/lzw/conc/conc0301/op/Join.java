package com.lzw.conc.conc0301.op;

import java.sql.SQLOutput;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/12 20:23
 * @Description: TODO
 */
public class Join {
    public static void main(String[] args) {
        Object oo = new Object();
        Mythread thread1 = new Mythread("thread1 -- ");
        thread1.setOo(oo);
        thread1.start();
        System.out.println(oo);
        synchronized (oo) {
            for (int i = 0; i < 100; i++) {
                if (i == 20) {
                    try {
                        thread1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " -- " + i);
            }
        }
    }


}

class Mythread extends Thread {
    private String name;
    private Object oo;

    public void setOo(Object oo) {
        this.oo = oo;
    }

    public Mythread(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println(name + i);
            }
        }
    }
}
package com.lzw.conc.conc0302.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/15 15:56
 * @Description: TODO
 */
public class Count {
    final ReentrantLock lock = new ReentrantLock();

    public void get() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " get begin ");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " get end");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void put(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " put begin ");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " put end");
            lock.unlock();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

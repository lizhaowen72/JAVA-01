package com.lzw.conc.conc0302.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/15 15:59
 * @Description: TODO
 */
public class Count2 {
    private final ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    public void get(){
        rwlock.readLock().lock();;
        try{
            System.out.println(Thread.currentThread().getName()+" get begin ");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" get end ");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            rwlock.readLock().unlock();
        }
    }

    public void put(){
        rwlock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " put begin ");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " put end ");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            rwlock.writeLock().unlock();
        }
    }

}

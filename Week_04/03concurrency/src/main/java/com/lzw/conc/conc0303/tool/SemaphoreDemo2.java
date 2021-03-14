package com.lzw.conc.conc0303.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo2 {
    private final static int threadCount = 20;

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            es.execute(()->{
                try {
                    semaphore.acquire(3);
                    test(threadNum);
                    semaphore.release(3);
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        es.shutdown();
    }
    static void test(int threadNum) throws InterruptedException {
        System.out.println("id:"+threadNum+","+Thread.currentThread().getName());
        Thread.sleep(1000);
    }

}

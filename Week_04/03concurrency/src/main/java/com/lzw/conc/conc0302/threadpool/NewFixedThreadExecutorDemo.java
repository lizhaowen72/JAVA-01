package com.lzw.conc.conc0302.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/16 13:44
 * @Description: TODO
 */
public class NewFixedThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(16);

        for (int i = 0; i < 100; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("start:"+no);
                        Thread.sleep(1000L);
                        System.out.println("end:"+no);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");
    }
}

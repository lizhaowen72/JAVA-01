package com.lzw.conc.conc0302.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/16 13:44
 * @Description: TODO
 */
public class NewSingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 100; i++) {
            final int no = i;
            executorService.execute(()->{
                System.out.println("start:"+no);
                try {
                    Thread.sleep(1000L);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("end:"+no);
            });
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");
    }
}

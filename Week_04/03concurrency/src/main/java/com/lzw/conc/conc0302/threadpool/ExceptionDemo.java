package com.lzw.conc.conc0302.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/16 11:56
 * @Description: TODO
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        try{
            Future<Double> future = executorService.submit(() -> {
                int a = 1;
                return 10.0 / (a - 1);
            });

            double b = future.get();
            System.out.println("res:"+b);
        }catch (Exception e){
            System.out.println("catch execute");
            e.printStackTrace();
        }

        try {
            executorService.execute(()->{
                int a=1;
                float b=10/(a-1);
            });
        }catch (Exception e){
            System.out.println("catch execute");
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");
    }
}

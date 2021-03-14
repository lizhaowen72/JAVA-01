package com.lzw.conc.homework;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeWork03Sleep {
    private static ExecutorService es = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int result = newThreadPool();

        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private static int newThreadPool() {
        try {
            List<Integer> result = new CopyOnWriteArrayList<>();
            es.execute(()->result.add(sum()));
            Thread.sleep(1000);
            return result.get(0);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return -1;
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2)
            return 1;
        return fibo(a - 1) + fibo(a - 2);
    }
}

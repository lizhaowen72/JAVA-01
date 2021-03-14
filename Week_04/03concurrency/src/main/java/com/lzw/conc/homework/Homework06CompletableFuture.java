package com.lzw.conc.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Homework06CompletableFuture {
    private static ExecutorService es = Executors.newFixedThreadPool(1);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        int result = completableFuture();

        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private static int completableFuture() throws ExecutionException, InterruptedException {
        List<Integer> result = new ArrayList<>();
        CompletableFuture<Void> future = CompletableFuture.runAsync(()->{
            result.add(sum());
        },es);
        try {
            future.get();
        }finally {
            es.shutdown();
        }
        return result.get(0);

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

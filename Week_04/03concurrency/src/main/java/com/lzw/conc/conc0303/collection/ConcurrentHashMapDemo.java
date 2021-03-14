package com.lzw.conc.conc0303.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/16 13:54
 * @Description: TODO
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        demo1();
    }

    private static void demo1() {
        final Map<String, AtomicInteger> count = new ConcurrentHashMap<>();
        final CountDownLatch endLatch = new CountDownLatch(2);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                AtomicInteger oldValue = null;
                for (int i = 0; i < 5; i++) {
                    if (null == oldValue){
                        AtomicInteger zeroValue = new AtomicInteger(0);
                        oldValue = count.putIfAbsent("a",zeroValue);
                        if (null == oldValue){
                            oldValue =zeroValue;
                        }
                    }
                    oldValue.incrementAndGet();
                }
                endLatch.countDown();
            }
        };
        new Thread(task).start();
        new Thread(task).start();

        try {
            endLatch.await();;
            System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.lzw.conc.conc0302.atomic;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/16 11:44
 * @Description: TODO
 */
public class AtomicMain {
    public static void main(String[] args) {
        final AtomicCount count = new AtomicCount();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        count.add();
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("num=" + count.getNum());
    }

}

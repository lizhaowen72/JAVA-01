package com.lzw.conc.conc0302.lock;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/16 11:28
 * @Description: TODO
 */
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        final Count2 count = new Count2();
        for (int i = 0; i < 5; i++) {
            new Thread(){
                @Override
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(){
                @Override
                public void run() {
                    count.put();
                }
            }.start();
        }
    }
}

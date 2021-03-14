package com.lzw.conc.conc0302.lock;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/15 22:15
 * @Description: TODO
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        final Count count = new Count();
        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    count.get();
                }
            }.start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    count.put();
                }
            }.start();
        }
    }
}

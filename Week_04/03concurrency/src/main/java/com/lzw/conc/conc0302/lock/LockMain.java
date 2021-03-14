package com.lzw.conc.conc0302.lock;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/15 21:51
 * @Description: TODO
 */
public class LockMain {
    public static void main(String[] args) {
        Count3 count3 = new Count3();
        ThreadA threadA = new ThreadA(count3);
        threadA.setName("线程A");
        threadA.start();

        ThreadB threadB = new ThreadB(count3);
        threadB.setName("线程B");
        threadB.start();
    }
}

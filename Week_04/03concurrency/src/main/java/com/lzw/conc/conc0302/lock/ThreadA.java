package com.lzw.conc.conc0302.lock;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/15 21:52
 * @Description: TODO
 */
public class ThreadA extends Thread{
    private Count3 count3;

    public ThreadA(Count3 count3){
        this.count3=count3;
    }

    @Override
    public void run() {
        count3.add();
    }
}

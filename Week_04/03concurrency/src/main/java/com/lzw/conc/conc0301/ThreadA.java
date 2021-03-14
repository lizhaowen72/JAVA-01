package com.lzw.conc.conc0301;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/12 21:07
 * @Description: TODO
 */
public class ThreadA extends Thread{
    @Override
    public void run() {
        super.run();
        try{
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("这是线程A");
    }
}

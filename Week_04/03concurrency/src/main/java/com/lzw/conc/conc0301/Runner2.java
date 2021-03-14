package com.lzw.conc.conc0301;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/12 21:01
 * @Description: TODO
 */
public class Runner2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("进入Runner2运行状态------------"+i);
        }
        boolean res = Thread.currentThread().isInterrupted();

        boolean res1 = Thread.interrupted();

        boolean res2 = Thread.currentThread().isInterrupted();
        System.out.println("Runner2.run res ====>"+res);
        System.out.println("Runner2.run res ====>"+res1);
        System.out.println("Runner2.run res ====>"+res2);
    }
}

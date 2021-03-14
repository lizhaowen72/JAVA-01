package com.lzw.conc.conc0301;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/12 21:01
 * @Description: TODO
 */
public class Runner1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("进入Runner1运行状态------------"+i);
        }
    }
}

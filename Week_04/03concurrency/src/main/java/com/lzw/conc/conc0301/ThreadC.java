package com.lzw.conc.conc0301;

import java.util.concurrent.Callable;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/12 21:07
 * @Description: TODO
 */
public class ThreadC implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(500);
        System.out.println("这是线程A");
        return "线程C";
    }
}

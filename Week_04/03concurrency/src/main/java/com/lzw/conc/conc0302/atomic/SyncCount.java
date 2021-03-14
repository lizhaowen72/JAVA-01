package com.lzw.conc.conc0302.atomic;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/16 11:48
 * @Description: TODO
 */
public class SyncCount {

    private int num = 0;

    public synchronized int add(){
        return num++;
    }

    public int getNum(){
        return num;
    }
}

package com.lzw.conc.conc0302.atomic;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/16 11:47
 * @Description: TODO
 */
public class Count {
    private int num = 0;

    public int add(){
        return num++;
    }

    public int getNum(){
        return num;
    }

}

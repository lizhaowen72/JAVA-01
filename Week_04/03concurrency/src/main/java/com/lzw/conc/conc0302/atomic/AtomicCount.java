package com.lzw.conc.conc0302.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/16 11:43
 * @Description: TODO
 */
public class AtomicCount {

    private AtomicInteger num = new AtomicInteger();

     public int add(){
         return num.getAndIncrement();
     }

     public int getNum(){
         return num.get();
     }
}

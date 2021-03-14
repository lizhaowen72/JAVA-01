package com.lzw.conc.conc0303.collection;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo2 {

    private final static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        test();
    }
    public static void test(){
        for (int i = 0; i < 10000; i++) {
            list.add("String"+i);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (list.size()>10){
                        String content = list.get(list.size()-1);
                    }else{
                        break;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    if (list.size()<=0){
                        break;
                    }
                    list.remove(0);
                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

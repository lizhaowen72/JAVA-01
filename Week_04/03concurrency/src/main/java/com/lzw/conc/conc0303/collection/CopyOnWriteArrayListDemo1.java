package com.lzw.conc.conc0303.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/16 14:01
 * @Description: TODO
 */
public class CopyOnWriteArrayListDemo1 {
    private static final int THREAD_POOL_MAX_NUM =10;
    private List<String> mList = new ArrayList<>();

    public static void main(String[] args) {
        new CopyOnWriteArrayListDemo1().start();
    }

    private void initData(){
        for (int i = 0; i <= THREAD_POOL_MAX_NUM ; i++) {
            this.mList.add("... Line "+(i+1)+" ...");
        }
    }
    private void start(){
        initData();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_MAX_NUM);
        for (int i = 0; i < THREAD_POOL_MAX_NUM; i++) {
            executorService.execute(new ListReader(this.mList));
            executorService.execute(new ListWriter(this.mList,i));
        }
    }

    private class ListReader implements Runnable{
        private java.util.List<String> mList;

        public ListReader(java.util.List<String> list){
            this.mList = list;
        }

        @Override
        public void run() {
            if (this.mList!=null){
                for (String s : this.mList) {
                    System.out.println(Thread.currentThread().getName()+" : "+s);
                }
            }
        }
    }

    private class ListWriter implements Runnable{
        private List<String> mList;
        private int mIndex;

        public ListWriter(List<String> list,int index){
            this.mIndex = index;
            this.mList = list;
        }

        @Override
        public void run() {
            if (this.mList!=null){
                this.mList.add("... add "+mIndex+" ....");
            }
        }
    }

}

package com.lzw.conc.conc0303.tool;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(5);
        for (int i = 0; i < 10; i++) {
            new Thread(new ReadNum(i, cdl)).start();
        }
        cdl.await();
        System.out.println("====》各个子线程执行结束");
        System.out.println("====》主线程执行结束");
    }

    static class ReadNum implements Runnable {
        private int id;
        private CountDownLatch latch;

        public ReadNum(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            synchronized (this) {
                System.out.println("id:" + id + "," + Thread.currentThread().getName());
                System.out.println("线程组任务" + id + "结束，其他任务继续");
                latch.countDown();
            }
        }
    }

}

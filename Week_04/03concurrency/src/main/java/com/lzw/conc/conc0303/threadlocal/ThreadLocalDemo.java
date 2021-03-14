package com.lzw.conc.conc0303.threadlocal;

public class ThreadLocalDemo {
    private static ThreadLocal<Integer> segNum = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public ThreadLocal<Integer> getThreadLocal() {
        return segNum;
    }

    public int getNextNum() {
        segNum.set(segNum.get() + 1);
        return segNum.get();
    }

    public static void main(String[] args) {
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        SnThread client1 = new SnThread(threadLocalDemo);
        SnThread client2 = new SnThread(threadLocalDemo);
        SnThread client3 = new SnThread(threadLocalDemo);
        SnThread client4 = new SnThread(threadLocalDemo);
        client1.start();
        client2.start();
        client3.start();
        client4.start();
    }

    private static class SnThread extends Thread {
        private ThreadLocalDemo sn;

        public SnThread(ThreadLocalDemo sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread[" + Thread.currentThread().getName() + "]----》sn [" + sn.getNextNum() + "]");
            }
            sn.getThreadLocal().remove();
        }
    }

}

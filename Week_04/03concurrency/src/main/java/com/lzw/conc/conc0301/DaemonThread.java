package com.lzw.conc.conc0301;

/**
 * @Auther: lizhaowen
 * @Date: 2021/2/12 20:48
 * @Description: TODO
 *
 */
public class DaemonThread {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("当前线程:"+Thread.currentThread().getName());
            }
        };
        Thread thread = new Thread(task);
        thread.setName("test-thread-1");
        // 守护线程设置为false时，输出 当前线程:test-thread-1  ，为true时不输出
        thread.setDaemon(true);
        thread.start();
    }
}

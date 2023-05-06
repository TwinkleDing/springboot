package com.example.spring.study.xiancheng;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author TwinkleDing
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        callable();
    }

    static void thread() {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    static void runnable() {
        MyRun myRun = new MyRun();
        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    static void callable() throws ExecutionException, InterruptedException {
        // 可以获取到多线程运行的结果
        // 重写call
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread t1 = new Thread(ft);
        t1.start();
        int res = ft.get();
        System.out.println(res);
    }
}

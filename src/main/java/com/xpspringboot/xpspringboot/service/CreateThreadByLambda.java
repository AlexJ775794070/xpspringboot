package com.xpspringboot.xpspringboot.service;

/**
 * lambda用于创建线程
 */
public class CreateThreadByLambda {
    public void createThread() {
        //以前通过匿名内部类重写run方法，现在使用lambda表达式可以这样写run方法


        /**
         * thread接收的是一个runable接口
         * public Thread(Runnable target)
         *
         * Runnable的定义就是一个函数式接口
         * @FunctionalInterface
         * public interface Runnable {
         *
         * 所以可以用lambda表达式实现这个函数式接口，返回这个函数式接口的实列
         * 作为参数传入thread
         */
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(2 + ":" + i);
            }
        });
        t.start();
    }
}

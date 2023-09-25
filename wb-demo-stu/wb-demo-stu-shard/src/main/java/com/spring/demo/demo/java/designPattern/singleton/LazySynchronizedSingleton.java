package com.spring.demo.demo.java.designPattern.singleton;


/**
 * 简单升级懒汉式单例（同步锁）
 * 优点：升级之后的程序能完美地解决线程安全问题
 * 缺点：但是用synchronized加锁时，在线程数量较多的情况下，会导致大批线程阻塞，从而导致程序性能大幅下降
 */
public class LazySynchronizedSingleton {

    private static LazySynchronizedSingleton instance;

    private LazySynchronizedSingleton() {

    }
    public synchronized static LazySynchronizedSingleton getInstance(){
        if (instance == null){
            instance = new LazySynchronizedSingleton();
        }
        return  instance;
    }

}
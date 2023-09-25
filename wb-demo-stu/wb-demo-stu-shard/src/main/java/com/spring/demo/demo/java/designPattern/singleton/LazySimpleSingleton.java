package com.spring.demo.demo.java.designPattern.singleton;


/**
 * 简单的懒汉式单例
 * 缺点：单线程下能够完美运行，但是在多线程下存在安全隐患
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton instance;

    private LazySimpleSingleton() {

    }
    public static  LazySimpleSingleton getInstance(){
        if (instance == null){
            instance = new LazySimpleSingleton();
        }
        return  instance;
    }

}
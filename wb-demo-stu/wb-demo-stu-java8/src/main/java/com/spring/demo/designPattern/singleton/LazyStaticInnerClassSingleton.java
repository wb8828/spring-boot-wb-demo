package com.spring.demo.designPattern.singleton;


/**
 * 升级懒汉式单例（静态内部实现）
 * 用静态内部类实现的单例本质上是一种懒汉式，因为在执行getInstance中的LazyHolder.LAZY语句之前，静态内部类并不会被加载
 * 这种方式既避免了饿汉式单例的内存浪费问题，又摆脱了synchronized关键字的性能问题，同时也不存在线程安全问题
 */
public class LazyStaticInnerClassSingleton {

    private volatile static LazyStaticInnerClassSingleton instance;

    private LazyStaticInnerClassSingleton() {
        if (LazyHolder.LAZY != null){
            throw new RuntimeException("实例被重复创建");
        }

    }

    public static LazyStaticInnerClassSingleton getInstance() {
        return LazyHolder.LAZY;
    }

    private static class LazyHolder {
        private static final LazyStaticInnerClassSingleton LAZY = new LazyStaticInnerClassSingleton();
    }

}
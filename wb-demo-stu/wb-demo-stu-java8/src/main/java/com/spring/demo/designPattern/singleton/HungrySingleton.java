package com.spring.demo.designPattern.singleton;

/**
 * 饿汉式单例
 * 优点：1.饿汉式单例是最简单的一种单例形式，它没有添加任何的锁，执行效率最高
 * 2.线程安全
 * 缺点：某些情况下，造成内存浪费，因为对象未被使用的情况下就会被初始化，如果一个项目中的类多达上千个，在项目启动的时候便开始初始化可能并不是我们想要的
 */
public class HungrySingleton {

    private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();


    private HungrySingleton() {
    }

    public static  HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }
}
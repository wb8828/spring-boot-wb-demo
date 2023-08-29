package com.spring.demo.designPattern.singleton;


/**
 * 升级懒汉式单例（双重检查锁）
 * 优点：升级之后的程序能完美地解决线程安全问题
 * 缺点：使用synchronized关键总归是要上锁的，对程序性能还是存在影响
 */
public class LazyDoubleCheckSingleton {

    private volatile static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton() {

    }
    public synchronized static LazyDoubleCheckSingleton getInstance(){
        if (instance == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (instance == null){
                    instance = new LazyDoubleCheckSingleton();
                }
            }
        }
        return  instance;
    }

}
package com.spring.demo.designPattern.singleton;


/**
 *
 */
public class EnumSingleton {


    private EnumSingleton() {

    }

    public static EnumSingleton getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    enum SingletonEnum {
        INSTANCE;

        private EnumSingleton instance;

        public EnumSingleton getEnumSingleton(){
            return instance;
        }
        public void  setData(EnumSingleton instance){
            this.instance = instance;
        }

        SingletonEnum() {
            instance = new EnumSingleton();
        }

        public static EnumSingleton getInstance() {
            return INSTANCE.instance;
        }
    }
}
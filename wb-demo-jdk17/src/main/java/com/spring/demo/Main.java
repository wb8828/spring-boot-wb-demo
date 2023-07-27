package com.spring.demo;

public class Main {

    // javap -v  **.class 查看字节码
    public static void main(String[] args) {
//        String s = new String("a") + new String("b") + new String("b");
        Main.Test test = new Test();
        Test1 test1 = new Test1();

    }

    private static class  Test{

    }

    public static class  Test1{

    }
}
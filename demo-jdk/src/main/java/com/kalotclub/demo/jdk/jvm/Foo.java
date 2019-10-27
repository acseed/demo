package com.kalotclub.demo.jdk.jvm;

/**
 * @author hongchen.cao
 * @date 2019/10/12 15:00
 **/
public class Foo {
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) System.out.printf("Hello, Java!");
        if (flag == true) System.out.println("Hello, JVM!!");
    }
}

package com.kalotclub.demo.jdk.instrument;

/**
 * Date: 2019-08-22 11:55
 *
 * @author hongchen.cao
 */
public class TestMainInJar {
    public static void main(String[] args) {
        System.out.println(new TransClass().getNumber());
    }
}

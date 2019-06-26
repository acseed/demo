package com.kalotclub.demo.jdk.bridge;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Bridge {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        B b = new B();
        Method m = B.class.getMethod("method", String.class);
        System.out.println(m.isBridge());
        Method m1 = B.class.getMethod("method", Object.class);
        System.out.println(m1.isBridge());
        Integer c = 10;

        Method getter = B.class.getMethod("getData");
        System.out.println(getter.invoke(b));

    }
}

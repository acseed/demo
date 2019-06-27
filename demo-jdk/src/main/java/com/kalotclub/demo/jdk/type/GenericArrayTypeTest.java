package com.kalotclub.demo.jdk.type;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Date: 2019-06-27 13:41
 *
 * @author hongchen.cao
 */
public class GenericArrayTypeTest<T> {
    public static void main(String[] args) throws Exception {
        Method method = Test.class.getDeclaredMethods()[0];
        // public void com.test.Test.show(java.util.List[],java.lang.Object[],java.util.List,java.lang.String[],int[])
        System.out.println(method);
        Type[] types = method.getGenericParameterTypes();
        for (Type type : types) {
            System.out.println(type instanceof GenericArrayType);
        }
    }

}

class Test<T> {
    public void show(List<String>[] pTypeArray, T[] vTypeArray, List<String> list, String[] strings, int[] ints) {
    }
}

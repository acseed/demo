package com.kalotclub.demo.jdk.type;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Date: 2019-06-27 13:35
 *
 * @author hongchen.cao
 */
public class TypeVariableTest<K extends Comparable & Serializable, V> {
    K key;
    V val;

    public static void main(String[] args) throws NoSuchFieldException {
        Field kf = TypeVariableTest.class.getDeclaredField("key");
        Field vf = TypeVariableTest.class.getDeclaredField("val");
        System.out.println(kf.getGenericType() instanceof TypeVariable);
        System.out.println(vf.getGenericType() instanceof TypeVariable);

        TypeVariable keyType = (TypeVariable) kf.getGenericType();
        TypeVariable valType = (TypeVariable) vf.getGenericType();

        System.out.println(keyType.getName());
        System.out.println(valType.getName());
        System.out.println(keyType.getTypeName());
        System.out.println(valType.getTypeName());

        System.out.println(keyType.getGenericDeclaration());
        System.out.println(valType.getGenericDeclaration());

        for (Type type : keyType.getBounds()) {
            System.out.println(type);
        }

        System.out.println("-------------");
        for (Type type : valType.getBounds()) {
            System.out.println(type);
        }
    }
}

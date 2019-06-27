package com.kalotclub.demo.jdk.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * Date: 2019-06-27 13:22
 *
 * @author hongchen.cao
 */
public class TestType {
    private Map<Integer, String> mp;

    public static void main(String[] args) throws NoSuchFieldException {
        Field f = TestType.class.getDeclaredField("mp");
        System.out.println(f.getGenericType());
        System.out.println(f.getGenericType() instanceof ParameterizedType);
        ParameterizedType ptype = (ParameterizedType) f.getGenericType();
        System.out.println(ptype.getRawType());
        for (int i = 0; i < ptype.getActualTypeArguments().length; ++i) {
            System.out.println(ptype.getActualTypeArguments()[i]);
        }
        System.out.println(ptype.getOwnerType());
        System.out.println(ptype.getTypeName());
    }
}

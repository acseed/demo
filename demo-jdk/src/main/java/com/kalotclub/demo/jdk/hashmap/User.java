package com.kalotclub.demo.jdk.hashmap;

import java.util.Objects;

/**
 * @author hongchen.cao
 * @date 2019/10/15 15:43
 **/
public class User {
    private int age = 1;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(age);
//    }
}

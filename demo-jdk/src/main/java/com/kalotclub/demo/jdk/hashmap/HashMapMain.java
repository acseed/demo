package com.kalotclub.demo.jdk.hashmap;

import java.util.HashMap;

/**
 * @author hongchen.cao
 * @date 2019/10/15 15:42
 **/
public class HashMapMain {
    public static void main(String[] args) {
        HashMap<User, String> map = new HashMap<>();
        map.put(new User(), "xiaoming");
        map.put(new User(), "xiaogang");
        map.put(new User(), "xiaohong");
        map.put(new User(), "xiaoli");
        map.put(new User(), "xiaowi");
        map.put(new User(), "xiaoxi");
        map.put(new User(), "xiaoyi");
        map.put(new User(), "xiaoxj");
        map.put(new User(), "xiaoqi");
        map.put(new User(), "xiaoqi");
        map.put(new User(), "xiaoqi");
        map.put(new User(), "xiaoqi");
        System.out.println(map.size());
    }
}

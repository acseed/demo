package com.kalotclub.demo.mybatis;

import com.kalotclub.demo.mybatis.model.Student;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.ReflectorFactory;

/**
 * Reflector 中的caseInsensitiveMap可能会有问题
 */
public class RefMain {
    public static void main(String[] args) {
        ReflectorFactory rf = new DefaultReflectorFactory();
        rf.findForClass(Student.class);

    }
}

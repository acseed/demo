package com.kalotclub.demo.mybatis.model;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Student {
    @Getter
    private String name;
    @Getter
    private String cardNo;
    @Getter
    private Integer age;
    @Getter
    private String sex;
    @Getter
    private boolean passedExam;
    private Grade grade;
    private Grade gRaDE;
}

package com.kalotclub.demo.jdk.bridge;

public class B implements A<String> {
    private String s = "Nooops...";

    @Override
    public String getData() {
        return s;
    }

    @Override
    public void method(String s) {
        this.s = s;
    }

    public String getString() {
        return this.s;
    }
}

package com.gjs.mCucumber.models;

public class User {

    private String name;
    private Integer age;

    public User(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

    public User(final String name, final String age) {
        this.name = name;
        this.age = Integer.valueOf(age);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

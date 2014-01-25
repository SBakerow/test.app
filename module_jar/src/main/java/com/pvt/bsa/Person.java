package com.pvt.bsa;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 18.01.14
 * Time: 16:54
 * To change this template use File | Settings | File Templates.
 */
public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

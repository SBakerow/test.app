package com.pvt.bsa;

/**
 * Created with IntelliJ IDEA.
 * User: Dell
 * Date: 20.01.14
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private Integer age;
    private String name;
    private Integer id;

    public User(Integer age, String name, Integer id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

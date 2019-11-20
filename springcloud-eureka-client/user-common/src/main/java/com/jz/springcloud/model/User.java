package com.jz.springcloud.model;/**
 * Created by jazzyshi on 2019/11/20.
 */

/**
 * @ClassName User
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/11/20 11:48
 * @Version 1.0
 **/
public class User {
    public int id;
    public String name;
    public int age;

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

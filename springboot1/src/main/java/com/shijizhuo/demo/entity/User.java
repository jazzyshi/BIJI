package com.shijizhuo.demo.entity;/**
 * Created by jazzyshi on 2019/6/2.
 */

/**
 * @ClassName User
 * @Description TODO
 * @Author jazzyshi
 * @Date 2019/6/2 14:34
 * @Version 1.0
 **/
public class User {
    private Integer id;
    private String name;
    private String passwd;

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


    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}

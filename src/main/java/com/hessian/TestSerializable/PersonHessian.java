package com.hessian.TestSerializable;


import java.io.Serializable;

/**
 * Created by Ivan on 2016/6/14.
 */
public class PersonHessian implements Serializable {
    private String name = null;

     private Integer age = null;

    private Gender gender = null;

    private Man man = null;

    public PersonHessian() {
        System.out.println("none-arg constructor");
    }

    public PersonHessian(String name, Integer age, Gender gender,Man man) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.man = man;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender +", "+man+ "]";
    }
}

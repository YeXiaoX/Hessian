package com.hessian.TestSerializable;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by Ivan on 2016/6/14.
 */
public class PersonSingle implements Serializable {
    private static class InstanceHolder {
        private static final PersonSingle instatnce = new PersonSingle("John", 31, Gender.MALE);
    }

    public static PersonSingle getInstance() {
        return InstanceHolder.instatnce;
    }

    private String name = null;

    private Integer age = null;

    private Gender gender = null;

    private PersonSingle() {
        System.out.println("none-arg constructor");
    }

    private PersonSingle(String name, Integer age, Gender gender) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private Object readResolve() throws ObjectStreamException {
        return InstanceHolder.instatnce;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + "]";
    }
}

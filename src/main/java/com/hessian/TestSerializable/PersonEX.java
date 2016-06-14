package com.hessian.TestSerializable;

import java.io.*;

/**
 * Created by Ivan on 2016/6/14.
 */
public class PersonEX implements Externalizable {
    private String name = null;

    transient private Integer age = null;

    private Gender gender = null;

    public PersonEX() {
        System.out.println("none-arg constructor");
    }

    public PersonEX(String name, Integer age, Gender gender) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(age);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        age = in.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        /*
        * 写的顺序和读的顺序必须一致否则会报错
        * */
        out.writeObject(name);
        out.writeInt(age);
        out.writeObject(gender);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
       gender = (Gender) in.readObject();
    }
    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + "]";
    }
}

package com.hessian.Test;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Ivan on 2016/6/8.
 */
public class Person implements Serializable{


    private int id;
    private String name;
    private boolean gender;
    private long phone;
    private double height;
    private float weight;
    private String address[];

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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone=" + phone +
                ", height=" + height +
                ", weight=" + weight +
                ", address=" + Arrays.toString(address) +
                '}';
    }
}

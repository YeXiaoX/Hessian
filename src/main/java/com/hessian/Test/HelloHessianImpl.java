package com.hessian.Test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 2016/6/8.
 */
public class HelloHessianImpl implements HelloHessian {

    private static Person[] persons = new Person[5];

    static {
        Random random = new Random();
        for (int i = 0, l = persons.length; i < l; i++) {
            persons[i] = new Person();
            persons[i].setId(i);
            persons[i].setGender(random.nextBoolean());
            persons[i].setName("name-" + i);
            persons[i].setPhone(random.nextLong());
            persons[i].setHeight(random.nextDouble());
            persons[i].setWeight(random.nextFloat());
            persons[i].setAddress(new String[] { "Address" + random.nextInt(),
                    "Address" + random.nextInt() });
        }
    }

    @Override
    public String sayHello() {
        return "Hello Hession " + new Date().toString();
    }

    @Override
    public String sayHello(String name) {
        return "Welcome " + name;
    }

    @Override
    public List<Person> getPersons() {
        return Arrays.asList(persons);
    }

    @Override
    public Person getPersonById(int id) {
        for (Person p : persons) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean uploadFile(String fileName, InputStream data) {
        List<String> temp;
        try {
            temp = IOUtils.readLines(data);
            String filePath = System.getProperty("user.dir") + "/temp/"
                    + fileName;
            FileUtils.writeLines(new File(filePath), temp);
            System.out.println("Upload file to " + filePath);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public byte[] downloadFile(String fileName) {
        String filePath = System.getProperty("user.dir") + "/temp/" + fileName;
        InputStream data = null;
        try {
            data = new FileInputStream(filePath);
            int size = data.available();
            byte[] buffer = new byte[size];
            buffer = IOUtils.toByteArray(data);
            return buffer;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            IOUtils.closeQuietly(data);
        }
    }
}
package com.hessian.Test;

import com.caucho.hessian.client.HessianProxyFactory;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by Ivan on 2016/6/8.
 */
public class HelloHessianClient {
    public static String urlName = "http://localhost:8080/TestHessian/HelloHessian";

    public static void main(String[] args) throws MalformedURLException {

        HessianProxyFactory factory = new HessianProxyFactory();
        // 开启方法重载
        factory.setOverloadEnabled(true);

        HelloHessian helloHession = (HelloHessian) factory.create(
                HelloHessian.class, urlName);

        // 调用方法
        System.out.println("call sayHello():" + helloHession.sayHello());
        System.out.println("call sayHello(\"Tom\"):"
                + helloHession.sayHello("Tom"));


// 通过参数调用方法获取对象
        int id = 2;
        System.out.println(String.format("call getPersonById(%d)", id));
        Person person = helloHession.getPersonById(id);
        if (null != person) {
            System.out.println(person.toString());
        } else {
            System.out.println("Id is " + id + " person not exist.");
        }

        System.out.println("call getPersons():");
        // 调用方法获取集合对象
        List<Person> persons = helloHession.getPersons();
        if (null != persons && persons.size() > 0) {
            for (Person p : persons) {
                System.out.println(p.toString());
            }
        } else {
            System.out.println("No person.");
        }



        // 上传文件
        String fileName = "upload.txt";
        String filePath = System.getProperty("user.dir") + "/temp/" + fileName;
        InputStream data = null;
        try {
            data = new BufferedInputStream(new FileInputStream(filePath));
            if (helloHession.uploadFile(fileName, data)) {
                System.out.println("Upload file " + filePath + " succeed.");
            } else {
                System.out.println("Upload file " + filePath + " failed.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(data);
        }

        // 下载文件
        fileName = "download.txt";
        filePath = System.getProperty("user.dir") + "/temp/" + fileName;
        try {

            byte[] temp = helloHession.downloadFile(fileName);
            if (null != temp) {
                FileWriter output = new FileWriter(filePath);
                IOUtils.write(temp, output, "UTF-8");
                System.out.println("Download file " + filePath + " succeed.");
                output.close();
            } else {
                System.out.println("Download file " + filePath + " failed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


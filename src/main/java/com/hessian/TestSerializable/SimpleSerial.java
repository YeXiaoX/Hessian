package com.hessian.TestSerializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.*;

/**
 * Created by Ivan on 2016/6/14.
 */
public class SimpleSerial {

    public static void main(String[] args) throws Exception {
        File file = new File("person.out");

        System.out.println(System.currentTimeMillis());
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
         //Hessian2Output oout = new Hessian2Output(new FileOutputStream(file));
        //PersonEX person = new PersonEX("John", 101, Gender.MALE);
        // PersonSingle person  =PersonSingle.getInstance();
        Man man = new Man("haha", 10);
        PersonHessian person = new PersonHessian("John", 101, Gender.MALE, man);
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        Hessian2Output out = new Hessian2Output(os);
//        ObjectOutputStream out = new ObjectOutputStream(os);
//        out.writeObject(person);
        oout.writeObject(person);
//
//        System.out.println("size:"+os.toByteArray().length);
//        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
//        Hessian2Input hi = new Hessian2Input(is);
//         System.out.println(hi.readObject());
       // out.close();

        oout.close();

        System.out.println("size:"+file.length());
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
       // Hessian2Input oin = new Hessian2Input(new FileInputStream(file));
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型
        oin.close();
        System.out.println(newPerson);
        System.out.println(System.currentTimeMillis());

        // System.out.println(PersonSingle.getInstance() == newPerson); // 将获取的对象与Person类中的单例对象进行相等性比较
    }
}

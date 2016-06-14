package com.hessian.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Ivan on 2016/6/8.
 */
public interface HelloHessian {
    public String sayHello();

    public String sayHello(String name);

    public List<Person> getPersons();

    public Person getPersonById(int id);

    public boolean uploadFile(String fileName, InputStream data);

    public byte[] downloadFile(String fileName);

}

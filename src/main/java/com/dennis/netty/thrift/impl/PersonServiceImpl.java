package com.dennis.netty.thrift.impl;

import org.apache.thrift.TException;
import thrift.generated.DataException;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByName(String name) throws DataException, TException {

        Person person = new Person();
        person.setName(name);
        person.setAge(53);
        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException {
        System.out.println("客户端储存person对象：" + person.getName() + "--" + person.getName());
    }
}

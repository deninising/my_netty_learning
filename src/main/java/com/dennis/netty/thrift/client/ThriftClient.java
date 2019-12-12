package com.dennis.netty.thrift.client;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class ThriftClient {
    public static void main(String[] args) throws Exception {
        // 创建传输对象：指定传输方式类型、服务端的地址及端口及附属属性
        TFramedTransport transport = new TFramedTransport(new TSocket("192.168.31.12", 1234,300000));
        // 传输格式
        TCompactProtocol tCompactProtocol = new TCompactProtocol(transport);
        // 获取客户端对象
        PersonService.Client client = new PersonService.Client(tCompactProtocol);
        try {
            // 启动
            transport.open();
            Person person = client.getPersonByName("张三");
            System.out.println("获得服务端的数据：");
            System.out.println(person.getName());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());
            System.out.println("-------");
            Person person2 = new Person();
            person2.setName("李四");
            person2.setAge(30);
            person2.setMarried(true);
            client.savePerson(person2);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        } finally {
            transport.close();
        }
    }
}

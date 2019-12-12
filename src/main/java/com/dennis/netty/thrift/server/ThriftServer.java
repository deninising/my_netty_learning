package com.dennis.netty.thrift.server;

import com.dennis.netty.thrift.impl.PersonServiceImpl;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrift.generated.PersonService;

public class ThriftServer {
    public static void main(String[] args) throws TTransportException {
        // 创建/声明 服务模型所对应的socket、参数对象
        TNonblockingServerSocket tNonblockingServerSocket = new TNonblockingServerSocket(1234);
        THsHaServer.Args arg = new THsHaServer.Args(tNonblockingServerSocket).minWorkerThreads(2).maxWorkerThreads(4);
        // 初始化参数对象：传输格式、数据传输方式、服务处理器
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());
        arg.processorFactory(new TProcessorFactory(processor));
        // 创建server对象
        THsHaServer server = new THsHaServer(arg);
        System.out.println("Thrift server started!");
        // 开启server提供服务：死循环
        server.serve();
    }
}

package precipitated.will.thrift.demo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by will.wang on 2016/1/10.
 */
public class HelloServiceServer {
    public static void main(String[] args) throws TTransportException {
        TServerSocket serverTransport = new TServerSocket(7911);
        // 设置协议工厂为 TBinaryProtocol.Factory
        TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
        // 关联处理器与 Hello 服务的实现
        TProcessor processor = new precipitated.will.thrift.demo.Hello.Processor(new HelloServiceImpl());
        TThreadPoolServer.Args Args = new TThreadPoolServer.Args(serverTransport);
        Args.processor(processor);
        TServer server = new TThreadPoolServer(Args);
        System.out.println("Start server on port 7911...");
        server.serve();
    }
}

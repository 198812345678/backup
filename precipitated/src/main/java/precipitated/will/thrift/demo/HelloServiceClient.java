package precipitated.will.thrift.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by will.wang on 2016/1/10.
 */
public class HelloServiceClient {

    public static void main(String[] args) throws TException {
        // 设置调用的服务地址为本地，端口为 7911
        TTransport transport = new TSocket("localhost", 7911);
        transport.open();
        // 设置传输协议为 TBinaryProtocol
        TProtocol protocol = new TBinaryProtocol(transport);
        precipitated.will.thrift.demo.Hello.Client client = new precipitated.will.thrift.demo.Hello.Client(protocol);
        // 调用服务的 helloVoid 方法
        client.helloVoid();
        transport.close();
    }
}

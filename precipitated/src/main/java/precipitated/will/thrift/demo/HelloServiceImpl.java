package precipitated.will.thrift.demo;

import org.apache.thrift.TException;

/**
 * Created by will.wang on 2016/1/10.
 */
public class HelloServiceImpl implements precipitated.will.thrift.demo.Hello.Iface {
    @Override
    public String helloString(String para) throws TException {
        return "helloString";
    }

    @Override
    public int helloInt(int para) throws TException {
        return 0;
    }

    @Override
    public boolean helloBoolean(boolean para) throws TException {
        return false;
    }

    @Override
    public void helloVoid() throws TException {
        System.out.println("helloVoid");
    }

    @Override
    public String helloNull() throws TException {
        return null;
    }
}

package precipitated.will.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * Created by will.wang on 2016/6/22.
 */
public class TCPServerSelector {

    public static void main(String[] args) throws IOException {
        String[] strargs = new String[]{"9101", "9103"};
        Selector selector = Selector.open();
        for (String strarg : strargs) {
            ServerSocketChannel listenChannel = ServerSocketChannel.open();

            listenChannel.socket().bind(new InetSocketAddress(Integer.valueOf(strarg)));

            listenChannel.configureBlocking(false);

            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        }

        TCPProtocol protocol = new EchoSelectorProtocol(1024);

        while (true) {
            if(selector.select(3000) == 0) {
                System.out.println("server ==> prepare channel ...");
                continue;
            }

            Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();

            while (keyIter.hasNext()) {
                SelectionKey key = keyIter.next();

                if(key.isAcceptable()) {
                    protocol.handleAccept(key);
                }

                if(key.isReadable()) {
                    protocol.handleRead(key);
                }

                if(key.isValid() && key.isWritable()) {
                    protocol.handleWrite(key);
                }

//                keyIter.remove();//如果不remove，
            }
        }
    }
}

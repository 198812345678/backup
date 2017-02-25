package precipitated.will.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * http://www.importnew.com/20188.html
 * Created by will.wang on 2016/6/22.
 */
public class TCPEchoClientNonblocking {

    public static void main(String[] args) throws IOException {

        SocketChannel clntChan = SocketChannel.open();

        clntChan.configureBlocking(false);

        if(!clntChan.connect(new InetSocketAddress("127.0.0.1", 9101))) {
            int i = 0;
            while (!clntChan.finishConnect()) {
                System.out.println("client ==> do job " + i++ + "while waitting connect ……");
            }
        }

        System.out.println("client ==> connected !!!");

        byte[] data = new byte[]{'2', '3', '4', '5'};
        ByteBuffer writeBuffer = ByteBuffer.wrap(data);
        ByteBuffer readBuffer = ByteBuffer.allocate(data.length);

        int totalBytesRsv = 0;
        int bytesRsv = 0;

        while (totalBytesRsv < data.length) {
            if(writeBuffer.hasRemaining()) {
                clntChan.write(writeBuffer);
            }

            if((bytesRsv = clntChan.read(readBuffer)) == -1) {
                throw new SocketException("client ==> connection closed");
            }

            totalBytesRsv += bytesRsv;

            System.out.println(readBuffer);
        }

        System.out.println("client ==> Received: " + String.valueOf(readBuffer.array()));

        clntChan.close();
    }
}

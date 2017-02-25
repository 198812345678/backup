package precipitated.will.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * Created by will.wang on 2016/6/22.
 */
public interface TCPProtocol {

    //accept I/O形式
    void handleAccept(SelectionKey key) throws IOException;
    //read I/O形式
    void handleRead(SelectionKey key) throws IOException;
    //write I/O形式
    void handleWrite(SelectionKey key) throws IOException;
}

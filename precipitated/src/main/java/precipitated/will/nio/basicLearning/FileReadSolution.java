package precipitated.will.nio.basicLearning;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by will.wang on 2017/2/9.
 */
public class FileReadSolution {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("F:\\backup\\precipitated\\src\\main\\resources\\testData.txt", "rw");
        aFile.seek(0);
//        System.out.println(aFile.getFilePointer());

        FileChannel channel = aFile.getChannel();

        CharBuffer buf = CharBuffer.allocate(40);
//        ByteBuffer buf = ByteBuffer.allocate(40);

        int bytesRead = channel.read(buf);

        while (bytesRead != -1) {
            buf.flip();

            while (buf.hasRemaining()) {
                System.out.println((char)buf.get());
            }

            buf.clear();

            bytesRead = channel.read(buf);
        }


        aFile.close();
        channel.close();
    }
}

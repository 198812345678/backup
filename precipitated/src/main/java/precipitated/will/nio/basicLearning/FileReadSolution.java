package precipitated.will.nio.basicLearning;

import com.google.common.base.Charsets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * Created by will.wang on 2017/2/9.
 */
public class FileReadSolution {

    public static void main(String[] args) throws IOException {


        FileReadSolution solution = new FileReadSolution();
        solution.wholeFile();
    }

    private void wholeFile() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("F:\\gitHub\\backup\\precipitated\\testData.txt", "rw");
        aFile.seek(0);
        FileChannel channel = aFile.getChannel();

        int chunk = 3;

        ByteBuffer buffer = ByteBuffer.allocate(chunk);
        CharBuffer charBuffer = CharBuffer.allocate(chunk);
        Charset charset = Charset.forName("utf8");
        CharsetDecoder decoder = charset.newDecoder();
        while (channel.read(buffer) > 0) {
            buffer.flip();

            decoder.decode(buffer, charBuffer, false);
            charBuffer.flip();

//            while (charBuffer.hasRemaining()) {
                System.out.println(charBuffer);
//            }
            buffer.clear();
            charBuffer.clear();
        }
    }

    private void basicShow() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("F:\\backup\\precipitated\\src\\main\\resources\\testData.txt", "rw");
        aFile.seek(0);
//        System.out.println(aFile.getFilePointer());

        FileChannel channel = aFile.getChannel();

//        CharBuffer buf = CharBuffer.allocate(40);
        ByteBuffer buf = ByteBuffer.allocate(40);

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

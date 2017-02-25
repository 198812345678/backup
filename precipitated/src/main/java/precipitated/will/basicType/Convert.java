package precipitated.will.basicType;

import com.google.common.base.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * stream和byte转String
 * {@link http://javarevisited.blogspot.sg/2014/08/2-examples-to-convert-byte-array-to-String-in-Java.html}
 *
 * Created by will.wang on 2016/1/5.
 */
public class Convert {

    public static void main(String[] args) throws IOException {
        byte b = '1';
        String s = String.valueOf(b);
        System.out.println(s);//输出49 ASIIC码

        byte[] barr = new byte[]{'!', ' ', '2'};
        String sbarr = String.valueOf(barr);
        System.out.println(sbarr);

        char c = 'é';
        System.out.println((int)c);

        String str = new String(barr, Charsets.UTF_8);//指定编码，正解

        /**文件转String*/
        /**<?xml version="1.0" encoding="UTF-8"?>, or Content-Type in HTML 指定了encoding*/
        String fileStr = IOUtils.toString(new FileInputStream("F:\\oneDrive\\backup\\precipitated\\pom.xml"), Charsets.UTF_8);


        long l = (long)b;
        System.out.println("byte(" + new String(new byte[]{b}, Charsets.UTF_8) + ") ====> long : " + l);

        Long L = new Long(b);
        System.out.println("byte(" + new String(new byte[]{b}, Charsets.UTF_8) + ") ====> Long : " + L);

        int i = 129;
        byte iToB = (byte)i;
        System.out.println("int(" + String.valueOf(i) + ") ====> byte : " + iToB);//-127, 超出byte的范围

    }
}

package precipitated.will.serialize;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * Created by will.wang on 2016/4/21.
 */
public class TransientClassSolution {

    public static void main(String[] args) throws Exception {
        File file = new File("F:\\oneDrive\\backup\\precipitated\\result.txt");

        //序列化到文件
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(new TransientClass());

        //从文件反序列化
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
//        System.out.println(JSON.toJSONString(inputStream.readObject()));//每次返回一个对象
        System.out.println(((TransientClass)inputStream.readObject()).getT());//每次返回一个对象
    }
}

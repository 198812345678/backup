package precipitated.will.serialize;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * 反序列化必须有无参构造方法？？？
 * Created by will.wang on 2016/4/13.
 */
public class SerializeObjectToFileSolution{

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("F:\\oneDrive\\backup\\precipitated\\result.txt");

        //序列化到文件
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
        outputStream.writeObject(new SubClass(1));
        outputStream.writeObject(new SubClass(2));
//        outputStream.writeObject(new SerializableClass());

        //从文件反序列化
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        System.out.println(inputStream.readObject());//每次返回一个对象
        System.out.println(inputStream.readObject());
    }
}



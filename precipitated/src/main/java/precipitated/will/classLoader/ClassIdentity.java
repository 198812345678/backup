package precipitated.will.classLoader;

import java.lang.reflect.Method;

/**
 * 不同类加载器加载相同类名的类（precipitated.will.classLoader.Sample），得到两个不同实例，存在疑问，没有像文章里那样报错
 * https://www.ibm.com/developerworks/cn/java/j-lo-classloader/#code6
 * 或者这跟JDK版本有关？
 * Created by will.wang on 2015/4/28.
 */
public class ClassIdentity {
    public static void main(String[] args) {

        String classDataRootPath = "F:\\backup\\precipitated\\target\\classes\\precipitated\\will\\classLoader";
        FileSystemClassLoader loader1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader loader2 = new FileSystemClassLoader(classDataRootPath);
        String className = "precipitated.will.classLoader.Sample";
        try {
            Class<?> class2 = loader2.loadClass(className);
            Object obj2 = class2.newInstance();
            Class<?> class1 = loader1.loadClass(className);
            Object obj1 = class1.newInstance();
            Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

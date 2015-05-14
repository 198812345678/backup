package precipitated.will.classLoader;

import sun.applet.AppletClassLoader;

import java.lang.reflect.Method;

/**
 * Created by will.wang on 2015/4/23.
 */
public class ClassLoaderTree {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        Class<?> cl = loader.loadClass("precipitated.will.StringTest");
        System.out.println(cl.isEnum());
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }
    }


}

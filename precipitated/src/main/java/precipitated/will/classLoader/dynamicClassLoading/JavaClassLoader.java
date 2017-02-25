package precipitated.will.classLoader.dynamicClassLoading;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by will.wang on 2015/12/23.
 */
public class JavaClassLoader extends ClassLoader {

//    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
//        JavaClassLoader javaClassLoader = new JavaClassLoader();
//        ClassLoader classLoader = javaClassLoader.getClass().getClassLoader();
//        Class loadClassClass = classLoader.loadClass("precipitated.will.classLoader.dynamicClassLoading.MyClass");
//        Constructor[] constructors = loadClassClass.getConstructors();
//        Object objects = constructors[0].newInstance();
//        Method method = loadClassClass.getMethod("sayHello");
//        method.invoke(objects);
//    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class loadedClass = Class.forName("precipitated.will.classLoader.dynamicClassLoading.MyClass");
        Constructor[] constructors = loadedClass.getConstructors();
        Object objects = constructors[0].newInstance();
        Method method = loadedClass.getMethod("sayHello", String.class);
        method.invoke(objects, "fdf");
    }

}

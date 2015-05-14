package precipitated.will.classLoader;

import java.lang.reflect.Method;

/**
 *
 * Created by will.wang on 2015/4/23.
 */
public class Sample {
    private Sample instance;

    public void setSample(Object instance) {
        this.instance = (Sample) instance;
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
//        ClassLoader loader1 = new ClassLoader() {
//            @Override
//            public Class<?> loadClass(String name) throws ClassNotFoundException {
//                return super.loadClass(name);
//            }
//        };
//        ClassLoader loader2 = new ClassLoader() {
//            @Override
//            public Class<?> loadClass(String name) throws ClassNotFoundException {
//                return super.loadClass(name);
//            }
//        };

        String classDataRootPath = "C:\\workspace\\Classloader\\classData";
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

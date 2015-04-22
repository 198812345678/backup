package precipitated.will;

import javax.tools.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

/**
 * 运行时动态编译
 * Created by will.wang on 2015/4/18.
 */
public class CompileDynamic {
    public static void main(String[] args) throws Exception {
        String source = "public class Main { public static void main(String[] args) {System.out.println(\"Hello World!\");} }";

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(null, null, null);
        StringSourceJavaObject sourceObject = new
                StringSourceJavaObject("Main", source);
        Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(sourceObject);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null,
                    null, null, fileObjects);
            boolean result = task.call();
            if (result) {
                System.out.println("编译成功。");
            }
        }
        static class StringSourceJavaObject extends SimpleJavaFileObject {
            private String content = null;
            public StringSourceJavaObject(String name, String content) throws
                    URISyntaxException {
                super(URI.create("string:///" + name.replace('.', '/') +
                        Kind.SOURCE.extension), Kind.SOURCE);
                this.content = content;
            }
            public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
                return content;
            }
        }


    private static double calculate(String expr) throws CalculationException, URISyntaxException {
        String className = "CalculatorMain";
        String methodName = "calculate";
        String source = "public class " + className
                + " { public static double " + methodName + "() { return " + expr
                + "; } }";
        //省略动态编译Java源代码的相关代码，参见上一节
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(null, null, null);
        StringSourceJavaObject sourceObject = new
                StringSourceJavaObject("Main", source);
        Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(sourceObject);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null,
                null, null, fileObjects);
        boolean result = task.call();
        if (result) {
            ClassLoader loader = CompileDynamic.class.getClassLoader();
            try {
                Class<?> clazz = loader.loadClass(className);
                Method method = clazz.getMethod(methodName, new Class<?>[] {});
                Object value = method.invoke(null, new Object[] {});
                return (Double) value;
            } catch (Exception e) {
                throw new CalculationException("内部错误。");
            }
        } else {
            throw new CalculationException("错误的表达式。");
        }
    }


    private static class CalculationException extends Throwable {
        public CalculationException(String s) {
        }
    }
}

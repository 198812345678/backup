package precipitated.will.gc;

import ognl.Node;
import ognl.Ognl;
import ognl.OgnlContext;
import precipitated.will.SynchronizedTest;

/**
 * Created by will.wang on 2016/10/9.
 */
public class OgnlOOMSolution {

    private static OgnlContext context = (OgnlContext) Ognl.createDefaultContext(null);

    public static void testGenerate() {

//        ClassLoader oldCl = Thread.currentThread().getContextClassLoader();
//        ClassLoader classLoader = new ContextClassLoader(OgnlContext.class.getClassLoader(), context);
//        Thread.currentThread().setContextClassLoader(classLoader);

        OgnlModel obj = new OgnlModel();
        try {

            Node node = Ognl.compileExpression(context, obj, "key");
            // xian
            node.getAccessor().set(context, obj, "value");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Thread.currentThread().setContextClassLoader(oldCl);
    }

    public static class OgnlModel {
        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    /***
     * JVM args: -verbose:class -XX:PermSize=30m -XX:MaxPermSize=30m
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            testGenerate();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.gc();
//            System.gc();
//            System.gc();
//            System.gc();
            System.out.println(i);
        }
    }
}

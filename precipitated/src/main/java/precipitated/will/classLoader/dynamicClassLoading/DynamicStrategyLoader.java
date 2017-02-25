package precipitated.will.classLoader.dynamicClassLoading;

import net.openhft.compiler.CachedCompiler;
import net.openhft.compiler.CompilerUtils;

/**
 * {@link http://www.javacodegeeks.com/2015/10/dynamic-java-code-injection.html}
 * 得是完整的Java，包括import等
 * Created by will.wang on 2015/12/24.
 */
public class DynamicStrategyLoader {

    private static String className = "precipitated.will.classLoader.dynamicClassLoading.MyStrategy";
    private static String addingStrategy = "package precipitated.will.classLoader.dynamicClassLoading;\n" +
            "\n" +
            "import precipitated.will.classLoader.dynamicClassLoading.DynamicStrategyLoader.Strategy;" +
            "public class MyStrategy implements Strategy {\n" +
            "\n" +
            "    @Override\n" +
            "    public int compute(int a, int b) {\n" +
            "        return a + b;\n" +
            "    }\n" +
            "}";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final StrategyProxy strategyProxy = new StrategyProxy();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(strategyProxy.compute(10, 20));
                }
            }
        });
        thread.start();

        try {
            DynamicStrategyLoader testLoader = new DynamicStrategyLoader();
            ClassLoader classLoader = testLoader.getClass().getClassLoader();
        Class loadedClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, addingStrategy);
//            CachedCompiler cachedCompiler = new CachedCompiler(null, null);
//            Class loadedClass = cachedCompiler.loadFromJava(classLoader, className, addingStrategy);
            Object object = loadedClass.newInstance();
            strategyProxy.setStrategy((Strategy)object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class StrategyProxy {
        private volatile Strategy strategy;

        public void setStrategy(Strategy strategy) {
            this.strategy = strategy;
        }

        public int compute(int a, int b) {
            return strategy == null ? Integer.MIN_VALUE : strategy.compute(a, b);
        }
    }

    public interface Strategy {
        int compute(int a, int b);
    }
}

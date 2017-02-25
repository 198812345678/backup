package precipitated.will.concurrent.immutable;

import javax.servlet.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 代码逻辑是：
 * 返回最后访问的i的factor
 * 每次访问的i如果和cache中保存的不同，就更新cache中的i和他的factor，所以两步操作需要原子性
 *
 * 每个线程都认为自己访问的i是最新的
 *
 * Created by will.wang on 2016/1/7.
 */
public class ThreadSafeSolution {

    class OneValueCache {
        private final BigInteger lastNumber;
        private final BigInteger[] lastFactors;
        public OneValueCache(BigInteger i,
                             BigInteger[] factors) {
            lastNumber = i;
            lastFactors = Arrays.copyOf(factors, factors.length);
        }
        public BigInteger[] getFactors(BigInteger i) {
            if (lastNumber == null || !lastNumber.equals(i))
                return null;
            else
                return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }

    /**
     * else中的逻辑需要原子性
     */
    public class UnsafeCachingFactorizer implements Servlet {
        private final AtomicReference<BigInteger> lastNumber
                = new AtomicReference<BigInteger>();
        private final AtomicReference<BigInteger[]> lastFactors
                = new AtomicReference<BigInteger[]>();

        @Override
        public void destroy() {

        }

        @Override
        public ServletConfig getServletConfig() {
            return null;
        }

        @Override
        public String getServletInfo() {
            return null;
        }

        @Override
        public void init(ServletConfig servletConfig) throws ServletException {

        }

        public void service(ServletRequest req, ServletResponse resp) {
            BigInteger i = extractFromRequest(req);
            if (i.equals(lastNumber.get()))
                encodeIntoResponse(resp, lastFactors.get());
            else {
                BigInteger[] factors = factor(i);
                lastNumber.set(i);
                lastFactors.set(factors);
                encodeIntoResponse(resp, factors);
            }
        }
    }

    private BigInteger extractFromRequest(ServletRequest req) {
        return null;
    }


    /**
     * 线程安全的
     * 每个线程访问的i如果不是最新的，抛弃原有的cache对象，new一个不可变的cache对象，这样线程间不会相互影响
     */
    public class VolatileCachedFactorizer implements Servlet {
        private volatile OneValueCache cache =
                new OneValueCache(null, null);

        @Override
        public void destroy() {

        }

        @Override
        public ServletConfig getServletConfig() {
            return null;
        }

        @Override
        public String getServletInfo() {
            return null;
        }

        @Override
        public void init(ServletConfig servletConfig) throws ServletException {

        }

        public void service(ServletRequest req, ServletResponse resp) {
            BigInteger i = extractFromRequest(req);
            BigInteger[] factors = cache.getFactors(i);
            if (factors == null) {
                factors = factor(i);
                cache = new OneValueCache(i, factors);
            }
            encodeIntoResponse(resp, factors);
        }
    }

    private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors) {

    }

    private BigInteger[] factor(BigInteger i) {
        return new BigInteger[0];
    }
}

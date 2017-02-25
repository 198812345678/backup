package precipitated.will.cache.guavaCache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * http://ifeve.com/google-guava-cachesexplained/
 * Created by will.wang on 2016/7/4.
 */
public class GuavaCacheTaste {

    public static void main(String[] args) throws ExecutionException {
        LoadingCache<Integer, Integer> graphs = CacheBuilder.newBuilder().build(new CacheLoader<Integer, Integer>() {
            @Override
            public Integer load(Integer key) throws Exception {
                return key + 10;
            }
        });

        System.out.println(graphs.get(1));

        final Integer key = 0;
        Cache<Integer, Integer> cache = CacheBuilder.newBuilder().build();
        System.out.println(cache.get(key, new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return key + 20;
            }
        }));
    }
}

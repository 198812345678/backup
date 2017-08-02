package precipitated.will.cache.guavaCache.trainInsuranceCache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by will on 17/7/15.
 */
public class BizCache {


    private static Cache<String, InsuranceProd> corp_price_cache =
            CacheBuilder.newBuilder().build(new CacheLoader<String, InsuranceProd>() {
                @Override
                public InsuranceProd load(String key) throws Exception {
                    return null;
                }

                @Override
                public Map<String, InsuranceProd> loadAll(Iterable<? extends String> keys) {
                    List<InsuranceProd> prodList = DBMock.prodList;
                    Map<String, InsuranceProd> map = Maps.newHashMap();
                    for (InsuranceProd prod : prodList) {
                        String key = prod.getCorpCode() + "_" + prod.getPrice().toString();
                        map.put(key, prod);
                    }
                    return map;
                }
            });


}

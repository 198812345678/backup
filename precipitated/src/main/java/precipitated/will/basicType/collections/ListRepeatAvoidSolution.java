package precipitated.will.basicType.collections;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by will.wang on 2016/11/10.
 */
public class ListRepeatAvoidSolution {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 33, 3, 3, 3, 3);

        Iterable<Integer> integers = Iterables.filter(list, Predicates.not(new Predicate<Integer>() {
            Map<Integer, Integer> map = Maps.newHashMap();
            @Override
            public boolean apply(Integer input) {
                Integer i = map.get(input);
                if(i != null) {
                    return true;
                }
                map.put(input, input);
                return false;
            }
        }));

//        list = Lists.transform(list, new Function<Integer, Integer>() {
//            Map<Integer, Integer> map = Maps.newHashMap();
//            @Override
//            public Integer apply(Integer input) {
//                Integer i = map.get(input);
//                if(i != null) {
//                    return null;
//                }
//                map.put(input, input);
//                return input;
//            }
//        });
        list = Lists.newArrayList(integers);
        System.out.println(list);
    }
}

package precipitated.will.concurrent.concurrentHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by will on 17/6/21.
 * 1.size和isEmpty并不是线程安全的,当检查一个segment时另一个检查过的segment被修改,会有问题
 * 2.containsKey, containsValue, 当在具体链表中找到元素返回true的时候,另一个线程把元素remove掉, 还是会返回true
 * 3.迭代器弱一致,不会抛ConcurrentModificationException,因为遍历的时候没有像hashmap一样检查结构变化的次数,可能即使检查了也有问题,因为不是volatile
 */
public class ConcurrentHashMapTest {


    public static void main(String[] args) {

//
////        for (int i = 0; i < 100; i++) {
//
//        final ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
//        map.put(0, 1);
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                map.remove(0);
//                System.out.println(map.get(0));
//            }
//        });
//
//
//        thread.start();
//        System.out.println(map.get(0));
////        }


        iteratorTest();
    }


    private static void iteratorTest() {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map.remove(entry.getKey());
        }
    }
}

package precipitated.will.json;

import com.alibaba.fastjson.JSON;

/**
 * Created by will.wang on 2015/11/14.
 */
public class Main {
    public static void main(String[] args) {

        /**
         * 会优先判断有没有map，如果存在map，按照map解析，field不会解析出来
         */
        TestBean bean = new TestBean();
        bean.setField("fdfdfdsffsd");
        bean.put("testKey", "fdfdfgeewewrer");
        bean.put("testKey11111111", "fdfdfgeewewrer111111111111111");
        System.out.println(JSON.toJSONString(bean));
    }
}

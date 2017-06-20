package precipitated.will.extend.abstractFields;

import com.alibaba.fastjson.JSON;

/**
 * Created by will.wang on 2016/9/12.
 */
public class InstanceClass extends AbstractClass {


    public static void main(String[] args) {
        InstanceClass instanceClass = new InstanceClass();
        System.out.println(JSON.toJSONString(InstanceClass.class.getFields()));
        System.out.println(JSON.toJSONString(InstanceClass.class.getDeclaredFields()));
        System.out.println(JSON.toJSONString(InstanceClass.class.getSuperclass().getFields()));
        System.out.println(JSON.toJSONString(InstanceClass.class.getSuperclass().getDeclaredFields()));
    }
}

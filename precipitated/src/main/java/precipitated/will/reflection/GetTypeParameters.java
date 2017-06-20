package precipitated.will.reflection;

import java.lang.reflect.TypeVariable;

/**
 * 泛型的类型参数
 * Created by will.wang on 2015/12/30.
 */
public class GetTypeParameters {

    public static void main(String[] args) throws ClassNotFoundException {
        TypeVariable<?>[] typeParameters = Class.forName("java.util.List").getTypeParameters();
        for(TypeVariable<?> t : typeParameters)
            System.out.print(t.getName()+",");
    }
}

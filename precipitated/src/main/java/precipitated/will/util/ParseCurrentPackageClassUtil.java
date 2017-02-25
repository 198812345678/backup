package precipitated.will.util;

import java.io.IOException;
import java.util.List;

/**
 * 获取当前包下所有class
 * Created by will.wang on 2016/2/14.
 */
public class ParseCurrentPackageClassUtil {

    public static List<Class> getAllClass() throws IOException, ClassNotFoundException {
        //得到当前包名
        Package currPackage = ParseCurrentPackageClassUtil.class.getPackage();
        String packageName = currPackage.getName();
        return ParseClassUtil.getAllClass(packageName);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(ParseCurrentPackageClassUtil.getAllClass());
    }
}

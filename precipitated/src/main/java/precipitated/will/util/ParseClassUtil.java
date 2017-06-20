package precipitated.will.util;

import com.google.common.collect.Lists;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.collections.CollectionUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.List;

/**
 * 得到包下所有class
 * 没有递归处理
 * Created by will.wang on 2016/2/14.
 */
public class ParseClassUtil {

    public static List<Class> getAllClass(String packageName) throws IOException, ClassNotFoundException {

        //将packageName转化成文件路径, 不是完整的路径
        String packagePath = getPackagePath(packageName);

        //得到Package的URL表示
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);

        List<Class> classList = Lists.newArrayList();
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            String filePath = URLDecoder.decode(url.getFile(), "UTF-8");

            File file = new File(filePath);
            if(!file.isDirectory()) {
                continue;
            }

            //获取目录资源下所有.class结尾的文件
            File[] files = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname != null && pathname.getName().endsWith(".class");
                }
            });

            if(files == null || files.length <= 0) {
                continue;
            }

            //根据Package和.class文件名拼接完整类名
            for (File subFile : files) {
                String fileName = subFile.getName();
                String fullName = packageName + "." + fileName.replaceAll(".class", "");
                Class clazz = Class.forName(fullName);
                classList.add(clazz);
            }

        }

        return classList;
    }

    public static String getPackagePath(String packageName) {
        String[] strs = packageName.split("\\.");
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if(i != 0) {
                path.append(File.separator);
            }
            path.append(strs[i]);
        }

        return path.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(ParseClassUtil.getAllClass("precipitated.will.util"));
    }
}

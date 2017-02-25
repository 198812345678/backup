package precipitated.will.temp;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.apache.commons.lang3.CharSet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by will.wang on 2016/5/23.
 */
public class JingXiShunfeng {

    public static void main(String[] args) throws IOException {
        File fileLeft = new File("F:\\oneDrive\\backup\\precipitated\\src\\main\\resources\\jingxileft.txt");
        List<String> leftLines = Files.readLines(fileLeft, Charsets.UTF_8);

        List<String> result = Lists.newLinkedList();
        for (String line : leftLines) {
            if(!line.contains("0.5\t-")) {
                result.add(line);
            }
        }

//        System.out.println(result.size());

        File resultFile = new File("F:\\oneDrive\\backup\\precipitated\\src\\main\\resources\\JingXiShunfengResult.txt");
        BufferedWriter writer = Files.newWriter(resultFile, Charsets.UTF_8);
        for (String s : result) {
            writer.append(s).append("\n");
        }


    }
}

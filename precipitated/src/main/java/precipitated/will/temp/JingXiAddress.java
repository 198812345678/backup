package precipitated.will.temp;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by will.wang on 2016/5/19.
 */
public class JingXiAddress {

    public static void main(String[] args) throws IOException {
        File fileLeft = new File("F:\\oneDrive\\backup\\precipitated\\src\\main\\resources\\jingxileft.txt");
        List<String> leftLines = Files.readLines(fileLeft, Charsets.UTF_8);

        File fileRight = new File("F:\\oneDrive\\backup\\precipitated\\src\\main\\resources\\jingxiRight.txt");
        List<String> rightLines = Files.readLines(fileRight, Charsets.UTF_8);

        List<String> leftLinesNoSpace = Lists.newArrayList();
        for (String leftLine : leftLines) {
            leftLine = leftLine.replaceAll("\\s", "");
            leftLinesNoSpace.add(leftLine);
        }

        List<String> rightLinesNoSpace = Lists.newArrayList();
        for (String rightLine : rightLines) {
            rightLine = rightLine.replaceAll("\\s", "");
            rightLinesNoSpace.add(rightLine);
        }

        List<String> leftLinesBck = Lists.newArrayList(leftLinesNoSpace);
        List<String> rightLinesBck = Lists.newArrayList(rightLinesNoSpace);

        leftLinesBck.removeAll(rightLinesNoSpace);
        rightLinesBck.removeAll(leftLinesNoSpace);

//        for (String line : leftLinesBck) {
//            System.out.println(line);
//        }

        System.out.println("==================================");

        for (String line : rightLinesBck) {
            System.out.println(line);
        }
    }
}

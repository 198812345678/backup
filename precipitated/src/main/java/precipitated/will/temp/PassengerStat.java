package precipitated.will.temp;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by will.wang on 2016/5/25.
 */
public class PassengerStat {


    public static void main(String[] args) throws IOException {
        File file = new File("F:\\oneDrive\\backup\\precipitated\\src\\main\\resources\\passengers.txt");
        List<String> lines = Files.readLines(file, Charsets.UTF_8);

        for (String line : lines) {
            String[] passengers = line.split("},");
            for (String passenger : passengers) {
                System.out.println(passenger);
            }
        }
    }
}

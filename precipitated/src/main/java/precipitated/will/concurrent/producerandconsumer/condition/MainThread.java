package precipitated.will.concurrent.producerandconsumer.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by will.wang on 2015/10/31.
 */
public class MainThread {

    public static void main(String[] args) {
        String[] content = getContent(10, 20);
        MockFile file = new MockFile(content);
        Buffer buffer = new Buffer(30);

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        executorService.submit(new Producer(file, buffer));

        for (int i = 0; i < 40; i++) {

            executorService.submit(new Consumer(buffer));
        }

        executorService.shutdown();
    }

    private static String[] getContent(int size, int length) {
        String[] content = new String[size];

        for (int i = 0; i < size; i++) {
            StringBuilder str = new StringBuilder(i);
            for (int j = 0; j < length; j++) {
                int ch = (int)Math.random() * 255;
                str.append((char)ch);
            }
            content[i] = str.toString();
        }

        return content;
    }
}

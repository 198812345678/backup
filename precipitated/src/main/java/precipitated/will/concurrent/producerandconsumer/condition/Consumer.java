package precipitated.will.concurrent.producerandconsumer.condition;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by will.wang on 2015/10/31.
 */
public class Consumer implements Callable{

    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }


    @Override
    public Object call() throws Exception {
        while (buffer.isPendingLines()) {
            String line = buffer.get();
            processLine(line);
        }

        return null;
    }

    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

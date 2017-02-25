package precipitated.will.concurrent.producerandconsumer.condition;

import java.util.concurrent.Callable;

/**
 * Created by will.wang on 2015/10/31.
 */
public class Producer implements Callable{

    private MockFile file;

    private Buffer buffer;

    public Producer(MockFile file, Buffer buffer) {
        this.file = file;
        this.buffer = buffer;
    }


    @Override
    public Object call() throws Exception {
        buffer.setPendingLines(true);
        while (file.hasMoreLines()) {
            String line = file.getLine();
            Thread.sleep(20);
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
        return null;
    }
}

package precipitated.will.concurrent.producerandconsumer.version1;

/**
 * Created by will.wang on 2015/10/25.
 */
public class Consumer{

    public void process() {
        try {
            TaskPool.processTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

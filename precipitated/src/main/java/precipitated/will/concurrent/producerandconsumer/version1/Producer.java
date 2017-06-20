package precipitated.will.concurrent.producerandconsumer.version1;

/**
 * Created by will.wang on 2015/10/25.
 */
public class Producer {

    public void produce() {
        BusinessTask task = new BusinessTask();

        try {
            TaskPool.addTask(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

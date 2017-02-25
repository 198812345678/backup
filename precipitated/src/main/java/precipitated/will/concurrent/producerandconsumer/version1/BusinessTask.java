package precipitated.will.concurrent.producerandconsumer.version1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by will.wang on 2015/10/25.
 */
public class BusinessTask {

    private static AtomicInteger taskId = new AtomicInteger(0);

    private int id;

    public BusinessTask() {
        id = taskId.getAndAdd(1);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void doSomething() {

    }

    @Override
    public boolean equals(Object obj) {
        BusinessTask otherTask = (BusinessTask)obj;
        if(this.id == otherTask.getId()) {
            return true;
        } else {
            return false;
        }
    }
}

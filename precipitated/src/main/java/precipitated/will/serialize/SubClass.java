package precipitated.will.serialize;

import java.io.Serializable;

/**
 * Created by will.wang on 2016/4/12.
 */
public class SubClass extends SuperClass implements Serializable {

    private static final long serialVersionUID = 2814600844466395130L;

    private SerializableClass serializableClass;


    public SubClass() {
    }

    public SubClass(int i) {
        super(i);
    }
}

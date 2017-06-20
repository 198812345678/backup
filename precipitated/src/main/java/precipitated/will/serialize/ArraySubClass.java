package precipitated.will.serialize;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;

/**
 * Created by will.wang on 2016/4/13.
 */
public class ArraySubClass extends AbstractList implements Serializable{
    private static final long serialVersionUID = 706153126918479980L;

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}

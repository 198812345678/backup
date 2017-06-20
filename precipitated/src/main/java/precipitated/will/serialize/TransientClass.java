package precipitated.will.serialize;

import java.beans.Transient;
import java.io.*;
import java.util.Date;

/**
 * Created by will.wang on 2016/4/21.
 */
public class TransientClass implements Serializable{

    private static final long serialVersionUID = 7545965842001745305L;
    private int t = 1;

    public TransientClass() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

}

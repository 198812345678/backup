package precipitated.will.util;

import java.util.Date;

/**
 * Created by will.wang on 2016/9/9.
 */
public class DateUtil {

    public static long getTimeStamp(Date date) {
        return date.getTime() / 1000;
    }
}

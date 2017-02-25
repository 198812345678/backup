package precipitated.will.concurrent.immutable;

import java.util.Date;

/**
 * Created by will.wang on 2016/1/2.
 */
public final class WithMutableField {
    private final Date date;

    private final String str;

    private final CommonClass commonClass;

    public WithMutableField(Date date, String str, CommonClass commonClass) {
        this.date = date;
        this.str = str;
        this.commonClass = commonClass;
    }

    public CommonClass getCommonClass() {
        return commonClass;
    }

    public Date getDate() {
        return date;
    }

    public String getStr() {
        return str;
    }

    public Date getDateCopy() {
        return (Date)date.clone();
    }
}

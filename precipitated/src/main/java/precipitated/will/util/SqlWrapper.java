package precipitated.will.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by will.wang on 2016/9/9.
 */
public class SqlWrapper {


    private static String huanyInsuranceSql_contain = "select from_unixtime({0}), count(1), 1 from orders_8 o, orders_ext_8 oe where o.agent_id = 409 and o.containInsurance = 1 and o.created_ts between {0} and {1} and o.username = $$ and o.order_no = oe.order_no and oe.classify = 101;";
    private static String huanyInsuranceSql_nocontain = "select from_unixtime({0}), count(1), 0 from orders_8 o, orders_ext_8 oe where o.agent_id = 409 and o.created_ts between {0} and {1} and o.username = $$ and o.order_no = oe.order_no and oe.classify = 101;";

    public static String wrapHuanyInsuranceSql() {
        Date startDate = new Date(1468166400000L);
        Date endDate = new Date(1473350400000L);

        Date curDate = startDate;
        while (curDate.before(endDate)) {
            Date sqlStartTime = curDate;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(sqlStartTime);
            calendar.add(Calendar.DATE, 1);
            Date sqlEndTime = calendar.getTime();

//            System.out.println("=========" + sqlStartTime + "---" + sqlEndTime + "=======");

            String startTimeStr = String.valueOf(sqlStartTime.getTime() / 1000);
            String endTimeStr = String.valueOf(sqlEndTime.getTime() / 1000);

            String contaimSql = MessageFormat.format(huanyInsuranceSql_contain, startTimeStr, endTimeStr);
            String nocontaimSql = MessageFormat.format(huanyInsuranceSql_nocontain, startTimeStr, endTimeStr);

            System.out.println(contaimSql);
            System.out.println(nocontaimSql);

            curDate = sqlEndTime;
        }

        return null;
    }

    public static void main(String[] args) {
        SqlWrapper.wrapHuanyInsuranceSql();
    }
}

package precipitated.will.util;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by will on 16/8/7.
 */
public class JunjieStat {

    public static void main(String[] args) throws IOException {
        File source = new File("F:\\oneDrive\\backup\\precipitated\\src\\main\\resources\\junjie5.txt");
        List<String> lines = Files.readLines(source, Charsets.UTF_8);

        /**
         * 180kw0f9771 武昌 岳阳 K109   201608021846   201608022120   1470124759 32.50  K  硬座
         */
        List<Record> recordList = Lists.newArrayList();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] lineElms = line.split("[\\s]+");
            Record record = new Record();
            record.setPhone(lineElms[0]);
            record.setTrainFrom(lineElms[1]);
            record.setTrainTo(lineElms[2]);
            record.setTrainNo(lineElms[3]);
            record.setTrainStartTime(lineElms[4]);
            record.setTrainEndTime(lineElms[5]);
            record.setCreatedTs(lineElms[6]);
            record.setTicketPrice(lineElms[7]);
            record.setTrainType(lineElms[8]);
            record.setSeat(lineElms[9]);
//            record.setOrderLabel(lineElms[10]);
            recordList.add(record);
        }

        /**条件1*/
//        recordList = doFilter1(recordList);

        /**条件2/3*/
//        recordList = doFilter2(recordList);

        System.out.println(recordList.size());
        Map<String, Integer> recordIntegerMap = countGroupByRecord(recordList);
        System.out.println(recordIntegerMap.size());
    }

    /**
     * 8454144,8454944,8454176,8978720,12648448,8454208,8979232,8454432,8486944,8388608
     * @param recordList
     * @return
     */
    private static List<Record> doFilter2(List<Record> recordList) {
        List<Record> result = Lists.newArrayList();

        for (Record record : recordList) {
            String orderLabel = record.getOrderLabel();
            if(orderLabel.equals("8454144")
                    || orderLabel.equals("8454944")
                    || orderLabel.equals("8454176")
                    || orderLabel.equals("8978720")
                    || orderLabel.equals("12648448")
                    || orderLabel.equals("8454208")
                    || orderLabel.equals("8979232")
                    || orderLabel.equals("8454432")
                    || orderLabel.equals("8486944")
                    || orderLabel.equals("8388608")) {
                result.add(record);
            }
        }
        return result;
    }

    /**
     * vid='60001141' and 票价>50 and 下单时间在 '2016-08-01 16:00:00' and '2016-08-02 16:00:00'
     and 车次类型：G and 坐席：一等座/二等座/商务座 and 发车时间 ：08:00-10:00 and 到达时间： 01:00-23:05
     * @param recordList
     * @return
     */
    private static List<Record> doFilter1(List<Record> recordList) {
        List<Record> result = Lists.newArrayList();
        for (Record record : recordList) {
            BigDecimal price = new BigDecimal(record.getTicketPrice());
            String startTime = null;
            try {
                startTime = record.getTrainStartTime().substring(8);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(record.getPhone());
                System.out.println(startTime);
            }
            String endTime = null;
            try {
                endTime = record.getTrainEndTime().substring(8);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(record.getPhone());
                System.out.println(endTime);
            }
            if(price.compareTo(new BigDecimal("50")) > 0
                    && record.getTrainType().equals("G")
                    && (record.getSeat().equals("一等座") || record.getSeat().equals("二等座") || record.getSeat().equals("商务座"))
                    && (startTime.compareTo("0800") >= 0 && startTime.compareTo("1000") <= 0)
                    && (endTime.compareTo("0100") >= 0 && endTime.compareTo("2305") <= 0)) {
                result.add(record);
            }
        }
        return result;
    }

    private static Map<String, Integer> countGroupByRecord(List<Record> recordList) {

        Map<String, Integer> result = Maps.newHashMap();
        for (Record record : recordList) {
            if(result.get(record.getKey()) == null) {
                result.put(record.getKey(), Integer.valueOf(0));
            }

            result.put(record.getKey(), result.get(record.getKey()) + 1);
        }

        return result;
    }

    private static Map<Record, Integer> countGroupByRecord2(List<Record> recordList) {

        Map<Record, Integer> result = Maps.newHashMap();
        for (Record record : recordList) {
            Integer value = result.get(record);
            System.out.println(value);
            if(value == null) {
                result.put(record, Integer.valueOf(0));
            }
            result.put(record, 1);
        }

        return result;
    }



}
package precipitated.will.util;

/**
 * Created by will.wang on 2016/8/8.
 */

import com.alibaba.fastjson.JSON;

/**
 * SELECT o.contact_phone, o.train_from, o.train_to, o.train_no, o.train_start_time, o.train_end_time, o.created_ts, o.ticket_price, o.train_type, o.train_seat
 */
public class Record {
    private String phone;
    private String trainFrom;
    private String trainTo;
    private String trainNo;
    private String trainStartTime;
    private String trainEndTime;
    private String createdTs;
    private String ticketPrice;
    private String trainType;
    private String seat;
    private String orderLabel;

    @Override
    public boolean equals(Object o) {
        Record record = (Record)o;
        System.out.println(JSON.toJSONString(record));
        if(phone.equals(record.getPhone())
                && trainFrom.equals(record.getTrainFrom())
                && trainTo.equals(record.getTrainTo())
                && trainNo.equals(record.getTrainNo())
                && trainStartTime.equals(record.getTrainStartTime())) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public String getKey() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(phone).append(trainFrom).append(trainTo).append(trainNo).append(trainStartTime);
        return stringBuffer.toString();
    }

    public boolean equals(Record o) {
        Record record = (Record)o;
        System.out.println(JSON.toJSONString(record));
        if(phone.equals(record.getPhone())
                && trainFrom.equals(record.getTrainFrom())
                && trainTo.equals(record.getTrainTo())
                && trainNo.equals(record.getTrainNo())
                && trainStartTime.equals(record.getTrainStartTime())) {
            return true;
        }

        return false;
    }

    public String getOrderLabel() {
        return orderLabel;
    }

    public void setOrderLabel(String orderLabel) {
        this.orderLabel = orderLabel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTrainFrom() {
        return trainFrom;
    }

    public void setTrainFrom(String trainFrom) {
        this.trainFrom = trainFrom;
    }

    public String getTrainTo() {
        return trainTo;
    }

    public void setTrainTo(String trainTo) {
        this.trainTo = trainTo;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainStartTime() {
        return trainStartTime;
    }

    public void setTrainStartTime(String trainStartTime) {
        this.trainStartTime = trainStartTime;
    }

    public String getTrainEndTime() {
        return trainEndTime;
    }

    public void setTrainEndTime(String trainEndTime) {
        this.trainEndTime = trainEndTime;
    }

    public String getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(String createdTs) {
        this.createdTs = createdTs;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
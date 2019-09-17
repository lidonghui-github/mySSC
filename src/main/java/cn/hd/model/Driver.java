package cn.hd.model;

import java.io.Serializable;
import java.util.Date;

public class Driver implements Serializable{
    private String driverId;

    private String driverName;

    private String driverSex;

    private String driverIdcardNumber;

    private String driverTelNumber;

    private Date driverCrtTime;

    private String driverOperationStatus;

    private String driverAddress;

    private Integer driverFinisedOrderSum;

    private String driverCurrentOrderNumber;

    private Date driverLastOrderEndTime;

    private Date cancellationTime;

    private String remark;

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    public String getDriverSex() {
        return driverSex;
    }

    public void setDriverSex(String driverSex) {
        this.driverSex = driverSex == null ? null : driverSex.trim();
    }

    public String getDriverIdcardNumber() {
        return driverIdcardNumber;
    }

    public void setDriverIdcardNumber(String driverIdcardNumber) {
        this.driverIdcardNumber = driverIdcardNumber == null ? null : driverIdcardNumber.trim();
    }

    public String getDriverTelNumber() {
        return driverTelNumber;
    }

    public void setDriverTelNumber(String driverTelNumber) {
        this.driverTelNumber = driverTelNumber == null ? null : driverTelNumber.trim();
    }

    public Date getDriverCrtTime() {
        return driverCrtTime;
    }

    public void setDriverCrtTime(Date driverCrtTime) {
        this.driverCrtTime = driverCrtTime;
    }

    public String getDriverOperationStatus() {
        return driverOperationStatus;
    }

    public void setDriverOperationStatus(String driverOperationStatus) {
        this.driverOperationStatus = driverOperationStatus == null ? null : driverOperationStatus.trim();
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress == null ? null : driverAddress.trim();
    }

    public Integer getDriverFinisedOrderSum() {
        return driverFinisedOrderSum;
    }

    public void setDriverFinisedOrderSum(Integer driverFinisedOrderSum) {
        this.driverFinisedOrderSum = driverFinisedOrderSum;
    }

    public String getDriverCurrentOrderNumber() {
        return driverCurrentOrderNumber;
    }

    public void setDriverCurrentOrderNumber(String driverCurrentOrderNumber) {
        this.driverCurrentOrderNumber = driverCurrentOrderNumber == null ? null : driverCurrentOrderNumber.trim();
    }

    public Date getDriverLastOrderEndTime() {
        return driverLastOrderEndTime;
    }

    public void setDriverLastOrderEndTime(Date driverLastOrderEndTime) {
        this.driverLastOrderEndTime = driverLastOrderEndTime;
    }

    public Date getCancellationTime() {
        return cancellationTime;
    }

    public void setCancellationTime(Date cancellationTime) {
        this.cancellationTime = cancellationTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
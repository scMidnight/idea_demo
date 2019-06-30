package person.db.bean;

import java.io.Serializable;
import java.util.Date;

public class CarFindBean implements Serializable {
    private String id;
    private Date uploadDate;//上传时间
    private String taskId;//任务ID
    private String name;//姓名
    private String phone;//手机
    private String provName;//省
    private String cityName;//城市名称
    private String carSys;//车系
    private String brand;//品牌
    private String trade;//厂商
    private String fileNameBak;//附件原名称
    private String fileName;//文件名
    private String sourceTag;//来源
    private String bigLibRepeatCount;//大库重复条数
    private String brandCount;//品牌重复次数
    private String tradeCount;//厂商重复次数
    private String carSysRepeatCount;//车系重复条数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCarSys() {
        return carSys;
    }

    public void setCarSys(String carSys) {
        this.carSys = carSys;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getFileNameBak() {
        return fileNameBak;
    }

    public void setFileNameBak(String fileNameBak) {
        this.fileNameBak = fileNameBak;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSourceTag() {
        return sourceTag;
    }

    public void setSourceTag(String sourceTag) {
        this.sourceTag = sourceTag;
    }

    public String getBigLibRepeatCount() {
        return bigLibRepeatCount;
    }

    public void setBigLibRepeatCount(String bigLibRepeatCount) {
        this.bigLibRepeatCount = bigLibRepeatCount;
    }

    public String getBrandCount() {
        return brandCount;
    }

    public void setBrandCount(String brandCount) {
        this.brandCount = brandCount;
    }

    public String getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(String tradeCount) {
        this.tradeCount = tradeCount;
    }

    public String getCarSysRepeatCount() {
        return carSysRepeatCount;
    }

    public void setCarSysRepeatCount(String carSysRepeatCount) {
        this.carSysRepeatCount = carSysRepeatCount;
    }
}

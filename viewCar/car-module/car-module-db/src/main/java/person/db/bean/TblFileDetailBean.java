package person.db.bean;

import java.io.Serializable;
import java.util.Date;

public class TblFileDetailBean implements Serializable {
    private String id;
    private String fileId;//文件表ID
    private String fileName;//文件名
    private String taskId;//任务ID
    private String name;//姓名
    private String phone;//手机
    private String area;//地区
    private String carSys;//车系
    private String status;//状态：0 正常，1 大库重复，2 任务重复，3 车系重复，4 黑名单命中，5 号段错误，6 ID转失败，7 品牌重复， 8 厂商重复,
    private TblFileBean fileBean;//文件表
    private String errInfo;//错误描述，用来生成错误txt文件
    private String color;
    private String statusDesc;//状态描述
    private Date uploadDate;//上传时间
    private String orderNum;//排序字段
    private String brand;//品牌
    private String trade;//厂商
    private String isLian;//后四位连号重复，30天内数据
    private String isChong;//前6位重复，30天内数据

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCarSys() {
        return carSys;
    }

    public void setCarSys(String carSys) {
        this.carSys = carSys;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TblFileBean getFileBean() {
        return fileBean;
    }

    public void setFileBean(TblFileBean fileBean) {
        this.fileBean = fileBean;
    }

    public String getErrInfo() {
        return errInfo;
    }

    public void setErrInfo(String errInfo) {
        this.errInfo = errInfo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
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

    public String getIsLian() {
        return isLian;
    }

    public void setIsLian(String isLian) {
        this.isLian = isLian;
    }

    public String getIsChong() {
        return isChong;
    }

    public void setIsChong(String isChong) {
        this.isChong = isChong;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}

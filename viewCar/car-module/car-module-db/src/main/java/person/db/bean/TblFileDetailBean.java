package person.db.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TblFileDetailBean implements Serializable {
    private String id;
    private String fileId;//文件表ID
    private String fileName;//文件名
    private String taskId;//任务ID
    private String name;//姓名
    private String phone;//手机
    private String area;//地区
    private String carSys;//车系
    private String status;//状态：0 正常，1 大库重复，2 任务重复，3 车系重复，4 黑名单命中，5 号段错误，6 ID转失败
    private TblFileBean fileBean;//文件表
    private String errInfo;//错误描述，用来生成错误txt文件
    private String color;
    private Date uploadDate;//上传时间

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
}

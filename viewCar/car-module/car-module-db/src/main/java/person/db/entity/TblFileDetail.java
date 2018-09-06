package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_FILE_DETAIL")
public class TblFileDetail extends IdEntity {
    private String fileId;//文件表ID
    private String fileName;//文件名
    private String taskId;//任务ID
    private String name;//姓名
    private String phone;//手机
    private String area;//地区
    private String carSys;//车系
    private String status;//状态：0 正常，1 大库重复，2 任务重复，3 车系重复，4 黑名单命中，5 号段错误，6 ID转失败
    private String errInfo;//错误描述，用来生成错误txt文件

    @Column(name = "FILE_ID")
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "task_id")
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "area")
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "car_sys")
    public String getCarSys() {
        return carSys;
    }

    public void setCarSys(String carSys) {
        this.carSys = carSys;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "err_info")
    public String getErrInfo() {
        return errInfo;
    }

    public void setErrInfo(String errInfo) {
        this.errInfo = errInfo;
    }
}

package person.db.bean;

import java.io.Serializable;
import java.util.Date;

public class TblFileBean implements Serializable {
    private String id;//主键
    private String fileName;//附件名称
    private String fileNameBak;//附件原名称
    private String filePath;//附件路径
    private Date uploadDate;//上传时间
    private String status;//状态：0 待整理，1 已整理
    private String fileCount;//文件总数
    private String sumCount;//合计条数
    private String problemCount;//问题条数
    private String taskRepeatCount;//任务重复条数
    private String carSysRepeatCount;//车系重复条数
    private String bigLibRepeatCount;//大库重复条数
    private String blackHitCount;//黑名单命中条数
    private String numberErrCount;//号段错误条数
    private String idFailedCount;//id转失败条数
    private String tradeCount;//厂商重复次数
    private String brandCount;//品牌重复次数
    private String housiCount;//后四连号
    private String qianliuCount;//前六重复

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileNameBak() {
        return fileNameBak;
    }

    public void setFileNameBak(String fileNameBak) {
        this.fileNameBak = fileNameBak;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFileCount() {
        return fileCount;
    }

    public void setFileCount(String fileCount) {
        this.fileCount = fileCount;
    }

    public String getSumCount() {
        return sumCount;
    }

    public void setSumCount(String sumCount) {
        this.sumCount = sumCount;
    }

    public String getProblemCount() {
        return problemCount;
    }

    public void setProblemCount(String problemCount) {
        this.problemCount = problemCount;
    }

    public String getTaskRepeatCount() {
        return taskRepeatCount;
    }

    public void setTaskRepeatCount(String taskRepeatCount) {
        this.taskRepeatCount = taskRepeatCount;
    }

    public String getCarSysRepeatCount() {
        return carSysRepeatCount;
    }

    public void setCarSysRepeatCount(String carSysRepeatCount) {
        this.carSysRepeatCount = carSysRepeatCount;
    }

    public String getBigLibRepeatCount() {
        return bigLibRepeatCount;
    }

    public void setBigLibRepeatCount(String bigLibRepeatCount) {
        this.bigLibRepeatCount = bigLibRepeatCount;
    }

    public String getBlackHitCount() {
        return blackHitCount;
    }

    public void setBlackHitCount(String blackHitCount) {
        this.blackHitCount = blackHitCount;
    }

    public String getNumberErrCount() {
        return numberErrCount;
    }

    public void setNumberErrCount(String numberErrCount) {
        this.numberErrCount = numberErrCount;
    }

    public String getIdFailedCount() {
        return idFailedCount;
    }

    public void setIdFailedCount(String idFailedCount) {
        this.idFailedCount = idFailedCount;
    }

    public String getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(String tradeCount) {
        this.tradeCount = tradeCount;
    }

    public String getBrandCount() {
        return brandCount;
    }

    public void setBrandCount(String brandCount) {
        this.brandCount = brandCount;
    }

    public String getHousiCount() {
        return housiCount;
    }

    public void setHousiCount(String housiCount) {
        this.housiCount = housiCount;
    }

    public String getQianliuCount() {
        return qianliuCount;
    }

    public void setQianliuCount(String qianliuCount) {
        this.qianliuCount = qianliuCount;
    }
}

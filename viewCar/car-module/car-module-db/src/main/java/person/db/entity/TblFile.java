package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_FILE")
public class TblFile extends IdEntity {
    private String fileName;//附件名称
    private String fileNameBak;//附件原名称
    private String filePath;//附件路径
    private Date uploadDate;//上传时间
    private String status;//状态：状态：0 待整理，1 已整理
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

    @Column(name = "FILE_NAME")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "FILE_NAME_BAK")
    public String getFileNameBak() {
        return fileNameBak;
    }

    public void setFileNameBak(String fileNameBak) {
        this.fileNameBak = fileNameBak;
    }

    @Column(name = "FILE_PATH")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Column(name = "UPLOAD_DATE")
    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "file_count")
    public String getFileCount() {
        return fileCount;
    }

    public void setFileCount(String fileCount) {
        this.fileCount = fileCount;
    }

    @Column(name = "sum_count")
    public String getSumCount() {
        return sumCount;
    }

    public void setSumCount(String sumCount) {
        this.sumCount = sumCount;
    }

    @Column(name = "problem_count")
    public String getProblemCount() {
        return problemCount;
    }

    public void setProblemCount(String problemCount) {
        this.problemCount = problemCount;
    }

    @Column(name = "task_repeat_count")
    public String getTaskRepeatCount() {
        return taskRepeatCount;
    }

    public void setTaskRepeatCount(String taskRepeatCount) {
        this.taskRepeatCount = taskRepeatCount;
    }

    @Column(name = "carsys_repeat_count")
    public String getCarSysRepeatCount() {
        return carSysRepeatCount;
    }

    public void setCarSysRepeatCount(String carSysRepeatCount) {
        this.carSysRepeatCount = carSysRepeatCount;
    }

    @Column(name = "biglib_repeat_count")
    public String getBigLibRepeatCount() {
        return bigLibRepeatCount;
    }

    public void setBigLibRepeatCount(String bigLibRepeatCount) {
        this.bigLibRepeatCount = bigLibRepeatCount;
    }

    @Column(name = "black_hit_count")
    public String getBlackHitCount() {
        return blackHitCount;
    }

    public void setBlackHitCount(String blackHitCount) {
        this.blackHitCount = blackHitCount;
    }

    @Column(name = "number_err_count")
    public String getNumberErrCount() {
        return numberErrCount;
    }

    public void setNumberErrCount(String numberErrCount) {
        this.numberErrCount = numberErrCount;
    }

    @Column(name = "id_failed_count")
    public String getIdFailedCount() {
        return idFailedCount;
    }

    public void setIdFailedCount(String idFailedCount) {
        this.idFailedCount = idFailedCount;
    }

    @Column(name = "trade_count")
    public String getTradeCount() {
        return tradeCount;
    }

    public void setTradeCount(String tradeCount) {
        this.tradeCount = tradeCount;
    }

    @Column(name = "brand_count")
    public String getBrandCount() {
        return brandCount;
    }

    public void setBrandCount(String brandCount) {
        this.brandCount = brandCount;
    }
}

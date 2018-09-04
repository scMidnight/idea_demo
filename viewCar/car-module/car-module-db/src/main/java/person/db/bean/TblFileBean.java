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
}

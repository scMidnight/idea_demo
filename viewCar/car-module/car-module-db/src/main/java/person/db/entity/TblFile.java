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
}

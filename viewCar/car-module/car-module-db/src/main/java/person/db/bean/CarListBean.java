package person.db.bean;

public class CarListBean {
    private TblFileBean fileBean;//文件实体
    private String fileCount;//文件总数
    private String sumCount;//合计条数
    private String problemCount;//问题条数
    private String taskRepeatCount;//任务重复条数
    private String carSysRepeatCount;//车系重复条数
    private String bigLibraryRepeatCount;//大库重复条数
    private String blackHitRepeatCount;//黑名单命中条数
    private String numberErrCount;//号段错误条数
    private String idFailedCount;//id转失败条数

    public TblFileBean getFileBean() {
        return fileBean;
    }

    public void setFileBean(TblFileBean fileBean) {
        this.fileBean = fileBean;
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

    public String getBigLibraryRepeatCount() {
        return bigLibraryRepeatCount;
    }

    public void setBigLibraryRepeatCount(String bigLibraryRepeatCount) {
        this.bigLibraryRepeatCount = bigLibraryRepeatCount;
    }

    public String getBlackHitRepeatCount() {
        return blackHitRepeatCount;
    }

    public void setBlackHitRepeatCount(String blackHitRepeatCount) {
        this.blackHitRepeatCount = blackHitRepeatCount;
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
}

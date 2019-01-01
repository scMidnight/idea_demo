package person.db.bean;

import java.io.Serializable;
import java.util.Date;

public class TblFlowAnalysisBean implements Serializable {
    private String id;
    private Date insertDate;//插入时间
    private String insertMonth;//插入月份
    private String moduleName;//模块名称
    private String titleName;//标题名称
    private String exposureNum;//曝光次数
    private String clickNum;//点击次数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getInsertMonth() {
        return insertMonth;
    }

    public void setInsertMonth(String insertMonth) {
        this.insertMonth = insertMonth;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getExposureNum() {
        return exposureNum;
    }

    public void setExposureNum(String exposureNum) {
        this.exposureNum = exposureNum;
    }

    public String getClickNum() {
        return clickNum;
    }

    public void setClickNum(String clickNum) {
        this.clickNum = clickNum;
    }
}

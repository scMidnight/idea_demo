package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by SunChang on 2018/11/29
 * 汽车流量分析表
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_flow_analysis")
public class TblFlowAnalysis extends IdEntity {
    private Date insertDate;//插入时间
    private String insertMonth;//插入月份
    private String moduleName;//模块名称
    private String titleName;//标题名称
    private String exposureNum;//曝光次数
    private String clickNum;//点击次数

    @Column(name = "insert_date")
    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Column(name = "insert_month")
    public String getInsertMonth() {
        return insertMonth;
    }

    public void setInsertMonth(String insertMonth) {
        this.insertMonth = insertMonth;
    }

    @Column(name = "module_name")
    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    @Column(name = "title_name")
    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    @Column(name = "exposure_num")
    public String getExposureNum() {
        return exposureNum;
    }

    public void setExposureNum(String exposureNum) {
        this.exposureNum = exposureNum;
    }

    @Column(name = "click_num")
    public String getClickNum() {
        return clickNum;
    }

    public void setClickNum(String clickNum) {
        this.clickNum = clickNum;
    }
}

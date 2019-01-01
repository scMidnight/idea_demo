package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by SunChang on 2018/11/29
 * 线下潜客筛选
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_offline_filter")
public class TblOfflineFilter extends IdEntity {
    private Date insertDate;//插入时间
    private String source;//时刻来源（经销商）
    private String city;//所在城市
    private String brandName;//所属品牌
    private String offlineFlow;//线下流量
    private String stayDate;//平均停留时间
    private String insertMonth;//插入月份

    @Column(name = "insert_date")
    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "brand_name")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Column(name = "offline_flow")
    public String getOfflineFlow() {
        return offlineFlow;
    }

    public void setOfflineFlow(String offlineFlow) {
        this.offlineFlow = offlineFlow;
    }

    @Column(name = "stay_date")
    public String getStayDate() {
        return stayDate;
    }

    public void setStayDate(String stayDate) {
        this.stayDate = stayDate;
    }

    @Column(name = "insert_month")
    public String getInsertMonth() {
        return insertMonth;
    }

    public void setInsertMonth(String insertMonth) {
        this.insertMonth = insertMonth;
    }
}

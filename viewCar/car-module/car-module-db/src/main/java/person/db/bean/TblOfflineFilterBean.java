package person.db.bean;

import java.io.Serializable;
import java.util.Date;

public class TblOfflineFilterBean implements Serializable {
    private String id;
    private Date insertDate;//插入时间
    private String insertMonth;//插入月份
    private String source;//时刻来源（经销商）
    private String city;//所在城市
    private String brandName;//所属品牌
    private String offlineFlow;//线下流量
    private String stayDate;//平均停留时间

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getOfflineFlow() {
        return offlineFlow;
    }

    public void setOfflineFlow(String offlineFlow) {
        this.offlineFlow = offlineFlow;
    }

    public String getStayDate() {
        return stayDate;
    }

    public void setStayDate(String stayDate) {
        this.stayDate = stayDate;
    }
}

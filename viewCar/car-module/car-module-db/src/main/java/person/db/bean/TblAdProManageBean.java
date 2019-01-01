package person.db.bean;

import java.io.Serializable;
import java.util.Date;

public class TblAdProManageBean implements Serializable {
    private String id;
    private Date insertDate;//插入时间
    private String proId;//项目ID
    private String proName;//项目名称
    private String brandName;//品牌名称
    private String tradeName;//厂商名称
    private String carSysName;//车系名称
    private String status;//0投放中，1投放暂停，2投放结束


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

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getCarSysName() {
        return carSysName;
    }

    public void setCarSysName(String carSysName) {
        this.carSysName = carSysName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

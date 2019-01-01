package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by SunChang on 2018/11/29
 * 广告项目管理
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_ad_pro_manage")
public class TblAdProManage extends IdEntity {
    private Date insertDate;//插入时间
    private String proId;//项目ID
    private String proName;//项目名称
    private String brandName;//品牌名称
    private String tradeName;//厂商名称
    private String carSysName;//车系名称
    private String status;//0投放中，1投放暂停，2投放结束

    @Column(name = "insert_date")
    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Column(name = "pro_id")
    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    @Column(name = "pro_name")
    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Column(name = "brand_name")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Column(name = "trade_name")
    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    @Column(name = "car_sys_name")
    public String getCarSysName() {
        return carSysName;
    }

    public void setCarSysName(String carSysName) {
        this.carSysName = carSysName;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

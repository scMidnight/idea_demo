package person.db.entity;

import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by SunChang on 2018/8/27
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_CAR_SYSTEM")
public class TblCarSystem extends IdEntity {
    private String brandName;//品牌口称
    private String brandId;//品牌ID
    private String tradeName;//厂商名称
    private String tradeId;//厂商ID
    private String carSysName;//车系名称
    private String carSysId;//车系ID
    private String isDel;//是否删除0否1是
    private Date insertDate;//插入时间
    private String type;//分类 1国产，2合资，3进口
    private String typeId;//分类ID
    private String remark;//备注

    @Column(name = "BRAND_NAME")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Column(name = "BRAND_ID")
    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    @Column(name = "TRADE_NAME")
    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    @Column(name = "TRADE_ID")
    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    @Column(name = "CAR_SYS_NAME")
    public String getCarSysName() {
        return carSysName;
    }

    public void setCarSysName(String carSysName) {
        this.carSysName = carSysName;
    }

    @Column(name = "CAR_SYS_ID")
    public String getCarSysId() {
        return carSysId;
    }

    public void setCarSysId(String carSysId) {
        this.carSysId = carSysId;
    }

    @Column(name = "IS_DEL")
    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    @Column(name = "insert_date")
    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="type_id")
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

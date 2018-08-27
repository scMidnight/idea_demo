package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by SunChang on 2018/8/27
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_CAR_SYSTEM")
public class TblCarSystem extends IdEntity {
    private String brandName;
    private String brandId;
    private String tradeName;
    private String tradeId;
    private String carSysName;
    private String carSysId;
    private String isDel;

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
}

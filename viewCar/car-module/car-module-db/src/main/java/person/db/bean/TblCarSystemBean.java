package person.db.bean;

import java.io.Serializable;

/**
 * Created by SunChang on 2018/8/27
 */
public class TblCarSystemBean implements Serializable {
    private String id;//主键
    private String brandName;//品牌口称
    private String brandId;//品牌ID
    private String tradeName;//厂商名称
    private String tradeId;//厂商ID
    private String carSysName;//车系名称
    private String carSysId;//车系ID
    private String isDel;//是否删除0否1是

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getCarSysName() {
        return carSysName;
    }

    public void setCarSysName(String carSysName) {
        this.carSysName = carSysName;
    }

    public String getCarSysId() {
        return carSysId;
    }

    public void setCarSysId(String carSysId) {
        this.carSysId = carSysId;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}

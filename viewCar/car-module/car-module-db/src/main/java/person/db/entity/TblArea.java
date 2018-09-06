package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by SunChang on 2018/9/6
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_AREA")
public class TblArea extends IdEntity {
    private String areaCode;//编码
    private String cityName;//城市名称
    private String provName;//省

    @Column(name = "AREA_CODE")
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @Column(name = "CITY_NAME")
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Column(name = "PROV_NAME")
    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }
}

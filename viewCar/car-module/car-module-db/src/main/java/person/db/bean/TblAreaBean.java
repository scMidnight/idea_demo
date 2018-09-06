package person.db.bean;

import java.io.Serializable;

/**
 * Created by SunChang on 2018/9/6
 */
public class TblAreaBean implements Serializable {
    private String id;
    private String areaCode;//编码
    private String cityName;//城市名称
    private String provName;//省

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }
}

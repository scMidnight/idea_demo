package person.db.bean;

/**
 * Created by SunChang on 2018/9/11
 */
public class StatisticsBean {
    private String carSys;//车系
    private String tradeName;//厂商
    private String sum;//总量
    private String city;//城市
    private String prov;//省份
    private String id;//各个的编码，不知道怎么描述，看代码就懂了

    public String getCarSys() {
        return carSys;
    }

    public void setCarSys(String carSys) {
        this.carSys = carSys;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

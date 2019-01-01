package person.db.bean;

import java.io.Serializable;
import java.util.Date;

public class TblIntentClientBean implements Serializable {
    private String id;
    private Date insertDate;//采集时间
    private String userName;//客户名称
    private String phone;//手机
    private String age;//年龄
    private String brandName;//意向品牌
    private String carSys;//意向车第
    private String carProduct;//意向车系金融产品
    private String stage;//所处阶段
    private String source;//来源经销商

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCarSys() {
        return carSys;
    }

    public void setCarSys(String carSys) {
        this.carSys = carSys;
    }

    public String getCarProduct() {
        return carProduct;
    }

    public void setCarProduct(String carProduct) {
        this.carProduct = carProduct;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

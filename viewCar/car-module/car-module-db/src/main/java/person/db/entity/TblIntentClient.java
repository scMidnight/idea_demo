package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by SunChang on 2018/11/29
 * 意向客户采集
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_intent_client")
public class TblIntentClient extends IdEntity {
    private Date insertDate;//采集时间
    private String userName;//客户名称
    private String phone;//手机
    private String age;//年龄
    private String brandName;//意向品牌
    private String carSys;//意向车第
    private String carProduct;//意向车系金融产品
    private String stage;//所处阶段
    private String source;//来源经销商

    @Column(name = "insert_date")
    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Column(name = "brand_name")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Column(name = "car_sys")
    public String getCarSys() {
        return carSys;
    }

    public void setCarSys(String carSys) {
        this.carSys = carSys;
    }

    @Column(name = "car_product")
    public String getCarProduct() {
        return carProduct;
    }

    public void setCarProduct(String carProduct) {
        this.carProduct = carProduct;
    }

    @Column(name = "stage")
    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    @Column(name ="source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

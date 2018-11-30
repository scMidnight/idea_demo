package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by SunChang on 2018/11/29
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_SHOW")
public class TblShow extends IdEntity {
    private String source;//来源
    private String intentionPerson;//意向人
    private String cityOrientation;//城市定向
    private String intentionBrand;//意向品牌
    private String intentionTrade;//意向厂商
    private String intentionModel;//意向车型
    private String phone;//手机号
    private String networkNum;//网络跟踪频次
    private String analysis;//购车意向分析
    private String carMonth;//欲购车月份
    private String insertDate;//载入时间

    @Column(name = "source")
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Column(name = "intention_person")
    public String getIntentionPerson() {
        return intentionPerson;
    }

    public void setIntentionPerson(String intentionPerson) {
        this.intentionPerson = intentionPerson;
    }

    @Column(name = "city_orientation")
    public String getCityOrientation() {
        return cityOrientation;
    }

    public void setCityOrientation(String cityOrientation) {
        this.cityOrientation = cityOrientation;
    }

    @Column(name = "intention_brand")
    public String getIntentionBrand() {
        return intentionBrand;
    }

    public void setIntentionBrand(String intentionBrand) {
        this.intentionBrand = intentionBrand;
    }

    @Column(name = "intention_trade")
    public String getIntentionTrade() {
        return intentionTrade;
    }

    public void setIntentionTrade(String intentionTrade) {
        this.intentionTrade = intentionTrade;
    }

    @Column(name = "intention_model")
    public String getIntentionModel() {
        return intentionModel;
    }

    public void setIntentionModel(String intentionModel) {
        this.intentionModel = intentionModel;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "network_num")
    public String getNetworkNum() {
        return networkNum;
    }

    public void setNetworkNum(String networkNum) {
        this.networkNum = networkNum;
    }

    @Column(name = "analysis")
    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    @Column(name = "car_month")
    public String getCarMonth() {
        return carMonth;
    }

    public void setCarMonth(String carMonth) {
        this.carMonth = carMonth;
    }

    @Column(name = "insert_date")
    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }
}

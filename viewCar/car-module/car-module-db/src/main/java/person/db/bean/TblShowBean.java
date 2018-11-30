package person.db.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SunChang on 2018/11/29
 */
public class TblShowBean implements Serializable {
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIntentionPerson() {
        return intentionPerson;
    }

    public void setIntentionPerson(String intentionPerson) {
        this.intentionPerson = intentionPerson;
    }

    public String getCityOrientation() {
        return cityOrientation;
    }

    public void setCityOrientation(String cityOrientation) {
        this.cityOrientation = cityOrientation;
    }

    public String getIntentionBrand() {
        return intentionBrand;
    }

    public void setIntentionBrand(String intentionBrand) {
        this.intentionBrand = intentionBrand;
    }

    public String getIntentionTrade() {
        return intentionTrade;
    }

    public void setIntentionTrade(String intentionTrade) {
        this.intentionTrade = intentionTrade;
    }

    public String getIntentionModel() {
        return intentionModel;
    }

    public void setIntentionModel(String intentionModel) {
        this.intentionModel = intentionModel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNetworkNum() {
        return networkNum;
    }

    public void setNetworkNum(String networkNum) {
        this.networkNum = networkNum;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public String getCarMonth() {
        return carMonth;
    }

    public void setCarMonth(String carMonth) {
        this.carMonth = carMonth;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }
}

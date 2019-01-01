package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by SunChang on 2018/8/22
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_FUNCTION")
public class TblFunction extends IdEntity {
    private String functionName;
    private String functionDescription;
    private String functionLevel;
    private String functionUrl;
    private String functionType;//1:线上广告管理，2:线下潜客筛选，3:车金融潜客挖掘，4:线索优化管理，5:账号管理

    @Column(name = "function_name")
    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    @Column(name = "function_description")
    public String getFunctionDescription() {
        return functionDescription;
    }

    public void setFunctionDescription(String functionDescription) {
        this.functionDescription = functionDescription;
    }

    @Column(name = "function_level")
    public String getFunctionLevel() {
        return functionLevel;
    }

    public void setFunctionLevel(String functionLevel) {
        this.functionLevel = functionLevel;
    }

    @Column(name = "function_url")
    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    @Column(name = "function_type")
    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }
}

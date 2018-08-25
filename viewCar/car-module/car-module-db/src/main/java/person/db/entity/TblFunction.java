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

}

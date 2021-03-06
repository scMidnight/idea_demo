package person.db.bean;

import java.io.Serializable;

/**
 * Created by SunChang on 2018/8/22
 */
public class TblFunctionBean implements Serializable,Comparable<TblFunctionBean> {
    private String id;
    private String functionName;
    private String functionDescription;
    private String functionLevel;
    private String functionUrl;
    private String functionType;//1:线上广告管理，2:线下潜客筛选，3:车金融潜客挖掘，4:线索优化管理，5:账号管理

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionDescription() {
        return functionDescription;
    }

    public void setFunctionDescription(String functionDescription) {
        this.functionDescription = functionDescription;
    }

    public String getFunctionLevel() {
        return functionLevel;
    }

    public void setFunctionLevel(String functionLevel) {
        this.functionLevel = functionLevel;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    @Override
    public int compareTo(TblFunctionBean o) {
        int a = this.id.compareTo(o.id);
        if(a == 0) {
            return 0;//如果相同 则返回0
        }else if (a > 0) {
            return 1;//如果当前 的id 大于传入的id 则返回1
        }else {
            return -1;//如果当前的id小于传入的id则返回-1
        }
    }
}

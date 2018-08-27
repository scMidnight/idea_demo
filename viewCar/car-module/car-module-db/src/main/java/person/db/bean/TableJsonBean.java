package person.db.bean;

import jodd.util.StringUtil;

import java.util.List;

/**
 * Created by SunChang on 2018/8/27
 * 查询后返回的列表json格式的对应bean
 */
public class TableJsonBean {
    private String code;//数据状态，默认0
    private String msg;//返回信息
    private String count;//数据总数
    private List data;//数据内容

    public TableJsonBean(String code, String msg, String count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public String getCode() {
        if(StringUtil.isNotBlank(this.code)) {
            return code;
        }else {
            return "0";
        }
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        if(StringUtil.isNotBlank(this.msg)) {
            return msg;
        }else {
            return "";
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}

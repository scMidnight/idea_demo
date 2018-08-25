package person.util;

/**
 * Created by SunChang on 2018/8/22
 */
public class MessageBean {
    private String status;
    private String msg;
    private String info;

    public MessageBean() {
    }

    public String getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getInfo() {
        return this.info;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

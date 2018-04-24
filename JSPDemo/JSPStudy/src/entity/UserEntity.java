package entity;

import java.io.Serializable;

/**
 * Created by SunChang on 2018/4/24
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 4875513908785399148L;

    private String userName;
    private String passWord;

    public UserEntity() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

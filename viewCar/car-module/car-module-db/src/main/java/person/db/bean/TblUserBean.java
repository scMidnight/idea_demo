package person.db.bean;


import java.io.Serializable;
import java.util.TreeSet;

/**
 * Created by SunChang on 2018/8/22
 */
public class TblUserBean implements Serializable {
    private String id;
    private String userCode;
    private String password;
    private String email;
    private String userName;
    private TreeSet<TblRoleBean> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TreeSet<TblRoleBean> getRoles() {
        return roles;
    }

    public void setRoles(TreeSet<TblRoleBean> roles) {
        this.roles = roles;
    }
}

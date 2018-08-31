package person.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.TreeSet;

/**
 * Created by SunChang on 2018/8/22
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TBL_USER")
public class TblUser extends IdEntity {
    private String userCode;
    private String password;
    private String email;
    private String userName;
    private TreeSet<TblRole> roles;
    private String isBlack;//是否开启黑名单1是0否

    @Column(name = "usercode")
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Transient
    public TreeSet<TblRole> getRoles() {
        return roles;
    }

    public void setRoles(TreeSet<TblRole> roles) {
        this.roles = roles;
    }

    @Column(name = "username")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "IS_BLACK")
    public String getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(String isBlack) {
        this.isBlack = isBlack;
    }
}

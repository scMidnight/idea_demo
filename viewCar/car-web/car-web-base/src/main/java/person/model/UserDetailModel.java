package person.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import person.db.bean.TblRoleBean;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Created by SunChang on 2018/8/23
 */
@SuppressWarnings("serial")
public class UserDetailModel extends User implements UserDetails {

    public UserDetailModel(String username, String password, boolean enabled, boolean accountNonExpired,
                           boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        return this.getUsername().equals(((UserDetailModel)obj).getUsername());
    }

    private String id;
    private String userCode;
    private String password;
    private String email;
    private String userName;
    private TreeSet<TblRoleBean> roles;
    private String isBlack;
    private String isBrand;//是否开启品牌开关1是0否
    private String isTrade;//是否开启厂商开关1是0否
    private String isPhone;//是否开启号段检查1是0否

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

    @Override
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

    public String getIsBlack() {
        return isBlack;
    }

    public void setIsBlack(String isBlack) {
        this.isBlack = isBlack;
    }

    public String getIsBrand() {
        return isBrand;
    }

    public void setIsBrand(String isBrand) {
        this.isBrand = isBrand;
    }

    public String getIsTrade() {
        return isTrade;
    }

    public void setIsTrade(String isTrade) {
        this.isTrade = isTrade;
    }

    public String getIsPhone() {
        return isPhone;
    }

    public void setIsPhone(String isPhone) {
        this.isPhone = isPhone;
    }
}

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
}

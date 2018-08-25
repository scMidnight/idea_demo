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
@Table(name = "TBL_ROLE")
public class TblRole extends IdEntity {
    private String roleName;
    private String roleDescription;
    private TreeSet<TblFunction> functions;

    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "role_description")
    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Transient
    public TreeSet<TblFunction> getFunctions() {
        return functions;
    }

    public void setFunctions(TreeSet<TblFunction> functions) {
        this.functions = functions;
    }
}

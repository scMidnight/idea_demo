package person.db.bean;


import java.io.Serializable;
import java.util.TreeSet;

/**
 * Created by SunChang on 2018/8/22
 */
public class TblRoleBean implements Serializable,Comparable<TblRoleBean> {
    private String id;
    private String roleName;
    private String roleDescription;
    private TreeSet<TblFunctionBean> functions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public TreeSet<TblFunctionBean> getFunctions() {
        return functions;
    }

    public void setFunctions(TreeSet<TblFunctionBean> functions) {
        this.functions = functions;
    }

    @Override
    public int compareTo(TblRoleBean o) {
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

package person.db.bean;

public class AccountManageBean {
    private String id;
    private String userCode;
    private String pwd;
    private String email;
    private String phone;
    private String modulePermissions;
    private String operatePermissions;

    public AccountManageBean() {
    }

    public AccountManageBean(String id, String userCode, String pwd, String email, String phone, String modulePermissions, String operatePermissions) {
        this.id = id;
        this.userCode = userCode;
        this.pwd = pwd;
        this.email = email;
        this.phone = phone;
        this.modulePermissions = modulePermissions;
        this.operatePermissions = operatePermissions;
    }

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getModulePermissions() {
        return modulePermissions;
    }

    public void setModulePermissions(String modulePermissions) {
        this.modulePermissions = modulePermissions;
    }

    public String getOperatePermissions() {
        return operatePermissions;
    }

    public void setOperatePermissions(String operatePermissions) {
        this.operatePermissions = operatePermissions;
    }
}

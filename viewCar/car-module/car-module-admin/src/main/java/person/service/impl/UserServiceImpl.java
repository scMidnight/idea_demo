package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblUserBean;
import person.db.entity.TblUser;
import person.service.FunctionService;
import person.service.RoleService;
import person.service.UserService;

import java.util.List;

/**
 * Created by SunChang on 2018/8/22
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends CommonServiceImpl implements UserService {
    @Autowired
    RoleService roleService;

    @Override
    public TblUserBean loadByUsername(String userCode) {
        List<TblUser> users = super.findByProperty(TblUser.class, "userCode", userCode);
        TblUserBean userBean = new TblUserBean();
        if(users != null && users.size() > 0) {
            BeanUtils.copyProperties(users.get(0), userBean);
            userBean.setRoles(roleService.queryByUserId(userBean.getId()));
            return userBean;
        }else {
            return null;
        }
    }
}

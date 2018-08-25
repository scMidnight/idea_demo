package person.service;

import person.db.bean.TblRoleBean;

import java.util.TreeSet;

/**
 * Created by SunChang on 2018/8/22
 */
public interface RoleService extends CommonService {
    TreeSet<TblRoleBean> queryByUserId(String userId);
}

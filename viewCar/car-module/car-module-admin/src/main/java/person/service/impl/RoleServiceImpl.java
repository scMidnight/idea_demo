package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblRoleBean;
import person.db.entity.TblRole;
import person.service.FunctionService;
import person.service.RoleService;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by SunChang on 2018/8/22
 * @author SunChang
 */
@Service("roleService")
@Transactional
public class RoleServiceImpl extends CommonServiceImpl implements RoleService {

    @Autowired
    FunctionService functionService;

    @Override
    public TreeSet<TblRoleBean> queryByUserId(String userId) {
        TreeSet<TblRoleBean> roleBeans = new TreeSet<TblRoleBean>();
        List<Map<String, Object>> relations = this.findForJdbc("select * from tbl_userrole t where t.user_id = ?", userId);

        for (Map<String, Object> relation : relations) {
            TblRoleBean roleBean = new TblRoleBean();
            TblRole role =super.findUniqueByProperty(TblRole.class, "id", relation.get("role_id").toString());
            BeanUtils.copyProperties(role, roleBean);
            roleBean.setFunctions(functionService.queryByRoleId(relation.get("role_id").toString()));
            roleBeans.add(roleBean);
        }
        return roleBeans;
    }
}

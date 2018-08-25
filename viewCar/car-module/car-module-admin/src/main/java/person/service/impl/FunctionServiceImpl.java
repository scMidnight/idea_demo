package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblFunctionBean;
import person.db.bean.TblRoleBean;
import person.db.entity.TblFunction;
import person.db.entity.TblRole;
import person.service.FunctionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by SunChang on 2018/8/22
 */
@Service("functionService")
@Transactional
public class FunctionServiceImpl extends CommonServiceImpl implements FunctionService {
    @Override
    public List<TblFunctionBean> queryAll() {
        List<TblFunction> functions = this.loadAll(TblFunction.class);
        List<TblFunctionBean> functionBeans = new ArrayList<TblFunctionBean>();
        if(functions != null && functions.size() > 0) {
            for (TblFunction function : functions) {
                TblFunctionBean functionBean = new TblFunctionBean();
                BeanUtils.copyProperties(function, functionBean);
                functionBeans.add(functionBean);
            }
        }
        return functionBeans;
    }

    @Override
    public TreeSet<TblFunctionBean> queryByRoleId(String roleId) {
        TreeSet<TblFunctionBean> functionBeans = new TreeSet<TblFunctionBean>();
        List<Map<String, Object>> relations = this.findForJdbc("select * from tbl_rolefunction t where t.role_id = ?", roleId);
        for (Map<String, Object> relation : relations) {
            TblFunctionBean functionBean = new TblFunctionBean();
            TblFunction function =super.findUniqueByProperty(TblFunction.class, "id", relation.get("function_id").toString());
            BeanUtils.copyProperties(function, functionBean);
            functionBeans.add(functionBean);
        }
        return functionBeans;
    }
}

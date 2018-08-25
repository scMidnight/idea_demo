package person.service;

import person.db.bean.TblFunctionBean;

import java.util.List;
import java.util.TreeSet;

/**
 * Created by SunChang on 2018/8/22
 */
public interface FunctionService extends CommonService {
    /**
     * @Author SunChang
     * @Date 2018/2/13 4:32
     * @param
     * @Description 查询所有
     */
    List<TblFunctionBean> queryAll();

    TreeSet<TblFunctionBean> queryByRoleId(String roleId);
}

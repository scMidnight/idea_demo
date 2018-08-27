package person.handler;

import person.db.bean.TblCarSystemBean;
import person.db.entity.Page;

import java.util.Map;

/**
 * Created by SunChang on 2018/8/27
 */
public interface CarSystemHandler {
    /**
     * 分页查询工作日报表信息
     * @param page
     * @param values
     * @return
     */
    Page<TblCarSystemBean> queryByPageFilter(Page<TblCarSystemBean> page, String hql, Map<String, Object> values);
}

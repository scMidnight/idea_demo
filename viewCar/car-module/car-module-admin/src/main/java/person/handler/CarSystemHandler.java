package person.handler;

import person.db.bean.TblCarSystemBean;
import person.db.entity.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/27
 */
public interface CarSystemHandler {
    /**
     * 分页查询
     * @param page
     * @param values
     * @return
     */
    Page<TblCarSystemBean> queryByPageFilter(Page<TblCarSystemBean> page, String hql, Map<String, Object> values);

    /**
     * @Author SunChang
     * @Date 2018/8/28 17:14
     * @param id
     * @Description 逻辑删除信息
     */
    void removeCarSystemInfo(String id) throws Exception;

    /**
     * @Author SunChang
     * @Date 2018/8/28 19:39
     * @param carSystemBean
     * @Description 添加车系系统
     */
    void addCarSystemInfo(TblCarSystemBean carSystemBean) throws Exception;

    /**
     * @Author SunChang
     * @Date 2018/8/28 21:00
     * @param
     * @Description 查询所有信息
     */
    List<TblCarSystemBean> queryAll();
}

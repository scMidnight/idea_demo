package person.service;

import person.db.bean.TblCarSystemBean;

import java.util.List;

/**
 * Created by SunChang on 2018/8/27
 */
public interface CarSystemService extends CommonService {

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

    /**
     * @Author SunChang
     * @Date 2018/9/5 14:55
     * @param propertyName
    * @param value
     * @Description 根据字段名称查询结果
     */
    List<TblCarSystemBean> findByProperty(String propertyName, Object value);

    List<TblCarSystemBean> queryByHql(String hql, Object[] param);
}

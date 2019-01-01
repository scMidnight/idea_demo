package person.service;

import person.db.bean.TblIntentClientBean;

import java.util.List;
import java.util.Map;

public interface IntentClientService extends CommonService {
    /**
     * @Author SunChang
     * @Date 2018/11/29 16:35
     * @param intentClientBean
     * @Description 新增
     */
    void add(TblIntentClientBean intentClientBean);

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:35
     * @param intentClientBeans
     * @Description 批量新增
     */
    void batchAdd(List<TblIntentClientBean> intentClientBeans);

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:20
     * @param propertyName
    * @param value
     * @Description 根据字段名称查询结果集
     */
    List<TblIntentClientBean> findByProperty(String propertyName, Object value);

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:21
     * @param hql
    * @param param
     * @Description hql查询带参数
     */
    List<TblIntentClientBean> queryByHql(String hql, Object... param);

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:21
     * @param propertyName
    * @param value
     * @Description 根据查询结果物理删除数据
     */
    void deleteWhere(String propertyName, Object value);

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:22
     * @param
     * @Description 删除全表
     */
    void deleteAll();

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:22
     * @param sql
    * @param objs
     * @Description 通过sql查询结果，带参数
     */
    List<Map<String, Object>> findForJdbc(String sql, Object... objs);
}

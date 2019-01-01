package person.handler;

import person.db.bean.TblAdProManageBean;
import person.db.entity.Page;

import java.util.List;
import java.util.Map;

public interface AdProManHandler {
    /**
     * 分页查询
     * @param page
     * @param values
     * @return
     */
    Page<TblAdProManageBean> queryByPageFilter(Page<TblAdProManageBean> page, String hql, Map<String, Object> values) throws Exception;

    TblAdProManageBean queryById(String id) throws Exception;

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:35
     * @param adProManageBean
     * @Description 新增
     */
    void add(TblAdProManageBean adProManageBean) throws Exception;

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:35
     * @param adProManageBeans
     * @Description 批量新增
     */
    void batchAdd(List<TblAdProManageBean> adProManageBeans) throws Exception;

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:20
     * @param propertyName
    * @param value
     * @Description 根据字段名称查询结果集
     */
    List<TblAdProManageBean> findByProperty(String propertyName, Object value) throws Exception;

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:21
     * @param hql
    * @param param
     * @Description hql查询带参数
     */
    List<TblAdProManageBean> queryByHql(String hql, Object... param) throws Exception;

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:21
     * @param propertyName
    * @param value
     * @Description 根据查询结果物理删除数据
     */
    void deleteWhere(String propertyName, Object value) throws Exception;

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:22
     * @param
     * @Description 删除全表
     */
    void deleteAll() throws Exception;

    /**
     * @Author SunChang
     * @Date 2018/11/29 16:22
     * @param sql
    * @param objs
     * @Description 通过sql查询结果，带参数
     */
    List<Map<String, Object>> findForJdbc(String sql, Object... objs) throws Exception;

    void updateAdProMan(TblAdProManageBean adProManageBean) throws Exception;
}

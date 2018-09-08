package person.service;

import person.db.bean.TblFileDetailBean;

import java.util.List;

public interface FileDetailService extends CommonService {

    /**
     * @Author SunChang
     * @Date 2018/9/5 14:55
     * @param propertyName
    * @param value
     * @Description 根据字段名称查询结果
     */
    List<TblFileDetailBean> findByProperty(String propertyName, Object value);

    /**
     * @Author SunChang
     * @Date 2018/9/5 15:04
     * @param propertyName
    * @param value
     * @Description 通过字段名称查询到结果后进行指删除并删除对应的文件表，此方法有局限性，不建议大范围使用
     */
    void deleteAllAndFile(String propertyName, Object value);

    void batchSaveFileDetailBeansAndUpdateFileStatus(List<TblFileDetailBean> fileDetailBeans);

    List<TblFileDetailBean> queryByHql(String hql, Object... param);

    List<TblFileDetailBean> queryByHqlOnErrCount(String fileId, String status);

    /**
     * @Author SunChang
     * @Date 2018/9/8 14:08
     * @param fileDetailBeans
     * @Description 批量删除
     */
    void batchDel(List<TblFileDetailBean> fileDetailBeans);
}

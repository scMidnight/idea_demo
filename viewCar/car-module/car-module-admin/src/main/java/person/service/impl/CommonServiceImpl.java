package person.service.impl;

import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.dao.IBaseCommonDao;
import person.db.entity.Page;
import person.db.entity.PropertyFilter;
import person.service.CommonService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/22
 * @author SunChang
 */
@Service("commonService")
@Transactional
public class CommonServiceImpl implements CommonService {
    @Autowired
    protected IBaseCommonDao commonDao;
    @Override
    public <T> Serializable save(T entity) {
        return commonDao.save(entity);
    }

    @Override
    public <T> void saveOrUpdate(T entity) {
        commonDao.saveOrUpdate(entity);

    }

    /**
     * @param entitys
     * @author joed
     * 描述：
     * 批量保存或者更新实体
     */
    @Override
    public <T> void batchSaveOrUpdate(List<T> entitys) {
        commonDao.batchSaveOrUpdate(entitys);
    }

    /**
     * @param entitys
     * @author joed
     * 描述：
     * 批量更新指定实体
     */
    @Override
    public <T> void batchUpdateEntitie(List<T> entitys) {
        commonDao.batchUpdateEntitie(entitys);
    }

    @Override
    public <T> void delete(T entity) {
        commonDao.delete(entity);

    }

    @Override
    public <T> void deleteAllEntitie(Collection<T> entities) {
        commonDao.deleteAllEntitie(entities);
    }

    @Override
    public <T> T get(Class<T> class1, Serializable id) {
        return (T) commonDao.get(class1, id);
    }

    @Override
    public <T> T findUniqueByProperty(Class<T> entityClass,
                                      String propertyName, Object value) {
        return (T) commonDao.findUniqueByProperty(entityClass, propertyName,
                value);
    }

    @Override
    public <T> List<T> findByProperty(Class<T> entityClass,
                                      String propertyName, Object value) {

        return commonDao.findByProperty(entityClass, propertyName, value);
    }

    @Override
    public <T> List<T> loadAll(final Class<T> entityClass) {
        return commonDao.loadAll(entityClass);
    }

    @Override
    public <T> List<T> loadAllOrderBy(Class<T> entityClass, String orderByName,
                                      boolean isAsc) {
        return commonDao.loadAllOrderBy(entityClass, orderByName, isAsc);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T singleResult(String hql) {
        return (T) commonDao.singleResult(hql);
    }

    @Override
    public <T> void deleteEntityById(Class<T> entityName, Serializable id) {
        commonDao.deleteEntityById(entityName, id);
    }

    public <T> void updateEntitie(T pojo) {
        commonDao.updateEntitie(pojo);

    }

    public <T> List<T> findByQueryString(String hql) {
        return commonDao.findByQueryString(hql);
    }

    public int updateBySqlString(String sql) {
        return commonDao.updateBySqlString(sql);
    }

    public <T> List<T> findListbySql(String query) {
        return commonDao.findListbySql(query);
    }

    public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
                                             String propertyName, Object value, boolean isAsc) {
        return commonDao.findByPropertyisOrder(entityClass, propertyName,
                value, isAsc);
    }

    public Integer executeSql(String sql, List<String> param) {
        return commonDao.executeSql(sql, param.toArray());
    }

    public Integer executeSql(String sql, Object... param) {
        return commonDao.executeSql(sql, param);
    }

    public Integer executeSql(String sql, Map<String, Object> param) {
        return commonDao.executeSql(sql, param);
    }

    public List<Map<String, Object>> findForJdbc(String sql, int page, int rows) {
        return commonDao.findForJdbc(sql, page, rows);
    }

    public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
        return commonDao.findForJdbc(sql, objs);
    }

    public List<Map<String, Object>> findForJdbcParam(String sql, int page,
                                                      int rows, Object... objs) {
        return commonDao.findForJdbcParam(sql, page, rows, objs);
    }

    public <T> List<T> findObjForJdbc(String sql, int page, int rows,
                                      Class<T> clazz) {
        return commonDao.findObjForJdbc(sql, page, rows, clazz);
    }

    public Map<String, Object> findOneForJdbc(String sql, Object... objs) {
        Map<String, Object> mapResult = commonDao.findOneForJdbc(sql, objs);
        return mapResult;
    }

    public Long getCountForJdbc(String sql) {
        return commonDao.getCountForJdbc(sql);
    }

    public Long getCountForJdbcParam(String sql, Object[] objs) {
        return commonDao.getCountForJdbcParam(sql, objs);
    }

    public <T> void batchSave(List<T> entitys) {
        this.commonDao.batchSave(entitys);
    }

    public <T> List<T> findHql(String hql, Object... param) {
        return this.commonDao.findHql(hql, param);
    }

    @Override
    public <T> Page<T> find(Page<T> page, String hql, Object... values) {

        return this.commonDao.find(page, hql, values);
    }

    @Override
    public <T> Page<T> find(Page<T> page, String hql, Map<String, Object> values) {

        return this.commonDao.find(page, hql, values);
    }

    @Override
    public <T> Page<T> find(Page<T> page, Class<T> entityClass,
                            List<PropertyFilter> filters) {
        return this.commonDao.find(page, entityClass, filters);
    }

    @Override
    public <T> Page<T> find(Page<T> page, Class<T> entityClass,
                            Criterion... criterions) {

        return this.commonDao.find(page, entityClass, criterions);
    }

    @Override
    public <T> List<T> find(List<PropertyFilter> filters, Class<T> entityClass) {
        return this.commonDao.find(filters, entityClass);
    }

    @Override
    public <T> List<T> findByCriterion(Class<T> entityClass,
                                       Criterion... criterions) {
        return this.commonDao.findByCriterion(entityClass, criterions);
    }
}

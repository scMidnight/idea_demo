package person.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.exception.DataException;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import person.ReflectionUtils;
import person.StringUtils;
import person.dao.IBaseCommonDao;
import person.dao.JdbcDao;
import person.db.entity.Page;
import person.db.entity.PropertyFilter;
import person.utils.MyBeanUtils;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/22
 */
@SuppressWarnings("hiding")
@Repository("commonDao")
public class BaseHibernateCommonDao<T, PK extends Serializable> implements
        IBaseCommonDao {
    /**
     * 注入一个sessionFactory属性,并注入到父类(HibernateDaoSupport)
     * **/
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private HibernateTemplate hibernateTemplate;


    @Override
    public Session getSession() {
        // 事务必须是开启的(Required)，否则获取不到
        return sessionFactory.getCurrentSession();
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> T findUniqueByProperty(Class<T> entityClass,
                                      String propertyName, Object value) {
        Assert.hasText(propertyName);
        return (T) createCriteria(entityClass,
                Restrictions.eq(propertyName, value)).uniqueResult();
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> findByProperty(Class<T> entityClass,
                                      String propertyName, Object value) {
        Assert.hasText(propertyName);
        return (List<T>) createCriteria(entityClass,
                Restrictions.eq(propertyName, value)).list();
    }

    @Override
    public <T> Serializable save(T entity) {
        try {
            Serializable id = getSession().save(entity);
            getSession().flush();
            System.out.println("保存实体成功," + entity.getClass().getName());
            return id;
        } catch (RuntimeException e) {
            System.err.println("保存实体异常:" + e);
            throw e;
        }

    }


    @Override
    public <T> void batchSave(List<T> entitys) {
        for (int i = 0; i < entitys.size(); i++) {
            getSession().save(entitys.get(i));
            if (i % 20 == 0) {
                // 20个对象后才清理缓存，写入数据库
                getSession().flush();
                getSession().clear();
            }
        }
        // 最后清理一下----防止大于20小于40的不保存
        getSession().flush();
        getSession().clear();
    }


    @Override
    public <T> void saveOrUpdate(T entity) {
        try {
            getSession().saveOrUpdate(entity);
            getSession().flush();
            System.out.println("添加或更新成功," + entity.getClass().getName());
        } catch (RuntimeException e) {
            System.err.println("添加或更新异常:" + e);
            throw e;
        }
    }

    /**
     * @param entitys
     * @author joed
     * 描述：
     * 批量保存或者更新实体
     */
    @Override
    public <T> void batchSaveOrUpdate(List<T> entitys) {
        for (int i = 0; i < entitys.size(); i++) {
            getSession().saveOrUpdate(entitys.get(i));
            if (i % 20 == 0) {
                // 20个对象后才清理缓存，写入数据库
                getSession().flush();
                getSession().clear();
            }
        }
        // 最后清理一下----防止大于20小于40的不保存
        getSession().flush();
        getSession().clear();
    }

    /**
     * @param entitys
     * @author joed
     * 描述：
     * 批量更新指定实体
     */
    @Override
    public <T> void batchUpdateEntitie(List<T> entitys) {
        for (int i = 0; i < entitys.size(); i++) {
            getSession().update(entitys.get(i));
            if (i % 20 == 0) {
                // 20个对象后才清理缓存，写入数据库
                getSession().flush();
                getSession().clear();
            }
        }
        // 最后清理一下----防止大于20小于40的不保存
        getSession().flush();
        getSession().clear();
    }


    @Override
    public <T> void delete(T entity) {
        try {
            getSession().delete(entity);
            getSession().flush();
            System.out.println("删除成功," + entity.getClass().getName());
        } catch (RuntimeException e) {
            System.err.println("删除异常:" + e);
            throw e;
        }
    }


    @Override
    public <T> void deleteEntityById(Class<T> entityName, Serializable id) {
        delete(get(entityName, id));
        getSession().flush();
    }


    @Override
    public <T> void deleteAllEntitie(Collection<T> entitys) {
        for (Object entity : entitys) {
            getSession().delete(entity);
            getSession().flush();
        }
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> entityClass, final Serializable id) {
        T t = (T) getSession().get(entityClass, id);
        if (t != null) {
            getSession().flush();
        }
        return t;

    }


    @Override
    public <T> void updateEntitie(T pojo) {
        getSession().update(pojo);
        getSession().flush();
    }




    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> findByQueryString(final String query) {

        Query queryObject = getSession().createQuery(query);
        List<T> list = queryObject.list();
        if (list.size() > 0) {
            getSession().flush();
        }
        return list;

    }

    @Override
    @SuppressWarnings("unchecked")
    public  <T> T  singleResult(String hql) {
        T t = null;
        Query queryObject = getSession().createQuery(hql);
        List<T> list = queryObject.list();
        if (list.size() == 1) {
            getSession().flush();
            t = list.get(0);
        } else if (list.size() > 0) {
            throw new DataException("查询结果数:" + list.size() + "大于1", new SQLException());
        }
        return t;
    }




    @Override
    public int updateBySqlString(final String query) {

        Query querys = getSession().createSQLQuery(query);
        return querys.executeUpdate();
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> findListbySql(final String sql) {
        Query querys = getSession().createSQLQuery(sql);
        return querys.list();
    }


    private <T> Criteria createCriteria(Class<T> entityClass,
                                        Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(entityClass);
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        return criteria;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> loadAll(final Class<T> entityClass) {
        Criteria criteria = createCriteria(entityClass);

        return criteria.list();
    }
    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> loadAllOrderBy(final Class<T> entityClass,String orderByName,boolean isAsc) {
        Criteria criteria = createCriteria(entityClass);
        if(isAsc){
            criteria.addOrder(Order.asc(orderByName));
        }else{
            criteria.addOrder(Order.desc(orderByName));
        }

        return criteria.list();
    }

    private <T> Criteria createCriteria(Class<T> entityClass) {
        Criteria criteria = getSession().createCriteria(entityClass);
        return criteria;
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
                                             String propertyName, Object value, boolean isAsc) {
        Assert.hasText(propertyName);
        Criteria criteria = createCriteria(entityClass);
        if(isAsc){
            criteria.addOrder(Order.asc(propertyName));
        }else{
            criteria.addOrder(Order.desc(propertyName));
        }
        return criteria.list();
    }


    @SuppressWarnings("unchecked")
    public <T> T findUniqueBy(Class<T> entityClass, String propertyName,
                              Object value) {
        Assert.hasText(propertyName);
        return (T) createCriteria(entityClass,
                Restrictions.eq(propertyName, value)).uniqueResult();
    }


    public Query createQuery(Session session, String hql, Object... objects) {
        Query query = session.createQuery(hql);
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                query.setParameter(i, objects[i]);
            }
        }
        return query;
    }


    public <T> int batchInsertsEntitie(List<T> entityList) {
        int num = 0;
        for (int i = 0; i < entityList.size(); i++) {
            save(entityList.get(i));
            num++;
        }
        return num;
    }


    @SuppressWarnings("unchecked")
    public List<T> executeQuery(final String hql, final Object[] values) {
        Query query = getSession().createQuery(hql);
        // query.setCacheable(true);
        for (int i = 0; values != null && i < values.length; i++) {
            query.setParameter(i, values[i]);
        }

        return query.list();

    }


    public int getCount(Class<T> clazz) {

        int count = DataAccessUtils.intResult(getSession().createQuery(
                "select count(*) from " + clazz.getName()).list());
        return count;
    }




    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("namedParameterJdbcTemplate")
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Map<String, Object>> findForJdbc(String sql, int page, int rows) {
        // 封装分页SQL
        sql = JdbcDao.jeecgCreatePageSql(sql, page, rows);
        return this.jdbcTemplate.queryForList(sql);
    }



    @Override
    public <T> List<T> findObjForJdbc(String sql, int page, int rows,
                                      Class<T> clazz) {
        List<T> rsList = new ArrayList<T>();
        // 封装分页SQL
        sql = JdbcDao.jeecgCreatePageSql(sql, page, rows);
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

        T po = null;
        for (Map<String, Object> m : mapList) {
            try {
                po = clazz.newInstance();
                MyBeanUtils.copyMap2Bean_Nobig(po, m);
                rsList.add(po);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rsList;
    }


    @Override
    public List<Map<String, Object>> findForJdbcParam(String sql, int page,
                                                      int rows, Object... objs) {
        // 封装分页SQL
        sql = JdbcDao.jeecgCreatePageSql(sql, page, rows);
        return this.jdbcTemplate.queryForList(sql, objs);
    }


    @Override
    public Long getCountForJdbc(String sql) {
        return this.jdbcTemplate.queryForLong(sql);
    }


    @Override
    public Long getCountForJdbcParam(String sql, Object[] objs) {
        return this.jdbcTemplate.queryForLong(sql, objs);
    }

    @Override
    public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
        return this.jdbcTemplate.queryForList(sql, objs);
    }

    @Override
    public Integer executeSql(String sql, List<String> param) {

        return this.jdbcTemplate.update(sql, param.toArray());
    }

    @Override
    public Integer executeSql(String sql, Object... param) {
        return this.jdbcTemplate.update(sql, param);
    }

    @Override
    public Integer executeSql(String sql, Map<String, Object> param) {
        return this.namedParameterJdbcTemplate.update(sql, param);
    }


    public Integer countByJdbc(String sql, Object... param) {
        return this.jdbcTemplate.queryForInt(sql, param);
    }

    @Override
    public Map<String, Object> findOneForJdbc(String sql, Object... objs) {

        return this.jdbcTemplate.queryForMap(sql, objs);

    }


    @Override
    @SuppressWarnings({ "unchecked" })
    public <T> List<T> findHql(String hql, Object... param) {
        Query q = getSession().createQuery(hql);
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                q.setParameter(i, param[i]);
            }
        }
        return q.list();
    }


    @Override
    public Integer executeHql(String hql) {
        Query q = getSession().createQuery(hql);
        return q.executeUpdate();
    }


    @Override
    public HibernateTemplate getHibernateTemplate() {
        if (this.hibernateTemplate == null || sessionFactory != this.hibernateTemplate.getSessionFactory()) {
            this.hibernateTemplate = createHibernateTemplate(sessionFactory);
        }
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * Create a HibernateTemplate for the given SessionFactory.
     * Only invoked if populating the DAO with a SessionFactory reference!
     * <p>Can be overridden in subclasses to provide a HibernateTemplate instance
     * with different configuration, or a custom HibernateTemplate subclass.
     * @param sessionFactory the Hibernate SessionFactory to create a HibernateTemplate for
     * @return the new HibernateTemplate instance
     * @see #
     */
    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory) {
        return new HibernateTemplate(sessionFactory);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T findUnique(final String hql, final Object... values) {
        return (T) createQuery(hql, values).uniqueResult();
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T> T findUnique(final String hql, final Map<String, Object> values) {
        return (T) createQuery(hql, values).uniqueResult();
    }


    @Override
    public Query createQuery(final String queryString, final Map<String, Object> values) {
        Assert.hasText(queryString, "queryString不能为空");
        Query query = getSession().createQuery(queryString);
        if (values != null) {
            query.setProperties(values);
        }
        return query;
    }

    @Override
    public Query createQuery(final String queryString, final Object... values) {
        Assert.hasText(queryString, "queryString不能为空");
        Query query = getSession().createQuery(queryString);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                query.setParameter(i, values[i]);
            }
        }
        return query;
    }



    @Override
    public Long findLong(final String hql, final Object... values) {
        return (Long) findUnique(hql, values);
    }


    @Override
    public Long findLong(final String hql, final Map<String, Object> values) {
        return (Long) findUnique(hql, values);
    }

    /**
     * @param hql
     * @param values
     * @return
     * author:yjc
     * 时间：2017 2017-6-14 下午1:18:13
     * 描述:增加翻页查询总数
     */
    public Long findCountLong(final String hql, final Object... values) {
        return (Long) findUnique("select count(*) from (" + hql + ")", values);
    }

    public Long findCountLong(final String hql, final Map<String, Object> values) {
        return (Long) findUnique("select count(*) from (" + hql + ")", values);
    }


    @SuppressWarnings("unchecked")
    public <T> Page<T> find(final Page<T> page, final String hql, final Object... values) {
        Assert.notNull(page, "page不能为空");

        Query q = createQuery(hql, values);

        if (page.isAutoCount()) {
			/*long totalCount = findCountLong(hql, values);
			page.setTotalCount(totalCount);*/
            int totalCount = q.list().size();
            page.setTotalCount(Long.valueOf(String.valueOf(totalCount)));
        }

        setPageParameter(q, page);
        java.util.List<T> result = (java.util.List<T>) q.list();
        page.setResult(result);
        return page;
    }


    @SuppressWarnings("unchecked")
    public <T> Page<T> find(final Page<T> page, final String hql, final Map<String, Object> values) {
        Assert.notNull(page, "page不能为空");

        Query q = createQuery(hql, values);

        if (page.isAutoCount()) {
            //long totalCount = findCountLong(hql, values);
            int totalCount = q.list().size();
            page.setTotalCount(Long.valueOf(String.valueOf(totalCount)));
        }

        setPageParameter(q, page);

        java.util.List<T> result = (java.util.List<T>) q.list();
        page.setResult(result);
        return page;
    }


    public <T> Page<T> find(final Page<T> page, Class<T> entityClass,final java.util.List<PropertyFilter> filters) {
        Criterion[] criterions = buildPropertyFilterCriterions(filters);
        return find(page, entityClass,criterions);
    }

    @SuppressWarnings("unchecked")
    public <T> Page<T> find(final Page<T> page,Class<T> entityClass, final Criterion... criterions) {
        Assert.notNull(page, "page不能为空");

        Criteria c = createCriteria(entityClass,page.isOrderBySetted(),page.getOrderBy(),criterions);

        if (page.isAutoCount()) {
            long totalCount = countCriteriaResult(c);
            page.setTotalCount(totalCount);
        }

        setPageParameter(c, page);
        java.util.List<T> result = c.list();
        page.setResult(result);
        return page;
    }
    /**
     * 设置分页参数到Query对象,辅助函数.
     * @param q  Query
     * @param page 分页对象
     * @return org.hibernate.Query
     */
    @SuppressWarnings("rawtypes")
    private Query setPageParameter(final Query q, final Page page) {
        //hibernate的firstResult的序号从0开始
        q.setFirstResult(page.getFirst() - 1);
        q.setMaxResults(page.getPageSize());

        return q;
    }
    /**
     * 设置分页参数到Criteria对象,辅助函数.
     * @param c Criteria
     * @param page 分页对象
     * @return Criteria
     */
    @SuppressWarnings("rawtypes")
    private Criteria setPageParameter(final Criteria c, final Page page) {
        //hibernate的firstResult的序号从0开始
        c.setFirstResult(page.getFirst() - 1);
        c.setMaxResults(page.getPageSize());

        if (page.isOrderBySetted()) {
            String[] orderByArray = StringUtils.split(page.getOrderBy(), ",");
            String[] orderArray = StringUtils.split(page.getOrder(), ",");

            Assert.isTrue(orderByArray.length == orderArray.length, "分页多重排序参数中,排序字段与排序方向的个数不相等");

            for (int i = 0; i < orderByArray.length; i++) {
                if (Page.ASC.equals(orderArray[i])) {
                    c.addOrder(Order.asc(orderByArray[i]));
                } else {
                    c.addOrder(Order.desc(orderByArray[i]));
                }
            }
        }
        return c;
    }
    /**
     * 按属性过滤条件列表查找对象列表.
     */
    public <T> List<T> find(java.util.List<PropertyFilter> filters, Class<T> entityClass) {
        Criterion[] criterions = buildPropertyFilterCriterions(filters);
        return findByCriterion(entityClass,criterions);
    }

    /**
     * 按Criteria查询对象列表.
     *
     * @param criterions 数量可变的Criterion.
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> findByCriterion(Class<T> entityClass,final Criterion... criterions) {
        Criteria criteria =createCriteria(entityClass,false,null,criterions);
        return criteria.list();
    }





    /**
     * 根据Criterion条件创建Criteria.
     *
     * 本类封装的find()函数全部默认返回对象类型为T,当不为T时使用本函数.
     *
     * @param criterions 数量可变的Criterion.
     */
    @SuppressWarnings("rawtypes")
    private Criteria createCriteria(Class entityClass,boolean isOrderBySetted,String orderBy,final Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(entityClass);
        for (Criterion c : criterions) {
            criteria.add(c);
        }
        //criteria.addOrder(Order.desc("createTime"));
        //criteria.addOrder(Order.desc("lastModifyTime"));

		/*if (isOrderBySetted) {
			String[] orderByArray = StringUtils.split(orderBy, ",");
			String[] orderArray = StringUtils.split(orderBy, ",");

			Assert.isTrue(orderByArray.length == orderArray.length, "多重排序参数中,排序字段与排序方向的个数不相等");

			for (int i = 0; i < orderByArray.length; i++) {
				if (Page.ASC.equals(orderArray[i])) {
					criteria.addOrder(Order.asc(orderByArray[i]));
				} else {
					criteria.addOrder(Order.desc(orderByArray[i]));
				}
			}
		}*/

        return criteria;
    }


    /**
     * 执行count查询获得本次Criteria查询所能获得的对象总数.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private long countCriteriaResult(final Criteria c) {
        CriteriaImpl impl = (CriteriaImpl) c;

        // 先把Projection、ResultTransformer、OrderBy取出来,清空三者后再执行Count操作
        Projection projection = impl.getProjection();
        ResultTransformer transformer = impl.getResultTransformer();

        java.util.List<CriteriaImpl.OrderEntry> orderEntries = null;
        try {
            orderEntries = (java.util.List) ReflectionUtils.getFieldValue(impl, "orderEntries");
            ReflectionUtils.setFieldValue(impl, "orderEntries", new ArrayList());
        } catch (Exception e) {
            System.err.println("不可能抛出的异常:{}"+ e.getMessage());
        }

        // 执行Count查询
        long totalCount = (Long) c.setProjection(Projections.rowCount()).uniqueResult();

        // 将之前的Projection,ResultTransformer和OrderBy条件重新设回去
        c.setProjection(projection);

        if (projection == null) {
            c.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        }
        if (transformer != null) {
            c.setResultTransformer(transformer);
        }
        try {
            ReflectionUtils.setFieldValue(impl, "orderEntries", orderEntries);
        } catch (Exception e) {
            System.err.println("不可能抛出的异常:{}"+ e.getMessage());
        }

        return totalCount;
    }
    /**
     * 按属性条件列表创建Criterion数组,辅助函数.
     * @param filters 查询filter
     * @return Criterion[]
     */
    @SuppressWarnings("rawtypes")
    private Criterion[] buildPropertyFilterCriterions(final java.util.List<PropertyFilter> filters) {
        java.util.List<Criterion> criterionList = new ArrayList<Criterion>();
        for (PropertyFilter filter : filters) {
            String propertyName = filter.getPropertyName();

            boolean multiProperty = StringUtils.contains(propertyName, PropertyFilter.OR_SEPARATOR);
            if (!multiProperty) { //properNameName中只有一个属性的情况.
                Criterion	 criterion = null;
                if(null!=filter.getValue()&&null!=filter.getAfterValue()&&!"".equals(filter.getAfterValue())&&!"".equals(filter.getValue()))
                    criterion = buildPropertyFilterCriterion(propertyName, filter.getValue(), filter.getAfterValue(),filter.getMatchType());
                else
                    criterion = buildPropertyFilterCriterion(propertyName, filter.getValue(), filter.getMatchType());
                criterionList.add(criterion);

            } else {//properName中包含多个属性的情况,进行or处理.
                Disjunction disjunction = Restrictions.disjunction();
                String[] params = StringUtils.split(propertyName, PropertyFilter.OR_SEPARATOR);
                int i = 0;
                for (String param : params) {
                    Criterion criterion = null;
                    if(null!=filter.getValue()&&null!=filter.getAfterValue()&&!"".equals(filter.getAfterValue())&&!"".equals(filter.getValue()))
                        criterion = buildPropertyFilterCriterion(param, filter.getValue(), filter.getAfterValue(),filter.getMatchType());
                    else{
                        if(filter.getValue() instanceof List){
                            List valueList = (List) filter.getValue();
                            criterion = buildPropertyFilterCriterion(param, valueList.get(i), filter.getMatchType());
                            i++;
                        }else{
                            criterion = buildPropertyFilterCriterion(param, filter.getValue(), filter.getMatchType());
                        }

                    }

                    disjunction.add(criterion);
                }
                criterionList.add(disjunction);
            }
        }
        return criterionList.toArray(new Criterion[criterionList.size()]);
    }

    /**
     * 按属性条件参数创建Criterion,辅助函数.
     * @param propertyName 属性名称
     * @param value 属性值
     * @param matchType 匹配类型
     * @return Criterion
     */
    @SuppressWarnings("rawtypes")
    private Criterion buildPropertyFilterCriterion(final String propertyName, final Object value,
                                                   final PropertyFilter.MatchType matchType) {
        Assert.hasText(propertyName, "propertyName不能为空");
        Criterion criterion = null;

        if (PropertyFilter.MatchType.EQ.equals(matchType)) {
            criterion = Restrictions.eq(propertyName, value);
        }
        if(PropertyFilter.MatchType.NE.equals(matchType)){
            criterion = Restrictions.ne(propertyName, value);
        }
        if(PropertyFilter.MatchType.ISNULL.equals(matchType)){
            criterion = Restrictions.isNull(propertyName);
        }
        if(PropertyFilter.MatchType.ISNOTNULL.equals(matchType)){
            criterion = Restrictions.isNotNull(propertyName);
        }
        if (PropertyFilter.MatchType.LIKE.equals(matchType)) {
            criterion = Restrictions.like(propertyName, (String) value, MatchMode.ANYWHERE).ignoreCase();
        }
        if (PropertyFilter.MatchType.STARTLIKE.equals(matchType)) {
            criterion = Restrictions.like(propertyName, (String) value, MatchMode.START).ignoreCase();
        }
        if (PropertyFilter.MatchType.ENDLIKE.equals(matchType)) {
            criterion = Restrictions.like(propertyName, (String) value, MatchMode.END).ignoreCase();
        }
        if(PropertyFilter.MatchType.LESS_EQ_THAN.equals(matchType)){
            criterion = Restrictions.le(propertyName, value);
        }
        if(PropertyFilter.MatchType.LESS_THAN.equals(matchType)){
            criterion = Restrictions.lt(propertyName, value);
        }
        if(PropertyFilter.MatchType.GREATER_THAN.equals(matchType)){
            criterion = Restrictions.gt(propertyName, value);
        }
        if(PropertyFilter.MatchType.GREATER_EQ_THAN.equals(matchType)){
            criterion = Restrictions.ge(propertyName, value);
        }
        if(PropertyFilter.MatchType.IN.equals(matchType)){
            criterion = Restrictions.in(propertyName, (List)value);
        }if(PropertyFilter.MatchType.NOT_IN.equals(matchType)){
            Criterion expression = Restrictions.in(propertyName, (List)value);
            criterion = Restrictions.not(expression);
        }
        return criterion;
    }

    private Criterion buildPropertyFilterCriterion(final String propertyName, final Object value,final Object afterValue,
                                                   final PropertyFilter.MatchType matchType) {
        Assert.hasText(propertyName, "propertyName不能为空");
        Criterion criterion = null;
        criterion=Restrictions.between(propertyName, value, afterValue);
        return criterion;
    }
}

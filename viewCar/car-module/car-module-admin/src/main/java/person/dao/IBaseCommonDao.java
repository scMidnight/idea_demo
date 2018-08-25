package person.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.springframework.orm.hibernate3.HibernateTemplate;
import person.db.entity.Page;
import person.db.entity.PropertyFilter;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/22
 */
public interface IBaseCommonDao {
    /**
     * 保存实体
     * @param entity 实体类
     * @return 实体主键
     */
    public <T> Serializable save(T entity);

    /**
     * 批量保存实体
     * @param entitys 实体类
     */
    public <T> void batchSave(List<T> entitys);

    /**
     * 保存或更新实体
     * @param entity 实体类
     */
    public <T> void saveOrUpdate(T entity);
    /**
     * @author joed
     * 描述：
     * 批量保存或者更新实体
     */
    public <T> void batchSaveOrUpdate(List<T> entitys);
    /**
     * @author joed
     * 描述：
     *批量更新指定实体
     */
    public <T> void batchUpdateEntitie(List<T> entitys);
    /**
     * 删除实体类
     * @param entity
     */
    public <T> void delete(T entity);

    /**
     * 根据实体名称和主键获取实体
     *
     * @param entityName 实体类class
     * @param id 主键
     * @return 实体对象
     */
    public <T> T get(Class<T> entityName, Serializable id);

    /**
     * 根据实体名字获取唯一记录
     * @param entityClass 实体类class
     * @param propertyName 属性名
     * @param value 属性值
     * @return 实体结果
     */
    public <T> T findUniqueByProperty(Class<T> entityClass,
                                      String propertyName, Object value);

    /**
     * 按属性查找对象列表.
     * @param entityClass 实体类class
     * @param propertyName 属性名
     * @param value 属性值
     * @return List<T>列表
     */
    public <T> List<T> findByProperty(Class<T> entityClass,
                                      String propertyName, Object value);

    /**
     * 加载全部实体
     *
     * @param entityClass 实体类class
     * @return List<T>
     */
    public <T> List<T> loadAll(final Class<T> entityClass);

    /**
     * 加载全部排序
     * @param entityClass
     * @param orderByName 排序的名称
     * @param isAsc true：升序 false：降序
     * @return List<T>
     */
    public <T> List<T> loadAllOrderBy(Class<T> entityClass, String orderByName,
                                      boolean isAsc);



    /**
     * 通过主键删除实体
     * @param entityName 实体类class
     * @param id 主键
     */
    public <T> void deleteEntityById(Class<T> entityName, Serializable id);

    /**
     * 删除实体集合
     *
     * @param entities 实体集合
     */
    public <T> void deleteAllEntitie(Collection<T> entities);

    /**
     * 更新指定的实体
     * @param pojo 实体类
     */
    public <T> void updateEntitie(T pojo);



    /**
     * 通过hql 查询语句查找对象
     *
     * @param hql
     * @return List<T>
     */
    public <T> List<T> findByQueryString(final String hql);

    /**
     * 通过hql查询唯一对象
     *
     * @param hql
     * @return T
     */
    public <T> T singleResult(String hql);

    /**
     * 根据sql更新
     *
     * @param sql
     * @return int
     */
    public int updateBySqlString(String sql);

    /**
     * 根据sql查找List
     *
     * @param <T>
     * @param query
     * @return List<T>
     */
    public <T> List<T> findListbySql(String query);

    /**
     * 通过属性称获取实体带排序
     * @param entityClass 对象class
     * @param propertyName 属性名
     * @param value 属性值
     * @param isAsc true:升序  false:降序
     * @return List<T>
     */
    public <T> List<T> findByPropertyisOrder(Class<T> entityClass,
                                             String propertyName, Object value, boolean isAsc);






    public Session getSession();
    public HibernateTemplate getHibernateTemplate();






    /**
     * 执行sql
     * @param sql 参数以?格式
     * @param param list需要对应?的位置
     * @return 成功数量
     */
    public Integer executeSql(String sql, List<String> param);

    /**
     * 执行sql
     * @param sql 参数以?格式
     * @param param 需要对应?的位置
     * @return 成功数量
     */
    public Integer executeSql(String sql, Object... param);


    /**
     * 执行sql占位符
     * @param sql 使用:name
     * @param param
     * @return 成功数量
     */
    public Integer executeSql(String sql, Map<String, Object> param);


    /**
     * 通过JDBC查找对象集合
     * @param sql
     * @param objs 按顺序传入
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findForJdbc(String sql, Object... objs);

    /**
     * 通过JDBC查找唯一对象
     * @param sql
     * @param objs 按顺序传入
     * @return Map<String, Object>
     */
    public Map<String, Object> findOneForJdbc(String sql, Object... objs);

    /**
     * 通过JDBC查找Map集合,带分页
     * @param sql
     * @param page 页码
     * @param rows 行数
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> findForJdbc(String sql, int page, int rows);

    /**
     * 通过JDBC查找对象集合,带分页
     * @param sql 拼装好的sql
     * @param page 页码
     * @param rows 行数
     * @param clazz 对象类class
     * @return List<T>
     */
    public <T> List<T> findObjForJdbc(String sql, int page, int rows,
                                      Class<T> clazz);

    /**
     * 使用指定的检索标准检索数据并分页返回数据-采用预处理方式
     * @param sql
     * @param page 页码
     * @param rows 行数
     * @param objs 占位参数
     * @return  List<Map<String, Object>>
     */
    public List<Map<String, Object>> findForJdbcParam(String sql, int page,
                                                      int rows, Object... objs);

    /**
     * 使用sql查询记录数
     * @param sql
     * @return Long
     */
    public Long getCountForJdbc(String sql);

    /**
     * 使用指定的检索标准检索数据并分页返回数据For JDBC-采用预处理方式
     * @param sql
     * @param objs 占位参数值
     * @return Long
     */
    public Long getCountForJdbcParam(String sql, Object[] objs);

    /**
     * 通过hql 查询语句查找对象
     *
     * @param hql
     * @param param 占位参数值
     * @return List<T>
     */
    public <T> List<T> findHql(String hql, Object... param);

    /**
     * 执行HQL语句操作更新
     *
     * @param hql
     * @return 成功数量
     */
    public Integer executeHql(String hql);

    /**
     * 按HQL查询唯一对象.
     * @param hql
     *
     * @param values 数量可变的参数,按顺序绑定.
     * @return 唯一对象
     */
    public <T> T findUnique(final String hql, final Object... values);

    /**
     * 按HQL查询唯一对象.
     * @param hql
     * @param values 命名参数,按名称绑定.
     * @return 唯一对象
     */
    public <T> T findUnique(final String hql, final Map<String, Object> values);

    /**
     * 根据查询HQL与参数列表创建Query对象.
     * @param  queryString   HQL语句
     * @param values 命名参数,按名称绑定.
     * @return  org.hibernate.Query
     */
    public Query createQuery(final String queryString, final Map<String, Object> values) ;


    /**
     * 根据查询HQL与参数列表创建Query对象.
     *
     * @param queryString	 *
     * @param values 数量可变的参数,按顺序绑定.
     * @return  org.hibernate.Query
     */
    public Query createQuery(final String queryString, final Object... values) ;


    /**
     * 按HQL查询Long类型结果.
     * @param hql
     * @param values  数量可变的参数,按顺序绑定.
     * @return Long
     */
    public Long findLong(final String hql, final Object... values);

    /**
     * 按HQL查询Long类型结果.
     * @param hql
     * @param values map对象参数
     * @return Long
     */
    public Long findLong(final String hql, final Map<String, Object> values) ;




    /**
     * 按HQL分页查询.
     * @param <T>
     *
     * @param page 分页参数.不支持其中的orderBy参数.
     * @param hql hql语句.
     * @param values 数量可变的查询参数,按顺序绑定.
     *
     * @return 分页查询结果, 附带结果列表及所有查询时的参数.
     */
    public <T> Page<T> find(final Page<T> page, final String hql, final Object... values) ;

    /**
     * 按HQL分页查询.
     * @param <T>
     *
     * @param page 分页参数.(不支持orderBy参数)
     * @param hql hql语句.
     * @param values 命名参数,按名称绑定.
     *
     * @return 分页查询结果, 附带结果列表及所有查询时的参数.
     */
    public <T> Page<T> find(final Page<T> page, final String hql, final Map<String, Object> values) ;

    /**
     * 按属性过滤条件列表分页查找对象.
     * @param page 分页参数.(不支持orderBy参数)
     * @param entityClass 对象class
     * @param filters 查询条件filter
     * @return Page<T>
     */
    public <T> Page<T> find(final Page<T> page, Class<T> entityClass,final java.util.List<PropertyFilter> filters) ;

    /**
     * 按Criteria分页查询.
     * @param <T>
     *
     * @param page 分页参数.
     * @param entityClass  对象class
     * @param criterions 数量可变的Criterion.
     *
     * @return 分页查询结果.附带结果列表及所有查询时的参数.
     */
    public <T> Page<T> find(final Page<T> page,Class<T> entityClass, final Criterion... criterions) ;

    /**
     * 按属性过滤条件列表查找对象列表.
     * @param filters 查询条件filter
     * @param entityClass 对象class
     * @return List<T>
     */
    public <T> List<T> find(java.util.List<PropertyFilter> filters, Class<T> entityClass) ;

    /**
     * 按Criteria查询对象列表.
     * @param entityClass 对象class
     *
     * @param criterions 数量可变的Criterion.
     * @return List<T>
     */
    public <T> List<T> findByCriterion(Class<T> entityClass,final Criterion... criterions) ;
}

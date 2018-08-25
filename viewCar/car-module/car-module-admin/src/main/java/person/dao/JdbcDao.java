package person.dao;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import person.utils.MyBeanUtils;

import javax.sql.DataSource;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/22
 */
@Repository("jdbcDao")
public class JdbcDao extends SimpleJdbcTemplate {

    /**
     * 数据库类型：MYSQL
     */
    public static final String DATABSE_TYPE_MYSQL ="mysql";
    /**
     * 数据库类型：POSTGRESQL
     */
    public static final String DATABSE_TYPE_POSTGRE ="postgresql";
    /**
     * 数据库类型：ORACLE
     */
    public static final String DATABSE_TYPE_ORACLE ="oracle";
    /**
     * 数据库类型：SQLSERVER
     */
    public static final String DATABSE_TYPE_SQLSERVER ="sqlserver";
    /**
     * MYSQL分页SQL
     */
    public static final String MYSQL_SQL = "select * from ( {0}) sel_tab00 limit {1},{2}";
    /**
     * POSTGRESQL分页SQL
     */
    public static final String POSTGRE_SQL = "select * from ( {0}) sel_tab00 limit {2} offset {1}";
    /**
     * ORACLE分页SQL
     */
    public static final String ORACLE_SQL = "select * from (select row_.*,rownum rownum_ from ({0}) row_ where rownum <= {1}) where rownum_>{2}";
    /**
     * SQLSERVER分页SQL
     */
    public static final String SQLSERVER_SQL = "select * from ( select row_number() over(order by tempColumn) tempRowNumber, * from (select top {1} tempColumn = 0, {0}) t ) tt where tempRowNumber > {2}"; //sqlserver

    /**
     *传入数据源构造JdbcDao实例（AutoWired）
     * @param dataSource 数据源
     */
    @Autowired
    public JdbcDao(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * 根据sql语句，返回对象集合
     * @param sql 语句(参数用冒号加参数名，例如select * from tb where id=:id)
     * @param clazz 类型
     * @param parameters 参数集合(key为参数名，value为参数值)
     * @return bean对象集合
     */
    public List find(String sql,Class clazz,Map parameters){
        return super.find(sql,clazz,parameters);
    }

    /**
     * 根据sql语句，返回对象
     * @param sql 语句(参数用冒号加参数名，例如select * from tb where id=:id)
     * @param clazz 类型
     * @param parameters 参数集合(key为参数名，value为参数值)
     * @return bean对象
     */
    public Object findForObject(String sql,Class clazz,Map parameters){
        return super.findForObject(sql, clazz, parameters);
    }

    /**
     * 根据sql语句，返回数值型返回结果
     * @param sql 语句(参数用冒号加参数名，例如select count(*) from tb where id=:id)
     * @param parameters 参数集合(key为参数名，value为参数值)
     * @return bean对象
     */
    public long findForLong(String sql,Map parameters){
        return super.findForLong(sql, parameters);
    }

    /**
     * 根据sql语句，返回Map对象,对于某些项目来说，没有准备Bean对象，则可以使用Map代替Key为字段名,value为值
     * @param sql 语句(参数用冒号加参数名，例如select count(*) from tb where id=:id)
     * @param parameters 参数集合(key为参数名，value为参数值)
     * @return bean对象
     */
    public Map findForMap(String sql,Map parameters){
        return super.findForMap(sql, parameters);
    }

    /**
     * 根据sql语句，返回Map对象集合
     * @see this.findForMap
     * @param sql 语句(参数用冒号加参数名，例如select count(*) from tb where id=:id)
     * @param parameters 参数集合(key为参数名，value为参数值)
     * @return bean对象
     */
    public List<Map<String,Object>> findForListMap(String sql,Map parameters){
        return super.findForListMap(sql, parameters);
    }

    /**
     * 执行insert，update，delete等操作<br>
     * 例如insert into users (name,login_name,password) values(:name,:loginName,:password)<br>
     * 参数用冒号,参数为bean的属性名
     * @param sql
     * @param bean 实体对象
     */
    public int executeForObject(String sql,Object bean){
        return super.executeForObject(sql, bean);
    }

    /**
     * 执行insert，update，delete等操作<br>
     * 例如insert into users (name,login_name,password) values(:name,:login_name,:password)<br>
     * 参数用冒号,参数为Map的key名
     * @param sql
     * @param parameters
     */
    public int executeForMap(String sql,Map parameters){
        return super.executeForMap(sql, parameters);
    }
    /*
     * 批量处理操作
     * 例如：update t_actor set first_name = :firstName, last_name = :lastName where id = :id
     * 参数用冒号
     */
    public int[] batchUpdate(final String sql,List<Object[]> batch ){
        return super.batchUpdate(sql,batch);
    }

    /**
     * 使用指定的检索标准检索数据并分页返回数据
     */
    public List<Map<String, Object>> findForJdbc(String sql, int page, int rows) {
        //封装分页SQL
        sql = jeecgCreatePageSql(sql,page,rows);
        return this.jdbcTemplate.queryForList(sql);
    }


    public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
        return this.jdbcTemplate.queryForList(sql,objs);
    }


    /**
     * 使用指定的检索标准检索数据并分页返回数据
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public List<T> findObjForJdbc(String sql, int page, int rows,Class<T> clazz) {
        List<T> rsList = new ArrayList<T>();
        //封装分页SQL
        sql = jeecgCreatePageSql(sql,page,rows);
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);

        T po = null;
        for(Map<String,Object> m:mapList){
            try {
                po = clazz.newInstance();
                MyBeanUtils.copyMap2Bean_Nobig(po, m);
                rsList.add(po);
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rsList;
    }

    /**
     * 使用指定的检索标准检索数据并分页返回数据-采用预处理方式
     *
     * @param sql 查询SQL 在本方法中封装成带分页SQL
     * @param page 页码
     * @param rows 每页显示数量
     * @param objs  SQL参数
     * @return  List<Map<String, Object>>
     * @throws
     */
    public  List<Map<String, Object>>  findForJdbcParam(String  sql,  int page, int rows,Object... objs){
        //封装分页SQL
        sql = jeecgCreatePageSql(sql,page,rows);
        return jdbcTemplate.queryForList(sql,objs);
    }

    /**
     * 按照数据库类型，封装SQL
     * @param sql 待封装SQL
     * @param page 页码
     * @param rows 每页显示条数
     * @return String 封装后SQL
     */
    public static String jeecgCreatePageSql(String sql, int page, int rows){
        String databseType = DATABSE_TYPE_ORACLE;

        int beginNum = (page - 1) * rows;
        String[] sqlParam = new String[3];
        sqlParam[0] = sql;
        sqlParam[1] = beginNum+"";
        sqlParam[2] = rows+"";
        if(databseType.indexOf(DATABSE_TYPE_MYSQL)!=-1){
            sql = MessageFormat.format(MYSQL_SQL, sqlParam);
        }else if(databseType.indexOf(DATABSE_TYPE_POSTGRE)!=-1){
            sql = MessageFormat.format(POSTGRE_SQL, sqlParam);
        }else {
            int beginIndex = (page-1)*rows;
            int endIndex = beginIndex+rows;
            sqlParam[2] = Integer.toString(beginIndex);
            sqlParam[1] = Integer.toString(endIndex);
            if(databseType.indexOf(DATABSE_TYPE_ORACLE)!=-1) {
                sql = MessageFormat.format(ORACLE_SQL, sqlParam);
            } else if(databseType.indexOf(DATABSE_TYPE_SQLSERVER)!=-1) {
                sqlParam[0] = sql.substring(getAfterSelectInsertPoint(sql));
                sql = MessageFormat.format(SQLSERVER_SQL, sqlParam);
            }
        }
        return sql;
    }

    /**
     *适用于单行数据返回
     * @param sql 查询SQL
     * @param objs 查询参数
     * @return Map<String, Object> key Value 形式的行数据
     */
    public Map<String, Object> findOneForJdbc(String sql, Object... objs) {
        try{
            return this.jdbcTemplate.queryForMap(sql, objs);
        }catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * 执行查询并返回long类型结果集，不能用预编译语句，只能用静态SQL，需要预编译语句请用getCountForJdbcParam
     * @param sql 待执行SQL
     * @return long类型，当SQL为null 返回0
     * 当返回不是单行单列抛出IncorrectResultSizeDataAccessException异常
     */
    public Long getCountForJdbc(String  sql) {
        return  jdbcTemplate.queryForLong(sql);
    }
    /**
     * 执行查询并返回long类型结果集，能用预编译语句
     * @param sql 待执行SQL
     * @param objs  参数
     * @return long类型，当SQL为null 返回0
     * 当返回不是单行单列抛出IncorrectResultSizeDataAccessException异常
     */
    public Long getCountForJdbcParam(String  sql,Object... objs) {
        return  jdbcTemplate.queryForLong(sql, objs);
    }

    /**
     * 执行带参数的更新语句
     * @param sql
     * @param param List盛放
     * @return Integer 生效行数
     */
    public Integer executeSql2(String sql,List<Object> param) {
        return this.jdbcTemplate.update(sql,param);
    }

    /**
     *
     * @param sql
     * @param param 动态参数
     * @return Integer 生效行数
     */
    public Integer executeSql(String sql, Object... param) {
        return this.jdbcTemplate.update(sql,param);
    }

    @SuppressWarnings("deprecation")
    public Integer countByJdbc(String sql, Object... param) {
        return this.jdbcTemplate.queryForInt(sql, param);
    }

    /**
     * 此方法供SQLSERVER组装分页语句时使用参加this.jeecgCreatePageSql(String,int int)
     * @param sql SQLSERVER查询SQL
     * @return selectIndex
     */
    private static int getAfterSelectInsertPoint(String sql) {
        int selectIndex = sql.toLowerCase().indexOf("select");
        int selectDistinctIndex = sql.toLowerCase().indexOf("select distinct");
        return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
    }
}

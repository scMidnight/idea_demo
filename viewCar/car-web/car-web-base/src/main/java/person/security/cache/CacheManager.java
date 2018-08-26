package person.security.cache;

import person.ApplicationContextUtils;
import person.db.bean.TblFunctionBean;
import person.handler.FunctionHandler;

import java.util.List;

/**
 * *************************************************************************
 * <pre>
 * 文件名称:  CacheManager.java
 * 包   路   径：  com.mofcom.fmpt.admin.cache
 * 版权所有:  中国国际电子商务中心  (C) 2016
 * </pre>
 * <pre>
 * 类描述:缓存管理
 * Revision : $Revision: 1.1 $
 * 创建人： xhj
 * 创建时间：2016-11-28 上午11:19:28
 * 修改人：xhj
 * 修改时间：2016-11-28 上午11:19:28
 * </pre>
 * <p>
 * <pre>
 *  1. 修改记录：
 *    -----------------------------------------------------------------------------------------------
 *              时间                      |       修改人            |         修改的方法                       |         修改描述
 *    -----------------------------------------------------------------------------------------------
 *                  		|                 |                           |
 *    -----------------------------------------------------------------------------------------------
 * </pre>
 * *************************************************************************
 */
public class CacheManager {

    private static CacheManager cache = null;

    /**
     * 获取CacheManager实例
     * @return CacheManager
     */
    public static CacheManager getInstance() {
        if (null == cache) {
            cache = new CacheManager();
        }
        return cache;
    }

    /**
     * 私有化构造函数（单例模式）
     */
    private CacheManager() {
    }

    /**
     * 该方法为消费者端启动加载
     */
    @SuppressWarnings("unchecked")
    public void initComSumer() {
        /**数据库模式加载缓存*/
        //加载部门与用户视图
        FunctionHandler functionHandler = (FunctionHandler) ApplicationContextUtils.getInstance().getBean("functionHandler");
        List<TblFunctionBean> entityList = functionHandler.queryAll();
        TblFunctionCache.getInstance().init(entityList);
    }

    /**
     * 方法说明:消费者端更新缓存
     * xiahongjian
     * 2016-12-30下午2:01:25
     */
    public void refreshComSumer(String flag) {
        TblFunctionCache.getInstance().clear();
        initComSumer();
    }

    //一级菜单
    public List<TblFunctionBean> getOneList() {
        return TblFunctionCache.getInstance().getOneList();
    }

    //所有功能
    public List<TblFunctionBean> getFunctionAll() {
        return TblFunctionCache.getInstance().getAll();
    }

    //获取子级
    public List<TblFunctionBean> getChildList(String code) {
        return TblFunctionCache.getInstance().getChildList(code);
    }

}
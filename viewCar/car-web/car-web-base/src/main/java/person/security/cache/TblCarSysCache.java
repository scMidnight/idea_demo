package person.security.cache;

import person.db.bean.TblCarSystemBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/9/6
 */
public class TblCarSysCache {
    private static Map<String, String> cacheMap = new HashMap<String, String>();
    private static Map<String, TblCarSystemBean> cacheMapBean = new HashMap<String, TblCarSystemBean>();
    private static List<TblCarSystemBean> cacheList = new ArrayList<TblCarSystemBean>();
    private static Map<String, TblCarSystemBean> cacheMapBeanName = new HashMap<String, TblCarSystemBean>();
    private static Map<String, TblCarSystemBean> cacheMapBeanNameBrandId = new HashMap<String, TblCarSystemBean>();
    private static Map<String, TblCarSystemBean> cacheMapBeanNameBrandName = new HashMap<String, TblCarSystemBean>();
    private static Map<String, TblCarSystemBean> cacheMapBeanNameTradeId = new HashMap<String, TblCarSystemBean>();
    private static Map<String, TblCarSystemBean> cacheMapBeanNameTradeName = new HashMap<String, TblCarSystemBean>();
    private static TblCarSysCache cache = null;

    public static TblCarSysCache getInstance() {
        if(null == cache) {
            cache = new TblCarSysCache();
        }
        return cache;
    }

    public TblCarSysCache() {
    }

    public void init(List<TblCarSystemBean> list) {
        if(null != list && !list.isEmpty()) {
            for (TblCarSystemBean carSystemBean : list) {
                cacheMap.put(carSystemBean.getCarSysId(), carSystemBean.getCarSysName());
                cacheMapBean.put(carSystemBean.getCarSysId(), carSystemBean);
                cacheMapBeanName.put(carSystemBean.getCarSysName(), carSystemBean);
                cacheMapBeanNameBrandId.put(carSystemBean.getBrandId(), carSystemBean);
                cacheMapBeanNameBrandName.put(carSystemBean.getBrandName(), carSystemBean);
                cacheMapBeanNameTradeId.put(carSystemBean.getTradeId(), carSystemBean);
                cacheMapBeanNameTradeName.put(carSystemBean.getTradeName(), carSystemBean);
                cacheList.add(carSystemBean);
            }
        }
    }

    /**
     * 清空缓存
     */
    public void clear(){
        cacheList.clear();
        cacheMap.clear();
        cacheMapBean.clear();
        cacheMapBeanName.clear();
        cacheMapBeanNameBrandId.clear();
        cacheMapBeanNameBrandName.clear();
        cacheMapBeanNameTradeId.clear();
        cacheMapBeanNameTradeName.clear();
    }

    /**
     * 刷新缓存
     * @param  entityList
     */
    public void refresh(List<TblCarSystemBean> entityList){
        clear();
        init(entityList);
    }

    /**
     * 获取所有码表数据
     * @return List<TblCarSystemBean>
     */
    public List<TblCarSystemBean> getAll(){
        return cacheList;
    }

    public Map<String, String> getMapAll() {
        return cacheMap;
    }

    public Map<String, TblCarSystemBean> getMapBean() {
        return cacheMapBean;
    }
    public Map<String, TblCarSystemBean> getMapBeanName() {
        return cacheMapBeanName;
    }
    public Map<String, TblCarSystemBean> getMapBeanNameBrandId() {
        return cacheMapBeanNameBrandId;
    }
    public Map<String, TblCarSystemBean> getMapBeanNameBrandName() {
        return cacheMapBeanNameBrandName;
    }
    public Map<String, TblCarSystemBean> getMapBeanNameTradeId() {
        return cacheMapBeanNameTradeId;
    }
    public Map<String, TblCarSystemBean> getMapBeanNameTradeName() {
        return cacheMapBeanNameTradeName;
    }
}

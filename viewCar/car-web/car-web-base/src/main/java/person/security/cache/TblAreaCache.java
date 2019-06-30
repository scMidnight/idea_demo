package person.security.cache;

import person.db.bean.TblAreaBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/9/6
 */
public class TblAreaCache {
    private static Map<String, String> cacheMap = new HashMap<String, String>();
    private static Map<String, List<TblAreaBean>> cacheMapProv = new HashMap<String, List<TblAreaBean>>();
    private static Map<String, TblAreaBean> cacheMapCityName = new HashMap<String, TblAreaBean>();
    private static List<TblAreaBean> cacheList = new ArrayList<TblAreaBean>();
    private static TblAreaCache cache = null;

    public static TblAreaCache getInstance() {
        if(null == cache) {
            cache = new TblAreaCache();
        }
        return cache;
    }

    public TblAreaCache() {

    }

    public void init(List<TblAreaBean> list) {
        if(null != list && !list.isEmpty()) {
            List<String> provList = new ArrayList<>();
            for (TblAreaBean areaBean : list) {
                cacheMap.put(areaBean.getAreaCode(), areaBean.getCityName());
                cacheList.add(areaBean);
                cacheMapCityName.put(areaBean.getCityName(), areaBean);
                if(!provList.contains(areaBean.getProvName())) {
                    provList.add(areaBean.getProvName());
                }
            }
            for (String s : provList) {
                List<TblAreaBean> list1 = new ArrayList<>();
                for (TblAreaBean tblAreaBean : list) {
                    if(tblAreaBean.getProvName().equals(s)) {
                        list1.add(tblAreaBean);
                    }
                }
                cacheMapProv.put(s, list1);
            }
        }
    }
    /**
     * 清空缓存
     */
    public void clear(){
        cacheList.clear();
        cacheMap.clear();
        cacheMapProv.clear();
        cacheMapCityName.clear();
    }

    /**
     * 刷新缓存
     * @param  entityList
     */
    public void refresh(List<TblAreaBean> entityList){
        clear();
        init(entityList);
    }

    /**
     * 获取所有码表数据
     * @return List<TblAreaBean>
     */
    public List<TblAreaBean> getAll(){
        return cacheList;
    }

    public Map<String, String> getMapAll() {
        return cacheMap;
    }

    public Map<String, List<TblAreaBean>> getMapProv() {
        return cacheMapProv;
    }
    public Map<String, TblAreaBean> getMapCityName() {
        return cacheMapCityName;
    }
}
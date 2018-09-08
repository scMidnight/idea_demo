package person.security.cache;

import person.db.bean.TblAreaBean;
import person.db.bean.TblFunctionBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/9/6
 */
public class TblAreaCache {
    private static Map<String, String> cacheMap = new HashMap<String, String>();
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
            for (TblAreaBean areaBean : list) {
                cacheMap.put(areaBean.getAreaCode(), areaBean.getCityName());
                cacheList.add(areaBean);
            }
        }
    }
    /**
     * 清空缓存
     */
    public void clear(){
        cacheList.clear();
        cacheMap.clear();
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
}
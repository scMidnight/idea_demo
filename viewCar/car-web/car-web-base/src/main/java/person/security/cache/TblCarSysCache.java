package person.security.cache;

import person.db.bean.TblCarSystemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunChang on 2018/9/6
 */
public class TblCarSysCache {
    private static List<TblCarSystemBean> cacheList = new ArrayList<TblCarSystemBean>();
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
                cacheList.add(carSystemBean);
            }
        }
    }

    /**
     * 清空缓存
     */
    public void clear(){
        cacheList.clear();
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
}

package person.security.cache;

import person.db.bean.TblFunctionBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/22
 */
public class TblFunctionCache {
    private static Map<String, List<TblFunctionBean>> cacheObjectListMap= new java.util.HashMap<String, List<TblFunctionBean>>();

    private static Map<String, TblFunctionBean> cacheObjectMap	= new java.util.HashMap<String, TblFunctionBean>();

    private static List<TblFunctionBean> cacheList = new ArrayList<TblFunctionBean>();

    private static List<TblFunctionBean> cacheOneList = new ArrayList<TblFunctionBean>();

    private static TblFunctionCache cache = null;

    /**
     * 获取 RbacFunctionCache 实例
     * @return RbacFunctionCache 功能缓存
     */
    public static TblFunctionCache getInstance() {
        if (null == cache) {
            cache = new TblFunctionCache();
        }
        return cache;
    }

    private TblFunctionCache() {

    }

    public void init(List<TblFunctionBean> entityList) {
        if(entityList!=null&&entityList.size()>0){
            for(TblFunctionBean entity : entityList){
                if(entity.getFunctionLevel().equals("1")){
                    cacheOneList.add(entity);
                }
                cacheList.add(entity);
                cacheObjectMap.put(entity.getId(), entity);
            }
            for(TblFunctionBean entity :cacheList){
                getChildList(entity.getId());
            }

        }
    }

    /**
     * 清空缓存
     */
    public void clear(){
        cacheObjectListMap.clear();
        cacheList.clear();
        cacheOneList.clear();
        cacheObjectMap.clear();
    }

    /**
     * 刷新缓存
     * @param  entityList
     */
    public void refresh(List<TblFunctionBean> entityList){
        clear();
        init(entityList);
    }

    /**
     * 获取所有功能
     * @return List<TblFunctionBean>
     */
    public List<TblFunctionBean> getAll(){
        return cacheList;
    }

    /**
     * 获取一级菜单
     * @return List<TblFunctionBean>
     */
    public List<TblFunctionBean> getOneList(){
        return cacheOneList;
    }

    /**
     * 获取子列表
     * @param code 服列表
     * @return List<TblFunctionBean>
     */
    public List<TblFunctionBean> getChildList(String code){
        List<TblFunctionBean> childList = cacheObjectListMap.get(code);
        TblFunctionBean currenctObj = cacheObjectMap.get(code);
        if(childList==null&&currenctObj!=null){
            //重新装载子列表
            childList = new ArrayList<TblFunctionBean>();
            String parentCode = currenctObj.getId();
            for(TblFunctionBean entity:cacheList){
                if(entity.getId().length()>parentCode.length()){
                    String childSubStr = entity.getId().substring(0, entity.getId().length()-3);
                    if(childSubStr.equals(parentCode)){
                        childList.add(entity);
                    }
                }
            }
            if(childList.size()>0){
                cacheObjectListMap.put(code, childList);
            }
        }
        return childList;
    }
}

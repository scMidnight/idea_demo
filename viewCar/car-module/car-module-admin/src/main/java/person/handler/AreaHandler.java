package person.handler;

import person.db.bean.TblAreaBean;

import java.util.List;

/**
 * Created by SunChang on 2018/9/6
 */
public interface AreaHandler {
    /**
     * @Author SunChang
     * @Date 2018/9/6 19:22
     * @param
     * @Description 查询地区码表中所有数据
     */
    List<TblAreaBean> queryAll();
}

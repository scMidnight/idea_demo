package person.handler;

import person.db.bean.TblFunctionBean;

import java.util.List;

/**
 * Created by SunChang on 2018/8/22
 */
public interface FunctionHandler {
    /**
     * @Author SunChang
     * @Date 2018/2/13 4:32
     * @param
     * @Description 查询所有
     */
    List<TblFunctionBean> queryAll();
}

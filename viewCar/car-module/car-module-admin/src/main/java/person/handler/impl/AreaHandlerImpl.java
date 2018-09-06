package person.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblAreaBean;
import person.handler.AreaHandler;
import person.service.AreaService;

import java.util.List;

/**
 * Created by SunChang on 2018/9/6
 */
@Service("areaHandler")
public class AreaHandlerImpl implements AreaHandler {

    @Autowired
    AreaService areaService;

    @Override
    public List<TblAreaBean> queryAll() {
        return areaService.queryAll();
    }
}

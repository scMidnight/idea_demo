package person.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblFunctionBean;
import person.handler.FunctionHandler;
import person.service.FunctionService;

import java.util.List;

/**
 * Created by SunChang on 2018/8/22
 */
@Service("functionHandler")
public class FunctionHandlerImpl implements FunctionHandler {
    @Autowired
    FunctionService functionService;
    @Override
    public List<TblFunctionBean> queryAll() {
        return functionService.queryAll();
    }
}

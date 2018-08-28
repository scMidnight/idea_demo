package person.handler.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblCarSystemBean;
import person.db.entity.Page;
import person.db.entity.TblCarSystem;
import person.handler.CarSystemHandler;
import person.service.CarSystemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/8/27
 */
@Service("carSystemHandler")
public class CarSystemHandlerImpl implements CarSystemHandler {
    @Autowired
    CarSystemService carSystemService;

    @Override
    public Page<TblCarSystemBean> queryByPageFilter(Page<TblCarSystemBean> page, String hql, Map<String, Object> values) {
        Page<TblCarSystem> pageDb = new Page<TblCarSystem>();
        pageDb.setAutoCount(page.isAutoCount());
        pageDb.setOrder(page.getOrder());
        pageDb.setOrderBy(page.getOrderBy());
        pageDb.setPageNo(page.getPageNo());
        pageDb.setPageSize(page.getPageSize());
        pageDb = carSystemService.find(pageDb, hql, values);
        page.setTotalCount(pageDb.getTotalCount());
        List<TblCarSystem> carSystems = pageDb.getResult();
        List<TblCarSystemBean> beanList = new ArrayList<TblCarSystemBean>();
        if (carSystems != null && carSystems.size() > 0) {
            for (TblCarSystem tblCarSystem : carSystems) {
                TblCarSystemBean bean = new TblCarSystemBean();
                BeanUtils.copyProperties(tblCarSystem, bean);
                beanList.add(bean);
            }
        }
        page.setResult(beanList);
        return page;
    }

    @Override
    public void removeCarSystemInfo(String id) throws Exception {
        carSystemService.removeCarSystemInfo(id);
    }

    @Override
    public void addCarSystemInfo(TblCarSystemBean carSystemBean) throws Exception {
        carSystemService.addCarSystemInfo(carSystemBean);
    }

    @Override
    public List<TblCarSystemBean> queryAll() {
        return carSystemService.queryAll();
    }
}

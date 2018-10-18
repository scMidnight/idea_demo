package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblCarSystemBean;
import person.db.bean.TblFileBean;
import person.db.bean.TblFileDetailBean;
import person.db.entity.TblCarSystem;
import person.db.entity.TblFileDetail;
import person.service.CarSystemService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunChang on 2018/8/27
 */
@Service("carService")
@Transactional
public class CarSystemServiceImpl extends CommonServiceImpl implements CarSystemService {
    @Override
    public void removeCarSystemInfo(String id) throws Exception {
        TblCarSystem carSystem = this.get(TblCarSystem.class, id);
        carSystem.setIsDel("1");
        super.updateEntitie(carSystem);
    }

    @Override
    public void addCarSystemInfo(TblCarSystemBean carSystemBean) throws Exception {
        TblCarSystem carSystem = new TblCarSystem();
        BeanUtils.copyProperties(carSystemBean, carSystem);
        super.save(carSystem);
    }

    @Override
    public List<TblCarSystemBean> queryAll() {
        List<TblCarSystem> carSystems = super.findByProperty(TblCarSystem.class, "isDel", "0");
        List<TblCarSystemBean> carSystemBeans = new ArrayList<TblCarSystemBean>();
        for (TblCarSystem carSystem : carSystems) {
            TblCarSystemBean carSystemBean = new TblCarSystemBean();
            BeanUtils.copyProperties(carSystem, carSystemBean);
            carSystemBeans.add(carSystemBean);
        }
        return carSystemBeans;
    }

    @Override
    public List<TblCarSystemBean> findByProperty(String propertyName, Object value) {
        List<TblCarSystem> carSystems = super.findByProperty(TblCarSystem.class, propertyName, value);
        List<TblCarSystemBean> carSystemBeans = new ArrayList<TblCarSystemBean>();
        if(null != carSystems && !carSystems.isEmpty()) {
            for (TblCarSystem carSystem : carSystems) {
                TblCarSystemBean carSystemBean = new TblCarSystemBean();
                BeanUtils.copyProperties(carSystem, carSystemBean);
                carSystemBeans.add(carSystemBean);
            }
        }
        return carSystemBeans;
    }
}

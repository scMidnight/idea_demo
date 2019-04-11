package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblCarSystemBean;
import person.db.entity.TblCarSystem;
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
        super.saveOrUpdate(carSystem);
    }

    @Override
    public List<TblCarSystemBean> queryAll() {
        //List<TblCarSystem> carSystems = super.findByProperty(TblCarSystem.class, "isDel", "0");
        List<TblCarSystem> carSystems = super.findHql("FROM TblCarSystem t where t.isDel='0' order by t.brandName, t.tradeName, t.carSysId asc");
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

    @Override
    public List<TblCarSystemBean> queryByHql(String hql, Object[] param) {
        List<TblCarSystem> carSystems = super.findHql(hql, param);
        List<TblCarSystemBean> carSystemBeans = new ArrayList<TblCarSystemBean>();
        if (carSystems != null && carSystems.size() > 0) {
            for (TblCarSystem carSystem : carSystems) {
                TblCarSystemBean carSystemBean = new TblCarSystemBean();
                BeanUtils.copyProperties(carSystem, carSystemBean);
                carSystemBeans.add(carSystemBean);
            }
        }
        return carSystemBeans;
    }
}

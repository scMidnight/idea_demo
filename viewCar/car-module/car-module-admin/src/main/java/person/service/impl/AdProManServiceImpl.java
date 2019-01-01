package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblAdProManageBean;
import person.db.entity.TblAdProManage;
import person.service.AdProManService;

import java.util.ArrayList;
import java.util.List;

@Service("adProManService")
@Transactional
public class AdProManServiceImpl extends CommonServiceImpl implements AdProManService {
    @Override
    public void add(TblAdProManageBean adProManageBean) {
        TblAdProManage adProManage = new TblAdProManage();
        BeanUtils.copyProperties(adProManageBean, adProManage);
        super.save(adProManage);
    }

    @Override
    public void batchAdd(List<TblAdProManageBean> adProManageBeans) {
        List<TblAdProManage> adProManages = new ArrayList<TblAdProManage>();
        for (TblAdProManageBean bean : adProManageBeans) {
            TblAdProManage adProManage = new TblAdProManage();
            BeanUtils.copyProperties(bean, adProManage);
            adProManages.add(adProManage);
        }
        super.batchSave(adProManages);
    }

    @Override
    public List<TblAdProManageBean> findByProperty(String propertyName, Object value) {
        List<TblAdProManage> adProManages = super.findByProperty(TblAdProManage.class, propertyName, value);
        List<TblAdProManageBean> adProManageBeans = new ArrayList<TblAdProManageBean>();
        if(null != adProManages && !adProManages.isEmpty()) {
            for (TblAdProManage adProManage : adProManages) {
                TblAdProManageBean adProManageBean = new TblAdProManageBean();
                BeanUtils.copyProperties(adProManage, adProManageBean);
                adProManageBeans.add(adProManageBean);
            }
        }
        return adProManageBeans;
    }

    @Override
    public List<TblAdProManageBean> queryByHql(String hql, Object... param) {
        List<TblAdProManage> adProManages = super.findHql(hql, param);
        List<TblAdProManageBean> adProManageBeans = new ArrayList<TblAdProManageBean>();
        if (adProManages != null && adProManages.size() > 0) {
            for (TblAdProManage adProManage : adProManages) {
                TblAdProManageBean adProManageBean = new TblAdProManageBean();
                BeanUtils.copyProperties(adProManage, adProManageBean);
                adProManageBeans.add(adProManageBean);
            }
        }
        return adProManageBeans;
    }

    @Override
    public void deleteWhere(String propertyName, Object value) {
        List<TblAdProManage> adProManages = super.findByProperty(TblAdProManage.class, propertyName, value);
        if(null != adProManages && !adProManages.isEmpty()) {
            super.deleteAllEntitie(adProManages);
        }
    }

    @Override
    public void deleteAll() {
        List<TblAdProManage> adProManages = super.findHql("FROM TblAdProManage t ");
        if(null != adProManages && !adProManages.isEmpty()) {
            super.deleteAllEntitie(adProManages);
        }
    }

    @Override
    public TblAdProManageBean queryById(String id) {
        TblAdProManage adProManage = super.get(TblAdProManage.class, id);
        TblAdProManageBean adProManageBean = new TblAdProManageBean();
        BeanUtils.copyProperties(adProManage, adProManageBean);
        return adProManageBean;
    }

    @Override
    public void updateAdProMan(TblAdProManageBean adProManageBean) {
        TblAdProManage adProManage = super.get(TblAdProManage.class, adProManageBean.getId());
        BeanUtils.copyProperties(adProManageBean, adProManage);
        super.updateEntitie(adProManage);
    }
}

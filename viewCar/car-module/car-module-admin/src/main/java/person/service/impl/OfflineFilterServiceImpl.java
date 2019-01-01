package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblOfflineFilterBean;
import person.db.entity.TblOfflineFilter;
import person.service.OfflineFilterService;

import java.util.ArrayList;
import java.util.List;

@Service("offlineFilterService")
@Transactional
public class OfflineFilterServiceImpl extends CommonServiceImpl implements OfflineFilterService {
    @Override
    public void add(TblOfflineFilterBean offlineFilterBean) {
        TblOfflineFilter offlineFilter = new TblOfflineFilter();
        BeanUtils.copyProperties(offlineFilterBean, offlineFilter);
        super.save(offlineFilter);
    }

    @Override
    public void batchAdd(List<TblOfflineFilterBean> offlineFilterBeans) {
        List<TblOfflineFilter> offlineFilters = new ArrayList<TblOfflineFilter>();
        for (TblOfflineFilterBean bean : offlineFilterBeans) {
            TblOfflineFilter offlineFilter = new TblOfflineFilter();
            BeanUtils.copyProperties(bean, offlineFilter);
            offlineFilters.add(offlineFilter);
        }
        super.batchSave(offlineFilters);
    }

    @Override
    public List<TblOfflineFilterBean> findByProperty(String propertyName, Object value) {
        List<TblOfflineFilter> offlineFilters = super.findByProperty(TblOfflineFilter.class, propertyName, value);
        List<TblOfflineFilterBean> offlineFilterBeans = new ArrayList<TblOfflineFilterBean>();
        if(null != offlineFilters && !offlineFilters.isEmpty()) {
            for (TblOfflineFilter offlineFilter : offlineFilters) {
                TblOfflineFilterBean offlineFilterBean = new TblOfflineFilterBean();
                BeanUtils.copyProperties(offlineFilter, offlineFilterBean);
                offlineFilterBeans.add(offlineFilterBean);
            }
        }
        return offlineFilterBeans;
    }

    @Override
    public List<TblOfflineFilterBean> queryByHql(String hql, Object... param) {
        List<TblOfflineFilter> offlineFilters = super.findHql(hql, param);
        List<TblOfflineFilterBean> offlineFilterBeans = new ArrayList<TblOfflineFilterBean>();
        if (offlineFilters != null && offlineFilters.size() > 0) {
            for (TblOfflineFilter offlineFilter : offlineFilters) {
                TblOfflineFilterBean offlineFilterBean = new TblOfflineFilterBean();
                BeanUtils.copyProperties(offlineFilter, offlineFilterBean);
                offlineFilterBeans.add(offlineFilterBean);
            }
        }
        return offlineFilterBeans;
    }

    @Override
    public void deleteWhere(String propertyName, Object value) {
        List<TblOfflineFilter> offlineFilters = super.findByProperty(TblOfflineFilter.class, propertyName, value);
        if(null != offlineFilters && !offlineFilters.isEmpty()) {
            super.deleteAllEntitie(offlineFilters);
        }
    }

    @Override
    public void deleteAll() {
        List<TblOfflineFilter> offlineFilters = super.findHql("FROM TblOfflineFilter t ");
        if(null != offlineFilters && !offlineFilters.isEmpty()) {
            super.deleteAllEntitie(offlineFilters);
        }
    }
}

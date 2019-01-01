package person.handler.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblOfflineFilterBean;
import person.db.entity.Page;
import person.db.entity.TblOfflineFilter;
import person.handler.OfflineFilterHandler;
import person.service.OfflineFilterService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("offlineFilterHandler")
public class OfflineFilterHandlerImpl implements OfflineFilterHandler {

    @Autowired
    OfflineFilterService offlineFilterService;

    @Override
    public Page<TblOfflineFilterBean> queryByPageFilter(Page<TblOfflineFilterBean> page, String hql, Map<String, Object> values) {
        Page<TblOfflineFilter> pageDb = new Page<TblOfflineFilter>();
        pageDb.setAutoCount(page.isAutoCount());
        pageDb.setOrder(page.getOrder());
        pageDb.setOrderBy(page.getOrderBy());
        pageDb.setPageNo(page.getPageNo());
        pageDb.setPageSize(page.getPageSize());
        pageDb = offlineFilterService.find(pageDb, hql, values);
        page.setTotalCount(pageDb.getTotalCount());
        List<TblOfflineFilter> offlineFilters = pageDb.getResult();
        List<TblOfflineFilterBean> beanList = new ArrayList<TblOfflineFilterBean>();
        if (offlineFilters != null && offlineFilters.size() > 0) {
            for (TblOfflineFilter offlineFilter : offlineFilters) {
                TblOfflineFilterBean bean = new TblOfflineFilterBean();
                BeanUtils.copyProperties(offlineFilter, bean);
                beanList.add(bean);
            }
        }
        page.setResult(beanList);
        return page;
    }

    @Override
    public void add(TblOfflineFilterBean offlineFilterBean) {
        offlineFilterService.add(offlineFilterBean);
    }

    @Override
    public void batchAdd(List<TblOfflineFilterBean> offlineFilterBeans) {
        offlineFilterService.batchAdd(offlineFilterBeans);
    }

    @Override
    public List<TblOfflineFilterBean> findByProperty(String propertyName, Object value) {
        return offlineFilterService.findByProperty(propertyName, value);
    }

    @Override
    public List<TblOfflineFilterBean> queryByHql(String hql, Object... param) {
        return offlineFilterService.queryByHql(hql, param);
    }

    @Override
    public void deleteWhere(String propertyName, Object value) {
        offlineFilterService.deleteWhere(propertyName, value);
    }

    @Override
    public void deleteAll() {
        offlineFilterService.deleteAll();
    }

    @Override
    public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
        return offlineFilterService.findForJdbc(sql, objs);
    }
}

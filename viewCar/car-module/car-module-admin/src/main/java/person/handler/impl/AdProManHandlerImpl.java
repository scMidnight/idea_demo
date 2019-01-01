package person.handler.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblAdProManageBean;
import person.db.entity.Page;
import person.db.entity.TblAdProManage;
import person.handler.AdProManHandler;
import person.service.AdProManService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("adProManHandler")
public class AdProManHandlerImpl implements AdProManHandler {

    @Autowired
    AdProManService adProManService;

    @Override
    public Page<TblAdProManageBean> queryByPageFilter(Page<TblAdProManageBean> page, String hql, Map<String, Object> values) {
        Page<TblAdProManage> pageDb = new Page<TblAdProManage>();
        pageDb.setAutoCount(page.isAutoCount());
        pageDb.setOrder(page.getOrder());
        pageDb.setOrderBy(page.getOrderBy());
        pageDb.setPageNo(page.getPageNo());
        pageDb.setPageSize(page.getPageSize());
        pageDb = adProManService.find(pageDb, hql, values);
        page.setTotalCount(pageDb.getTotalCount());
        List<TblAdProManage> adProManages = pageDb.getResult();
        List<TblAdProManageBean> beanList = new ArrayList<TblAdProManageBean>();
        if (adProManages != null && adProManages.size() > 0) {
            for (TblAdProManage adProManage : adProManages) {
                TblAdProManageBean bean = new TblAdProManageBean();
                BeanUtils.copyProperties(adProManage, bean);
                beanList.add(bean);
            }
        }
        page.setResult(beanList);
        return page;
    }

    @Override
    public TblAdProManageBean queryById(String id) {
        return adProManService.queryById(id);
    }

    @Override
    public void add(TblAdProManageBean adProManageBean) {
        adProManService.add(adProManageBean);
    }

    @Override
    public void batchAdd(List<TblAdProManageBean> adProManageBeans) {
        adProManService.batchAdd(adProManageBeans);
    }

    @Override
    public List<TblAdProManageBean> findByProperty(String propertyName, Object value) {
        return adProManService.findByProperty(propertyName, value);
    }

    @Override
    public List<TblAdProManageBean> queryByHql(String hql, Object... param) {
        return adProManService.queryByHql(hql, param);
    }

    @Override
    public void deleteWhere(String propertyName, Object value) {
        adProManService.deleteWhere(propertyName, value);
    }

    @Override
    public void deleteAll() {
        adProManService.deleteAll();
    }

    @Override
    public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
        return adProManService.findForJdbc(sql, objs);
    }

    @Override
    public void updateAdProMan(TblAdProManageBean adProManageBean) throws Exception {
        adProManService.updateAdProMan(adProManageBean);
    }
}

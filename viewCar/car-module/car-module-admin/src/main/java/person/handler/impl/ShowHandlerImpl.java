package person.handler.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblCarSystemBean;
import person.db.bean.TblShowBean;
import person.db.entity.Page;
import person.db.entity.TblCarSystem;
import person.db.entity.TblShow;
import person.handler.ShowHandler;
import person.service.ShowService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by SunChang on 2018/11/29
 */
@Service("showHandler")
public class ShowHandlerImpl implements ShowHandler {

    @Autowired
    ShowService showService;

    @Override
    public Page<TblShowBean> queryByPageFilter(Page<TblShowBean> page, String hql, Map<String, Object> values) {
        Page<TblShow> pageDb = new Page<TblShow>();
        pageDb.setAutoCount(page.isAutoCount());
        pageDb.setOrder(page.getOrder());
        pageDb.setOrderBy(page.getOrderBy());
        pageDb.setPageNo(page.getPageNo());
        pageDb.setPageSize(page.getPageSize());
        pageDb = showService.find(pageDb, hql, values);
        page.setTotalCount(pageDb.getTotalCount());
        List<TblShow> shows = pageDb.getResult();
        List<TblShowBean> beanList = new ArrayList<TblShowBean>();
        if (shows != null && shows.size() > 0) {
            for (TblShow show : shows) {
                TblShowBean bean = new TblShowBean();
                BeanUtils.copyProperties(show, bean);
                beanList.add(bean);
            }
        }
        page.setResult(beanList);
        return page;
    }

    @Override
    public void add(TblShowBean showBean) {
        showService.add(showBean);
    }

    @Override
    public void batchAdd(List<TblShowBean> showBeans) {
        showService.batchAdd(showBeans);
    }

    @Override
    public List<TblShowBean> findByProperty(String propertyName, Object value) {
        return showService.findByProperty(propertyName, value);
    }

    @Override
    public List<TblShowBean> queryByHql(String hql, Object... param) {
        return showService.queryByHql(hql, param);
    }

    @Override
    public void deleteWhere(String propertyName, Object value) {
        showService.deleteWhere(propertyName, value);
    }

    @Override
    public void deleteAll() {
        showService.deleteAll();
    }

    @Override
    public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
        return showService.findForJdbc(sql, objs);
    }
}

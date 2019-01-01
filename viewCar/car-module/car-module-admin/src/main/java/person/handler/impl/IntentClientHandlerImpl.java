package person.handler.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblIntentClientBean;
import person.db.entity.Page;
import person.db.entity.TblIntentClient;
import person.handler.IntentClientHandler;
import person.service.IntentClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("intentClientHandler")
public class IntentClientHandlerImpl implements IntentClientHandler {
    @Autowired
    IntentClientService intentClientService;

    @Override
    public Page<TblIntentClientBean> queryByPageFilter(Page<TblIntentClientBean> page, String hql, Map<String, Object> values) {
        Page<TblIntentClient> pageDb = new Page<TblIntentClient>();
        pageDb.setAutoCount(page.isAutoCount());
        pageDb.setOrder(page.getOrder());
        pageDb.setOrderBy(page.getOrderBy());
        pageDb.setPageNo(page.getPageNo());
        pageDb.setPageSize(page.getPageSize());
        pageDb = intentClientService.find(pageDb, hql, values);
        page.setTotalCount(pageDb.getTotalCount());
        List<TblIntentClient> intentClients = pageDb.getResult();
        List<TblIntentClientBean> beanList = new ArrayList<TblIntentClientBean>();
        if (intentClients != null && intentClients.size() > 0) {
            for (TblIntentClient intentClient : intentClients) {
                TblIntentClientBean bean = new TblIntentClientBean();
                BeanUtils.copyProperties(intentClient, bean);
                beanList.add(bean);
            }
        }
        page.setResult(beanList);
        return page;
    }

    @Override
    public void add(TblIntentClientBean intentClientBean) {
        intentClientService.add(intentClientBean);
    }

    @Override
    public void batchAdd(List<TblIntentClientBean> intentClientBeans) {
        intentClientService.batchAdd(intentClientBeans);
    }

    @Override
    public List<TblIntentClientBean> findByProperty(String propertyName, Object value) {
        return intentClientService.findByProperty(propertyName, value);
    }

    @Override
    public List<TblIntentClientBean> queryByHql(String hql, Object... param) {
        return intentClientService.queryByHql(hql, param);
    }

    @Override
    public void deleteWhere(String propertyName, Object value) {
        intentClientService.deleteWhere(propertyName, value);
    }

    @Override
    public void deleteAll() {
        intentClientService.deleteAll();
    }

    @Override
    public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
        return intentClientService.findForJdbc(sql, objs);
    }
}

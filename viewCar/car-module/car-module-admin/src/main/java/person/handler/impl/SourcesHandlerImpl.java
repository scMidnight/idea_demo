package person.handler.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.SourcesBean;
import person.db.entity.Page;
import person.db.entity.Sources;
import person.handler.SourcesHandler;
import person.service.SourcesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("sourcesHandler")
public class SourcesHandlerImpl implements SourcesHandler {
    @Autowired
    SourcesService sourcesService;

    @Override
    public Page<SourcesBean> queryByPageFilter(Page<SourcesBean> page, String hql, Map<String, Object> values) {
        Page<Sources> pageDb = new Page<Sources>();
        pageDb.setAutoCount(page.isAutoCount());
        pageDb.setOrder(page.getOrder());
        pageDb.setOrderBy(page.getOrderBy());
        pageDb.setPageNo(page.getPageNo());
        pageDb.setPageSize(page.getPageSize());
        pageDb = sourcesService.find(pageDb, hql, values);
        page.setTotalCount(pageDb.getTotalCount());
        List<Sources> sources = pageDb.getResult();
        List<SourcesBean> beanList = new ArrayList<SourcesBean>();
        if (sources != null && sources.size() > 0) {
            for (Sources sources1 : sources) {
                SourcesBean bean = new SourcesBean();
                BeanUtils.copyProperties(sources1, bean);
                beanList.add(bean);
            }
        }
        page.setResult(beanList);
        return page;
    }

    @Override
    public void removeSource(String id) throws Exception {
        sourcesService.removeSource(id);
    }

    @Override
    public void addSource(SourcesBean bean) throws Exception {
        sourcesService.addSource(bean);
    }

    @Override
    public List<SourcesBean> queryAll() {
        return sourcesService.queryAll();
    }

    @Override
    public List<SourcesBean> findByProperty(String propertyName, Object value) {
        return sourcesService.findByProperty(propertyName, value);
    }

    @Override
    public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
        return sourcesService.findForJdbc(sql, objs);
    }

    @Override
    public List<SourcesBean> queryByHql(String hql, Object... param) {
        return sourcesService.queryByHql(hql, param);
    }

    @Override
    public SourcesBean getBean(String id) {
        Sources sources = sourcesService.get(Sources.class, id);
        SourcesBean bean = new SourcesBean();
        BeanUtils.copyProperties(sources, bean);
        return bean;
    }
}

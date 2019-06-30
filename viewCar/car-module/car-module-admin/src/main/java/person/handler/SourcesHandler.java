package person.handler;

import person.db.bean.SourcesBean;
import person.db.entity.Page;

import java.util.List;
import java.util.Map;

public interface SourcesHandler {

    Page<SourcesBean> queryByPageFilter(Page<SourcesBean> page, String hql, Map<String, Object> values);

    void removeSource(String id) throws Exception;

    void addSource(SourcesBean bean) throws Exception;

    List<SourcesBean> queryAll();

    List<SourcesBean> findByProperty(String propertyName, Object value);

    List<Map<String, Object>> findForJdbc(String sql, Object... objs);

    List<SourcesBean> queryByHql(String hql, Object... param);

    SourcesBean getBean(String id);
}

package person.service;

import person.db.bean.SourcesBean;

import java.util.List;

public interface SourcesService extends CommonService {
    void removeSource(String id) throws Exception;

    void addSource(SourcesBean bean) throws Exception;

    List<SourcesBean> queryAll();

    List<SourcesBean> findByProperty(String propertyName, Object value);

    List<SourcesBean> queryByHql(String hql, Object[] param);
}

package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.SourcesBean;
import person.db.entity.Sources;
import person.service.SourcesService;

import java.util.ArrayList;
import java.util.List;

@Service("sourcesService")
@Transactional
public class SourcesServiceImpl extends CommonServiceImpl implements SourcesService {
    @Override
    public void removeSource(String id) throws Exception {
        Sources sources = this.get(Sources.class, id);
        sources.setIsDel("1");
        super.updateEntitie(sources);
    }

    @Override
    public void addSource(SourcesBean bean) throws Exception {
        Sources sources = new Sources();
        BeanUtils.copyProperties(bean, sources);
        super.saveOrUpdate(sources);
    }

    @Override
    public List<SourcesBean> queryAll() {
        List<Sources> sources = super.findByProperty(Sources.class, "isDel", "0");
        List<SourcesBean> sourcesBeans = new ArrayList<SourcesBean>();
        for (Sources sources1 : sources) {
            SourcesBean sourcesBean = new SourcesBean();
            BeanUtils.copyProperties(sources1, sourcesBean);
            sourcesBeans.add(sourcesBean);
        }
        return sourcesBeans;
    }

    @Override
    public List<SourcesBean> findByProperty(String propertyName, Object value) {
        List<Sources> sources = super.findByProperty(Sources.class, propertyName, value);
        List<SourcesBean> sourcesBeans = new ArrayList<SourcesBean>();
        if(null != sources && !sources.isEmpty()) {
            for (Sources sources1 : sources) {
                SourcesBean sourcesBean = new SourcesBean();
                BeanUtils.copyProperties(sources1, sourcesBean);
                sourcesBeans.add(sourcesBean);
            }
        }
        return sourcesBeans;
    }

    @Override
    public List<SourcesBean> queryByHql(String hql, Object[] param) {
        List<Sources> sources = super.findHql(hql, param);
        List<SourcesBean> sourcesBeans = new ArrayList<SourcesBean>();
        if (sources != null && sources.size() > 0) {
            for (Sources sources1 : sources) {
                SourcesBean sourcesBean = new SourcesBean();
                BeanUtils.copyProperties(sources1, sourcesBean);
                sourcesBeans.add(sourcesBean);
            }
        }
        return sourcesBeans;
    }
}

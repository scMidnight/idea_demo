package person.handler.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblFlowAnalysisBean;
import person.db.entity.Page;
import person.db.entity.TblFlowAnalysis;
import person.handler.FlowAnalysisHandler;
import person.service.FlowAnalysisService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("flowAnalysisHandler")
public class FlowAnalysisHandlerImpl implements FlowAnalysisHandler {
    @Autowired
    FlowAnalysisService flowAnalysisService;

    @Override
    public Page<TblFlowAnalysisBean> queryByPageFilter(Page<TblFlowAnalysisBean> page, String hql, Map<String, Object> values) {
        Page<TblFlowAnalysis> pageDb = new Page<TblFlowAnalysis>();
        pageDb.setAutoCount(page.isAutoCount());
        pageDb.setOrder(page.getOrder());
        pageDb.setOrderBy(page.getOrderBy());
        pageDb.setPageNo(page.getPageNo());
        pageDb.setPageSize(page.getPageSize());
        pageDb = flowAnalysisService.find(pageDb, hql, values);
        page.setTotalCount(pageDb.getTotalCount());
        List<TblFlowAnalysis> flowAnalyses = pageDb.getResult();
        List<TblFlowAnalysisBean> beanList = new ArrayList<TblFlowAnalysisBean>();
        if (flowAnalyses != null && flowAnalyses.size() > 0) {
            for (TblFlowAnalysis flowAnalysis : flowAnalyses) {
                TblFlowAnalysisBean bean = new TblFlowAnalysisBean();
                BeanUtils.copyProperties(flowAnalysis, bean);
                beanList.add(bean);
            }
        }
        page.setResult(beanList);
        return page;
    }

    @Override
    public void add(TblFlowAnalysisBean flowAnalysisBean) {
        flowAnalysisService.add(flowAnalysisBean);
    }

    @Override
    public void batchAdd(List<TblFlowAnalysisBean> flowAnalysisBeans) {
        flowAnalysisService.batchAdd(flowAnalysisBeans);
    }

    @Override
    public List<TblFlowAnalysisBean> findByProperty(String propertyName, Object value) {
        return flowAnalysisService.findByProperty(propertyName, value);
    }

    @Override
    public List<TblFlowAnalysisBean> queryByHql(String hql, Object... param) {
        return flowAnalysisService.queryByHql(hql, param);
    }

    @Override
    public void deleteWhere(String propertyName, Object value) {
        flowAnalysisService.deleteWhere(propertyName, value);
    }

    @Override
    public void deleteAll() {
        flowAnalysisService.deleteAll();
    }

    @Override
    public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
        return flowAnalysisService.findForJdbc(sql, objs);
    }
}

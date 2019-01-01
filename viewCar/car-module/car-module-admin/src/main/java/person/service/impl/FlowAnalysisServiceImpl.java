package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblFlowAnalysisBean;
import person.db.entity.TblFlowAnalysis;
import person.service.FlowAnalysisService;

import java.util.ArrayList;
import java.util.List;

@Service("slowAnalysisService")
@Transactional
public class FlowAnalysisServiceImpl extends CommonServiceImpl implements FlowAnalysisService {

    @Override
    public void add(TblFlowAnalysisBean flowAnalysisBean) {
        TblFlowAnalysis flowAnalysis = new TblFlowAnalysis();
        BeanUtils.copyProperties(flowAnalysisBean, flowAnalysis);
        super.save(flowAnalysis);
    }

    @Override
    public void batchAdd(List<TblFlowAnalysisBean> flowAnalysisBeans) {
        List<TblFlowAnalysis> flowAnalyses = new ArrayList<TblFlowAnalysis>();
        for (TblFlowAnalysisBean bean : flowAnalysisBeans) {
            TblFlowAnalysis flowAnalysis = new TblFlowAnalysis();
            BeanUtils.copyProperties(bean, flowAnalysis);
            flowAnalyses.add(flowAnalysis);
        }
        super.batchSave(flowAnalyses);
    }

    @Override
    public List<TblFlowAnalysisBean> findByProperty(String propertyName, Object value) {
        List<TblFlowAnalysis> flowAnalyses = super.findByProperty(TblFlowAnalysis.class, propertyName, value);
        List<TblFlowAnalysisBean> flowAnalysisBeans = new ArrayList<TblFlowAnalysisBean>();
        if(null != flowAnalyses && !flowAnalyses.isEmpty()) {
            for (TblFlowAnalysis flowAnalysis : flowAnalyses) {
                TblFlowAnalysisBean flowAnalysisBean = new TblFlowAnalysisBean();
                BeanUtils.copyProperties(flowAnalysis, flowAnalysisBean);
                flowAnalysisBeans.add(flowAnalysisBean);
            }
        }
        return flowAnalysisBeans;
    }

    @Override
    public List<TblFlowAnalysisBean> queryByHql(String hql, Object... param) {
        List<TblFlowAnalysis> flowAnalyses = super.findHql(hql, param);
        List<TblFlowAnalysisBean> flowAnalysisBeans = new ArrayList<TblFlowAnalysisBean>();
        if (flowAnalyses != null && flowAnalyses.size() > 0) {
            for (TblFlowAnalysis flowAnalysis : flowAnalyses) {
                TblFlowAnalysisBean flowAnalysisBean = new TblFlowAnalysisBean();
                BeanUtils.copyProperties(flowAnalysis, flowAnalysisBean);
                flowAnalysisBeans.add(flowAnalysisBean);
            }
        }
        return flowAnalysisBeans;
    }

    @Override
    public void deleteWhere(String propertyName, Object value) {
        List<TblFlowAnalysis> flowAnalyses = super.findByProperty(TblFlowAnalysis.class, propertyName, value);
        if(null != flowAnalyses && !flowAnalyses.isEmpty()) {
            super.deleteAllEntitie(flowAnalyses);
        }
    }

    @Override
    public void deleteAll() {
        List<TblFlowAnalysis> flowAnalyses = super.findHql("FROM TblFlowAnalysis t ");
        if(null != flowAnalyses && !flowAnalyses.isEmpty()) {
            super.deleteAllEntitie(flowAnalyses);
        }
    }
}

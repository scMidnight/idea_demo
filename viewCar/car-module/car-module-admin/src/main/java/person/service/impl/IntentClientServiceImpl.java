package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblIntentClientBean;
import person.db.entity.TblIntentClient;
import person.service.IntentClientService;

import java.util.ArrayList;
import java.util.List;

@Service("intentClientService")
@Transactional
public class IntentClientServiceImpl extends CommonServiceImpl implements IntentClientService {
    @Override
    public void add(TblIntentClientBean intentClientBean) {
        TblIntentClient intentClient = new TblIntentClient();
        BeanUtils.copyProperties(intentClientBean, intentClient);
        super.save(intentClient);
    }

    @Override
    public void batchAdd(List<TblIntentClientBean> intentClientBeans) {
        List<TblIntentClient> intentClients = new ArrayList<TblIntentClient>();
        for (TblIntentClientBean bean : intentClientBeans) {
            TblIntentClient intentClient = new TblIntentClient();
            BeanUtils.copyProperties(bean, intentClient);
            intentClients.add(intentClient);
        }
        super.batchSave(intentClients);
    }

    @Override
    public List<TblIntentClientBean> findByProperty(String propertyName, Object value) {
        List<TblIntentClient> intentClients = super.findByProperty(TblIntentClient.class, propertyName, value);
        List<TblIntentClientBean> intentClientBeans = new ArrayList<TblIntentClientBean>();
        if(null != intentClients && !intentClients.isEmpty()) {
            for (TblIntentClient intentClient : intentClients) {
                TblIntentClientBean intentClientBean = new TblIntentClientBean();
                BeanUtils.copyProperties(intentClient, intentClientBean);
                intentClientBeans.add(intentClientBean);
            }
        }
        return intentClientBeans;
    }

    @Override
    public List<TblIntentClientBean> queryByHql(String hql, Object... param) {
        List<TblIntentClient> intentClients = super.findHql(hql, param);
        List<TblIntentClientBean> intentClientBeans = new ArrayList<TblIntentClientBean>();
        if (intentClients != null && intentClients.size() > 0) {
            for (TblIntentClient intentClient : intentClients) {
                TblIntentClientBean intentClientBean = new TblIntentClientBean();
                BeanUtils.copyProperties(intentClient, intentClientBean);
                intentClientBeans.add(intentClientBean);
            }
        }
        return intentClientBeans;
    }

    @Override
    public void deleteWhere(String propertyName, Object value) {
        List<TblIntentClient> intentClients = super.findByProperty(TblIntentClient.class, propertyName, value);
        if(null != intentClients && !intentClients.isEmpty()) {
            super.deleteAllEntitie(intentClients);
        }
    }

    @Override
    public void deleteAll() {
        List<TblIntentClient> intentClients = super.findHql("FROM TblIntentClient t ");
        if(null != intentClients && !intentClients.isEmpty()) {
            super.deleteAllEntitie(intentClients);
        }
    }
}

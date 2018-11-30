package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblShowBean;
import person.db.entity.TblShow;
import person.service.ShowService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunChang on 2018/11/29
 */
@Service("showService")
@Transactional
public class ShowServiceImpl extends CommonServiceImpl implements ShowService {

    @Override
    public void add(TblShowBean showBean) {
        TblShow show = new TblShow();
        BeanUtils.copyProperties(showBean, show);
        super.save(show);
    }

    @Override
    public void batchAdd(List<TblShowBean> showBeans) {
        List<TblShow> shows = new ArrayList<TblShow>();
        for (TblShowBean showBean : showBeans) {
            TblShow show = new TblShow();
            BeanUtils.copyProperties(showBean, show);
            shows.add(show);
        }
        super.batchSave(shows);
    }

    @Override
    public List<TblShowBean> findByProperty(String propertyName, Object value) {
        List<TblShow> shows = super.findByProperty(TblShow.class, propertyName, value);
        List<TblShowBean> showBeans = new ArrayList<TblShowBean>();
        if(null != shows && !shows.isEmpty()) {
            for (TblShow show : shows) {
                TblShowBean showBean = new TblShowBean();
                BeanUtils.copyProperties(show, showBean);
                showBeans.add(showBean);
            }
        }
        return showBeans;
    }

    @Override
    public List<TblShowBean> queryByHql(String hql, Object... param) {
        List<TblShow> shows = super.findHql(hql, param);
        List<TblShowBean> showBeans = new ArrayList<TblShowBean>();
        if (shows != null && shows.size() > 0) {
            for (TblShow show : shows) {
                TblShowBean showBean = new TblShowBean();
                BeanUtils.copyProperties(show, showBean);
                showBeans.add(showBean);
            }
        }
        return showBeans;
    }

    @Override
    public void deleteWhere(String propertyName, Object value) {
        List<TblShow> shows = super.findByProperty(TblShow.class, propertyName, value);
        if(null != shows && !shows.isEmpty()) {
            super.deleteAllEntitie(shows);
        }
    }

    @Override
    public void deleteAll() {
        List<TblShow> shows = super.findHql("FROM TblShow t ");
        if(null != shows && !shows.isEmpty()) {
            super.deleteAllEntitie(shows);
        }
    }
}

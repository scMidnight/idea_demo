package person.handler.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.CarFindBean;
import person.db.bean.TblFileBean;
import person.db.entity.Page;
import person.db.entity.TblFile;
import person.handler.FileHandler;
import person.service.FileService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("fileHandler")
public class FileHandlerImpl implements FileHandler {
    @Autowired
    FileService fileService;

    @Override
    public Page<TblFileBean> queryByPageFilter(Page<TblFileBean> page, String hql, Map<String, Object> values) {
        Page<TblFile> pageDb = new Page<TblFile>();
        pageDb.setAutoCount(page.isAutoCount());
        pageDb.setOrder(page.getOrder());
        pageDb.setOrderBy(page.getOrderBy());
        pageDb.setPageNo(page.getPageNo());
        pageDb.setPageSize(page.getPageSize());
        pageDb = fileService.find(pageDb, hql, values);
        page.setTotalCount(pageDb.getTotalCount());
        List<TblFile> files = pageDb.getResult();
        List<TblFileBean> beanList = new ArrayList<TblFileBean>();
        if (files != null && files.size() > 0) {
            for (TblFile file : files) {
                TblFileBean bean = new TblFileBean();
                BeanUtils.copyProperties(file, bean);
                beanList.add(bean);
            }
        }
        page.setResult(beanList);
        return page;
    }

    @Override
    public Page<CarFindBean> queryByPageCarFind(Page<CarFindBean> page, String hql, Map<String, Object> values) {
        Page<CarFindBean> pageDb = new Page<CarFindBean>();
        pageDb.setAutoCount(page.isAutoCount());
        pageDb.setOrder(page.getOrder());
        pageDb.setOrderBy(page.getOrderBy());
        pageDb.setPageNo(page.getPageNo());
        pageDb.setPageSize(page.getPageSize());
        pageDb = fileService.find(pageDb, hql, values);
        page.setTotalCount(pageDb.getTotalCount());
        List list = pageDb.getResult();
        List<CarFindBean> carFindBeans = new ArrayList<>();
        for (Object o : list) {
            Object[] os = (Object[]) o;
            CarFindBean bean = new CarFindBean();
            bean.setUploadDate((Date) os[0]);
            bean.setTaskId((String) os[1]);
            bean.setName((String) os[2]);
            bean.setPhone((String) os[3]);
            bean.setProvName((String) os[4]);
            bean.setCityName((String) os[5]);
            bean.setCarSys((String) os[6]);
            bean.setBrand((String) os[7]);
            bean.setTrade((String) os[8]);
            bean.setFileNameBak((String) os[9]);
            bean.setFileName((String) os[10]);
            bean.setSourceTag((String) os[11]);
            bean.setBigLibRepeatCount((String) os[12]);
            bean.setBrandCount((String) os[13]);
            bean.setTradeCount((String) os[14]);
            bean.setCarSysRepeatCount((String) os[15]);
            bean.setId((String) os[16]);
            carFindBeans.add(bean);
        }
        page.setResult(carFindBeans);
        return page;
    }

    public static  <T> T get(Class<T> clz,Object o){
        if(clz.isInstance(o)){
            return clz.cast(o);
        }
        return null;
    }

    @Override
    public void addAttachment(TblFileBean fileBean) {
        fileService.addAttachment(fileBean);
    }

    @Override
    public void batchAddAttachment(List<TblFileBean> fileBeans) {
        fileService.batchAddAttachment(fileBeans);
    }

    @Override
    public TblFileBean queryById(String id) {
        return fileService.queryById(id);
    }

    @Override
    public List<TblFileBean> queryByHql(String hql, Object... param) {
        return fileService.queryByHql(hql, param);
    }

    @Override
    public List<CarFindBean> queryByhqlFind(String hql, Object... param) {
        return fileService.queryByhqlFind(hql, param);
    }
}

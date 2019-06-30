package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.CarFindBean;
import person.db.bean.TblFileBean;
import person.db.entity.TblFile;
import person.service.FileService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("fileService")
@Transactional
public class FileServiceImpl extends CommonServiceImpl implements FileService {
    @Override
    public void addAttachment(TblFileBean fileBean) {
        TblFile file = new TblFile();
        BeanUtils.copyProperties(fileBean, file);
        file.setUploadDate(new Date());//新增时间
        super.saveOrUpdate(file);
    }

    @Override
    public void batchAddAttachment(List<TblFileBean> fileBeans) {
        List<TblFile> files = new ArrayList<TblFile>();
        for (TblFileBean fileBean : fileBeans) {
            TblFile file = new TblFile();
            BeanUtils.copyProperties(fileBean, file);
            file.setUploadDate(new Date());//新增时间
            files.add(file);
        }
        super.batchSave(files);
    }

    @Override
    public TblFileBean queryById(String id) {
        TblFile file = this.get(TblFile.class, id);
        TblFileBean fileBean = new TblFileBean();
        BeanUtils.copyProperties(file, fileBean);
        return fileBean;
    }

    @Override
    public void deleteFile(String id) {
        TblFile file = this.get(TblFile.class, id);
        super.delete(file);
    }

    @Override
    public List<TblFileBean> queryByHql(String hql, Object... param) {
        List<TblFile> files = super.findHql(hql, param);
        List<TblFileBean> fileBeans = new ArrayList<TblFileBean>();
        if (files != null && files.size() > 0) {
            for (TblFile file : files) {
                TblFileBean fileBean = new TblFileBean();
                BeanUtils.copyProperties(file, fileBean);
                fileBeans.add(fileBean);
            }
        }
        return fileBeans;
    }

    @Override
    public List<CarFindBean> queryByhqlFind(String hql, Object... param) {
        List<Object> objs = super.findHql(hql, param);
        List<CarFindBean> carFindBeans = new ArrayList<>();
        for (Object obj : objs) {
            Object[] os = (Object[]) obj;
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
        return carFindBeans;
    }
}

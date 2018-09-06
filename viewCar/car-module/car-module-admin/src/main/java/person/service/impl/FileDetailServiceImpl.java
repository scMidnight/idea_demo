package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblFileBean;
import person.db.bean.TblFileDetailBean;
import person.db.entity.TblFile;
import person.db.entity.TblFileDetail;
import person.service.FileDetailService;
import person.service.FileService;

import java.util.ArrayList;
import java.util.List;

@Service("fileDetailService")
@Transactional
public class FileDetailServiceImpl extends CommonServiceImpl implements FileDetailService {
    @Autowired
    FileService fileService;

    @Override
    public List<TblFileDetailBean> findByProperty(String propertyName, Object value) {
        List<TblFileDetail> fileDetails = super.findByProperty(TblFileDetail.class, propertyName, value);
        List<TblFileDetailBean> fileDetailBeans = new ArrayList<TblFileDetailBean>();
        if(null != fileDetails && !fileDetails.isEmpty()) {
            for (TblFileDetail fileDetail : fileDetails) {
                TblFileDetailBean fileDetailBean = new TblFileDetailBean();
                BeanUtils.copyProperties(fileDetail, fileDetailBean);
                TblFileBean fileBean = fileService.queryById(fileDetail.getFileId());
                fileDetailBean.setFileBean(fileBean);
                fileDetailBeans.add(fileDetailBean);
            }
        }
        return fileDetailBeans;
    }

    @Override
    public void deleteAllAndFile(String propertyName, Object value) {
        List<TblFileDetail> fileDetails = super.findByProperty(TblFileDetail.class, propertyName, value);
        if(null != fileDetails && !fileDetails.isEmpty()) {
            super.deleteAllEntitie(fileDetails);
        }
        fileService.deleteFile(value.toString());
    }

    @Override
    public void batchSaveFileDetailBeansAndUpdateFileStatus(List<TblFileDetailBean> fileDetailBeans) {
        List<TblFileDetail> fileDetails = new ArrayList<TblFileDetail>();
        for (TblFileDetailBean fileDetailBean : fileDetailBeans) {
            TblFileDetail fileDetail = new TblFileDetail();
            BeanUtils.copyProperties(fileDetailBean, fileDetail);
            fileDetails.add(fileDetail);
        }
        super.batchSave(fileDetails);
        TblFile file = this.get(TblFile.class, fileDetailBeans.get(0).getFileId());
        file.setStatus("1");
        super.saveOrUpdate(file);
    }

    @Override
    public List<TblFileDetailBean> queryByHql(String hql, Object... param) {
        List<TblFileDetail> fileDetails = super.findHql(hql, param);
        List<TblFileDetailBean> fileDetailBeans = new ArrayList<TblFileDetailBean>();
        if (fileDetails != null && fileDetails.size() > 0) {
            for (TblFileDetail fileDetail : fileDetails) {
                TblFileDetailBean fileDetailBean = new TblFileDetailBean();
                BeanUtils.copyProperties(fileDetail, fileDetailBean);
                fileDetailBeans.add(fileDetailBean);
            }
        }
        return fileDetailBeans;
    }

    @Override
    public List<TblFileDetailBean> queryByHqlOnErrCount(String fileId, String status) {
        List<TblFileDetail> fileDetails = super.findHql("from TblFileDetail t where t.fileId = ? and t.status = ?", fileId, status);
        List<TblFileDetailBean> fileDetailBeans = new ArrayList<TblFileDetailBean>();
        if (fileDetails != null && fileDetails.size() > 0) {
            for (TblFileDetail fileDetail : fileDetails) {
                TblFileDetailBean fileDetailBean = new TblFileDetailBean();
                BeanUtils.copyProperties(fileDetail, fileDetailBean);
                fileDetailBeans.add(fileDetailBean);
            }
        }
        return fileDetailBeans;
    }
}

package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblFileBean;
import person.db.bean.TblFileDetailBean;
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
        if(!fileDetails.isEmpty()) {
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
        if(!fileDetails.isEmpty()) {
            super.deleteAllEntitie(fileDetails);
        }
        fileService.deleteFile(value.toString());
    }
}

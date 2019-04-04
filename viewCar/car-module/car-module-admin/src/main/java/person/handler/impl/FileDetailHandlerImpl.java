package person.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblFileDetailBean;
import person.handler.FileDetailHandler;
import person.service.FileDetailService;

import java.util.List;
import java.util.Map;

@Service("fileDetailHandler")
public class FileDetailHandlerImpl implements FileDetailHandler {
    @Autowired
    FileDetailService fileDetailService;

    @Override
    public List<TblFileDetailBean> findByProperty(String propertyName, Object value) {
        return fileDetailService.findByProperty(propertyName, value);
    }

    @Override
    public List<TblFileDetailBean> findByProperty2(String propertyName, Object value) {
        return fileDetailService.findByProperty2(propertyName, value);
    }

    @Override
    public void deleteAllAndFile(String propertyName, Object value) {
        fileDetailService.deleteAllAndFile(propertyName, value);
    }

    @Override
    public void batchSaveFileDetailBeansAndUpdateFileStatus(List<TblFileDetailBean> fileDetailBeans) {
        fileDetailService.batchSaveFileDetailBeansAndUpdateFileStatus(fileDetailBeans);
    }

    @Override
    public void updateFileDetailBeansAndUpdateFileStatus(List<TblFileDetailBean> fileDetailBeans) {
        fileDetailService.updateFileDetailBeansAndUpdateFileStatus(fileDetailBeans);
    }

    @Override
    public List<TblFileDetailBean> queryByHql(String hql, Object... param) {
        return fileDetailService.queryByHql(hql, param);
    }

    @Override
    public List<TblFileDetailBean> queryByHqlOnErrCount(String fileId, String status) {
        return fileDetailService.queryByHqlOnErrCount(fileId, status);
    }

    @Override
    public void batchDel(List<TblFileDetailBean> fileDetailBeans) {
        fileDetailService.batchDel(fileDetailBeans);
    }

    @Override
    public List<Map<String, Object>> findForJdbc(String sql, Object... objs) {
        return fileDetailService.findForJdbc(sql, objs);
    }
}

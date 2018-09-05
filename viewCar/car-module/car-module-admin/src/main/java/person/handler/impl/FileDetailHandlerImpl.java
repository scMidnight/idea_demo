package person.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblFileDetailBean;
import person.handler.FileDetailHandler;
import person.service.FileDetailService;

import java.util.List;

@Service("fileDetailHandler")
public class FileDetailHandlerImpl implements FileDetailHandler {
    @Autowired
    FileDetailService fileDetailService;

    @Override
    public List<TblFileDetailBean> findByProperty(String propertyName, Object value) {
        return fileDetailService.findByProperty(propertyName, value);
    }

    @Override
    public void deleteAllAndFile(String propertyName, Object value) {
        fileDetailService.deleteAllAndFile(propertyName, value);
    }
}

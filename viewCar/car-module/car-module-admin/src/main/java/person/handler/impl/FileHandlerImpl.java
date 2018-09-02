package person.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblFileBean;
import person.handler.FileHandler;
import person.service.FileService;

import java.util.List;

@Service("fileHandler")
public class FileHandlerImpl implements FileHandler {
    @Autowired
    FileService fileService;

    @Override
    public void addAttachment(TblFileBean fileBean) {
        fileService.addAttachment(fileBean);
    }

    @Override
    public void batchAddAttachment(List<TblFileBean> fileBeans) {
        fileService.batchAddAttachment(fileBeans);
    }
}

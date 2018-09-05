package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        super.save(file);
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
}

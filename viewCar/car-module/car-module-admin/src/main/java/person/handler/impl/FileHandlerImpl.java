package person.handler.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblCarSystemBean;
import person.db.bean.TblFileBean;
import person.db.entity.Page;
import person.db.entity.TblCarSystem;
import person.db.entity.TblFile;
import person.handler.FileHandler;
import person.service.FileService;

import java.util.ArrayList;
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
    public void addAttachment(TblFileBean fileBean) {
        fileService.addAttachment(fileBean);
    }

    @Override
    public void batchAddAttachment(List<TblFileBean> fileBeans) {
        fileService.batchAddAttachment(fileBeans);
    }
}

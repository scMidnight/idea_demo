package person.service;

import person.db.bean.TblFileBean;

import java.util.List;

public interface FileService extends CommonService {

    void addAttachment(TblFileBean fileBean);

    void batchAddAttachment(List<TblFileBean> fileBeans);
}

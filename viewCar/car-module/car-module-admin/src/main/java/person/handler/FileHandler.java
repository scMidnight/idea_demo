package person.handler;

import person.db.bean.TblFileBean;

import java.util.List;

public interface FileHandler {
    void addAttachment(TblFileBean fileBean);

    void batchAddAttachment(List<TblFileBean> fileBeans);
}

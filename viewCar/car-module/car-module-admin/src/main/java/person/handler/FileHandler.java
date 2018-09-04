package person.handler;

import person.db.bean.TblFileBean;
import person.db.entity.Page;

import java.util.List;
import java.util.Map;

public interface FileHandler {
    /**
     * 分页查询
     * @param page
     * @param values
     * @return
     */
    Page<TblFileBean> queryByPageFilter(Page<TblFileBean> page, String hql, Map<String, Object> values);

    void addAttachment(TblFileBean fileBean);

    void batchAddAttachment(List<TblFileBean> fileBeans);
}

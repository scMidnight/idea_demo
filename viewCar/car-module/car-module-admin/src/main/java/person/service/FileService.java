package person.service;

import person.db.bean.CarFindBean;
import person.db.bean.TblFileBean;

import java.util.List;

public interface FileService extends CommonService {

    void addAttachment(TblFileBean fileBean);

    void batchAddAttachment(List<TblFileBean> fileBeans);

    TblFileBean queryById(String id);

    /**
     * @Author SunChang
     * @Date 2018/9/5 15:09
     * @param id
     * @Description 根据ID进行删除
     */
    void deleteFile(String id);

    List<TblFileBean> queryByHql(String hql, Object... param);

    List<CarFindBean> queryByhqlFind(String hql, Object... param);

    void updateBean(TblFileBean fileBean);
}

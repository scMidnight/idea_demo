package person.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import person.db.bean.TblAreaBean;
import person.db.entity.TblArea;
import person.service.AreaService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SunChang on 2018/9/6
 */
@Service("areaService")
@Transactional
public class AreaServiceImpl extends CommonServiceImpl implements AreaService {
    @Override
    public List<TblAreaBean> queryAll() {
        List<TblArea> areas = this.loadAll(TblArea.class);
        List<TblAreaBean> areaBeans = new ArrayList<TblAreaBean>();
        if(areas != null && areas.size() > 0) {
            for (TblArea area : areas) {
                TblAreaBean areaBean = new TblAreaBean();
                BeanUtils.copyProperties(area, areaBean);
                areaBeans.add(areaBean);
            }
        }
        return areaBeans;
    }
}

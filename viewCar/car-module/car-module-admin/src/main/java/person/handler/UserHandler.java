package person.handler;

import person.db.bean.TblUserBean;

/**
 * Created by SunChang on 2018/8/22
 */
public interface UserHandler {
    TblUserBean loadByUsername(String userCode);
}

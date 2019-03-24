package person.service;

import person.db.bean.TblUserBean;

/**
 * Created by SunChang on 2018/8/22
 */
public interface UserService extends CommonService {
    TblUserBean loadByUsername(String userCode);
    void updateUserIsBlack(String userId, String isBlack);
    TblUserBean loadByUserId(String userId);
    void updateUser(TblUserBean bean);
}

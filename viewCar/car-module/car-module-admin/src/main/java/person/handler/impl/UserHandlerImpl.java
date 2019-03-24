package person.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.db.bean.TblUserBean;
import person.handler.UserHandler;
import person.service.UserService;

/**
 * Created by SunChang on 2018/8/22
 */
@Service("userHandler")
public class UserHandlerImpl implements UserHandler {

    @Autowired
    UserService userService;

    @Override
    public TblUserBean loadByUsername(String userCode) {
        return userService.loadByUsername(userCode);
    }

    @Override
    public void updateUserIsBlack(String userId, String isBlack) {
        userService.updateUserIsBlack(userId, isBlack);
    }

    @Override
    public TblUserBean loadByUserId(String userId) {
        return userService.loadByUserId(userId);
    }

    @Override
    public void updateUser(TblUserBean bean) {
        userService.updateUser(bean);
    }
}

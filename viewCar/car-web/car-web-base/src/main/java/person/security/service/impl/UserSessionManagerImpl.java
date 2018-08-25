package person.security.service.impl;

import person.model.UserDetailModel;
import person.security.service.UserSessionManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by SunChang on 2018/8/23
 */
public class UserSessionManagerImpl implements UserSessionManager {

    /**
     * 将接收到的用户信息转换为应用自己的用户类型并存入Session
     *
     * @param request
     * @param userDetailModel
     */
    @Override
    public void loadUserSession(HttpServletRequest request, UserDetailModel userDetailModel) {

    }
}

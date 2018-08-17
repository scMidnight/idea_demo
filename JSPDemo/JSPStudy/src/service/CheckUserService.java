package service;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckUserService {

    private UserDao userDao = new UserDaoImpl();

    public boolean check(User user) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            ResultSet rs = userDao.getInfo(conn, user);
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            try {
                if(conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

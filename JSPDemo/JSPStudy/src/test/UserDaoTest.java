package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoTest {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConnectionFactory.getInstance().makeConnection();
            conn.setAutoCommit(false);
            UserDao userDao = new UserDaoImpl();
            User tanke = new User();
            tanke.setName("tanke");
            tanke.setPassword("123");
            tanke.setEmail("tanke@qq.com");
            userDao.save(conn, tanke);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
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
    }
}

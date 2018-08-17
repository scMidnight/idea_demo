package dao;

import entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {

    void save(Connection conn, User user) throws SQLException;

    void update(Connection conn, Long id, User user) throws SQLException;

    void delete(Connection conn, User user) throws SQLException;

    ResultSet getInfo(Connection conn, User user) throws SQLException;

}

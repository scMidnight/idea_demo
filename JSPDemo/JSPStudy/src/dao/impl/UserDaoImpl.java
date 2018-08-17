package dao.impl;

import dao.UserDao;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(Connection conn, User user) throws SQLException {
        PreparedStatement ps = conn.prepareCall("INSERT into tbl_user(name,password,email) values(?,?,?)");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.execute();
    }

    @Override
    public void update(Connection conn, Long id, User user) throws SQLException {
        String updateSql = "update tbl_user set name = ?, password = ?, email = ? where id = ?";
        PreparedStatement ps = conn.prepareCall(updateSql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getEmail());
        ps.setLong(4, id);
        ps.execute();
    }

    @Override
    public void delete(Connection conn, User user) throws SQLException {
        String delSql = "delete from tbl_user where id = ?";
        PreparedStatement ps = conn.prepareCall(delSql);
        ps.setLong(1, user.getId());
        ps.execute();
    }

    @Override
    public ResultSet getInfo(Connection conn, User user) throws SQLException {
        PreparedStatement ps = conn.prepareCall("select * from tbl_user where name = ? and password = ?");
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        return ps.executeQuery();
    }
}

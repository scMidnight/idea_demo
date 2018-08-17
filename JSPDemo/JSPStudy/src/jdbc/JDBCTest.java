package jdbc;

import java.sql.*;

/**
 * Created by SunChang on 2018/8/17
 */
public class JDBCTest {

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/learn","root","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void insert() {
        Connection conn = getConnection();
        Statement st = null;
        try {
            String sql = "INSERT INTO tbl_user(name, password, email) values('Tom','123456','tom@gmail.com')";
            st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.println("向用户表中插入了 " + count + " 条记录。");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void update() {
        Connection conn = getConnection();
        Statement st = null;
        try {
            String sql = "update tbl_user set email = 'tom@126.com' where name = 'Tom'";
            st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.println("向用户表中更新了 " + count + " 条记录。");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete() {
        Connection conn = getConnection();
        Statement st = null;
        try {
            String sql = "delete from tbl_user where name = 'Tom'";
            st = conn.createStatement();
            int count = st.executeUpdate(sql);
            System.out.println("向用户表中删除了 " + count + " 条记录。");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //insert();
        //update();
        delete();
    }
}

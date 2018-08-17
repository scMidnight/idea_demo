package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTest {
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

    public static void insertUserData(Connection conn) throws SQLException {
        String sql = "insert into tbl_user(id,name,password,email) values(10,'Tom','123456','tom@gmail.com')";
        Statement st = conn.createStatement();
        int count = st.executeUpdate(sql);
        System.out.println("向用户表插入了 " + count + " 条记录");
        st.close();
    }
    public static void insertAddressData(Connection conn) throws SQLException {
        String sql = "insert into tbl_address(id,city,country,user_id) values(1,'shanghai','china','10')";
        Statement st = conn.createStatement();
        int count = st.executeUpdate(sql);
        System.out.println("向地址表插入了 " + count + " 条记录");
        st.close();
    }

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            insertUserData(conn);
            insertAddressData(conn);
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("捕获到异常");
            try {
                conn.rollback();
                System.out.println("事务回滚");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

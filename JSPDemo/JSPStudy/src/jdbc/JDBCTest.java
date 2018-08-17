package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by SunChang on 2018/8/17
 */
public class JDBCTest {
    public static void main(String[] args) {
        String sql = "SELECT * FROM tbl_user";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
        }
    }
}

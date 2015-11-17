package java4test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class MySQLDemo {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        String sql = null;
        int result = -1;
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");

            conn = DriverManager.getConnection(url, "root", "");
            Statement stmt = conn.createStatement();

            sql = "DROP TABLE IF EXISTS `student`";
            result = stmt.executeUpdate(sql);
            sql = "create table student(NO char(20),name varchar(20),primary key(NO)) ENGINE=InnoDB DEFAULT CHARSET=UTF8";
            result = stmt.executeUpdate(sql);

            if (result != -1) {
                System.out.println("创建数据表成功");
                sql = "insert into student(NO,name) values('2012001','abc')";
                result = stmt.executeUpdate(sql);
                sql = "insert into student(NO,name) values('2012002','测试')";
                result = stmt.executeUpdate(sql);

                sql = "select * from student";
                ResultSet rs = stmt.executeQuery(sql);
                System.out.println("学号\t姓名");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + "\t" + rs.getString(2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
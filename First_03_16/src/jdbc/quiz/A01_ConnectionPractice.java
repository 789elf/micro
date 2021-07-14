package jdbc.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class A01_ConnectionPractice {
   /*
    * ����ڷκ��� �μ���ȣ�� �Է¹����� �ش� �μ��� ��� ������� ������ ��ȸ�ؼ� �ֿܼ� ���� ���� ���
    */
   // static ��� - �ش� Ŭ������ �ѹ��̶� ��޵Ǹ� static ����� ���ʷ� �ѹ� ����
   static {
      // 1. Class.forName(driverName)���� �ش� DB���� jdbc����̹� �ε�
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("����̹� �ε� �Ϸ�");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }

   }

   static String url = "jdbc:oracle:thin:@localhost:1521/orcl";

   static Connection getConnection(String id, String password) {

      try {
         return DriverManager.getConnection(url, id, password);
      } catch (SQLException e) {
         return null;
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      String dept_no;
      System.out.println("�μ� ��ȣ > ");
      dept_no = sc.next();

      String sql = "select * from employees where department_id =" + dept_no;

      // AutoClose
      try (Connection conn = getConnection("hr", "hr");
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();) {

         ResultSetMetaData rsmd = rs.getMetaData();
         
         while (rs.next()) {
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
               System.out.printf("%15s", rs.getString(i + 1) + " | ");
            }
            System.out.println("\n");
         }

         rs.close();
         pstmt.close();
         conn.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}
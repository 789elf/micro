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
    * 사용자로부터 부서번호를 입력받으면 해당 부서의 모든 사원들의 정보를 조회해서 콘솔에 보기 좋게 출력
    */
   // static 블록 - 해당 클래스가 한번이라도 언급되면 static 블록을 최초로 한번 실행
   static {
      // 1. Class.forName(driverName)으로 해당 DB사의 jdbc드라이버 로드
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("드라이버 로드 완료");
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
      System.out.println("부서 번호 > ");
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
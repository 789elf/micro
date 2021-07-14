package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A01_JdbcConnection {
   
   /*
    *    # JDBC
    *    
    *     - Java Database Connectivity
    *   - DB에 쿼리문을 전달하여 실행하고 결과를 받아오는 Java API
    *   - 어떤 DB와도 호환할 수 있도록 설계 되어있다.
    *   - Java 부분의 소스는 어떤 DB를 사용하더라도 항상 일정하다
    *   - DB를 제작한 쪽에서 jdbc에서 요구하는 형식을 맞추어 개발하기 때문에
    *     프로그래머들은 새로운 DB도 기존의 jdbc로 편리하게 사용할 수 있다.
    *     
    *  # OJDBC
    *  
    *   - 오라클 데이터베이스가 JDBC API와 소통하기 위해 만든 라이브러리
    *   - 오라클 DB가 설치된 폴더에 포함되어 있다.
    *   
    */
   
   public static void main(String[] args) {
      
      /*
       *     ※ 어떤 DB를 사용하더라도 거쳐야 하는 절차들
       */
      
      try {
         // 1. Class.forName(driverName)으로 해당 DB사의 jdbc드라이버 로드
         Class.forName("oracle.jdbc.driver.OracleDriver");
         System.out.println("오라클 드라이버 존재");
         
         // 2. DriverManager 클래스를 통해 DB와의 연결을 생성한다.
         Connection conn = DriverManager.getConnection(
               "jdbc:oracle:thin:@localhost:1521/orcl", "hr", "hr");
         System.out.println("연결 생성됨");
         
         // 3. 생성된 연결을 통해 전송할 쿼리문 생성
         PreparedStatement pstmt = conn.prepareStatement("select * from employees");
         
         // 4. 생성된 쿼리문을 DB로 보냄
         ResultSet rs = pstmt.executeQuery();
         
         // 5. 받아온 결과를 사용
         while (rs.next()) {
            System.out.println(rs.getString("first_name") + "/" +rs.getString("salary"));
         }
         
         // 6. 사용후 연결 끊기 ( 선연후끊 )
         rs.close();
         pstmt.close();
         conn.close();
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
   }
}
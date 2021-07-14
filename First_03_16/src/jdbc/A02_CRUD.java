package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A02_CRUD {

   /*
    * JDBC에서 SELECT는 ResultSet을 반환 그 외의 DML은 적용된 행의 갯수를 반환.
    * 
    * SELECT는 PreparedStatement의 executeQuery() 메서드를 사용하고 나머지는 executeUpdate()를 사용.
    */

   public static void main(String[] args) {
      // static 블록(jdbc커넥션)을 불러오기 위해서 사용
//      try {
//         Class.forName("jdbc.quiz.A01_ConnectionPratice");
//      } catch (ClassNotFoundException e) {
//         e.printStackTrace();
//      }
      String sql = "INSERT INTO FRUITS VALUES(fruits_fid_seq.nextval,'Orange','ORANGE')";
      // INSERT INTO FRUITS VALUES ((SELECT MAX(FID) FROM FRUITS)+1,'Orange','ORANGE');
      String sql2 = "SELECT * FROM employees";
      try (Connection conn = DBConnecter.getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);

      ) {
         // INSERT, UPDATE, DELETE는 아래 메소드 사용 명령어 실행과 동시에 변화된 행의 갯수를 리턴한다.
         
         for(int i=0; i<10; i++) {
//            int rows = pstmt.executeUpdate();
//            System.out.println(rows);   
         }
         // SELECT
         ResultSet rs = pstmt2.executeQuery();
         while(rs.next()) {
            System.out.printf("%d\t%s\t%s\n",rs.getInt(1),rs.getString(2),rs.getString(3));
            
         }
         
         if (conn != null) {
            System.out.println("정답");
         } else {
            System.out.println("오답");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

}
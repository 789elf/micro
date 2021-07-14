package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class A03_JdbcTransaction {

   public static void main(String[] args) {

      String sql = "UPDATE FRUITS SET FCOLOR = 'GREEN' WHERE FNAME = 'Kiwi'";
      
      try(Connection conn = DBConnecter.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
         // JDBC로 처음 연결을 생성하면 기본적으로 AutoCommit이 활성화 되어 있다.
         // 트랜잭션을 직접 제어하기 위해서는 자동 커밋을 비활성화 해야 한다.
         // 비활성화 하더라도 Connection이 close가 될 때 커밋이 된다. 
         conn.setAutoCommit(false);
         
         int rows = pstmt.executeUpdate();
         System.out.println(rows + " 행이 업데이트 되었습니다.");
         
         conn.rollback();
      }catch(SQLException e) {
         e.printStackTrace();
      }
   }

}
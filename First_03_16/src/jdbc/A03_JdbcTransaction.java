package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class A03_JdbcTransaction {

   public static void main(String[] args) {

      String sql = "UPDATE FRUITS SET FCOLOR = 'GREEN' WHERE FNAME = 'Kiwi'";
      
      try(Connection conn = DBConnecter.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);){
         // JDBC�� ó�� ������ �����ϸ� �⺻������ AutoCommit�� Ȱ��ȭ �Ǿ� �ִ�.
         // Ʈ������� ���� �����ϱ� ���ؼ��� �ڵ� Ŀ���� ��Ȱ��ȭ �ؾ� �Ѵ�.
         // ��Ȱ��ȭ �ϴ��� Connection�� close�� �� �� Ŀ���� �ȴ�. 
         conn.setAutoCommit(false);
         
         int rows = pstmt.executeUpdate();
         System.out.println(rows + " ���� ������Ʈ �Ǿ����ϴ�.");
         
         conn.rollback();
      }catch(SQLException e) {
         e.printStackTrace();
      }
   }

}
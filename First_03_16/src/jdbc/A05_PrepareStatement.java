package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class A05_PrepareStatement {

	public static void main(String[] args) {
		// 사용자로부터 2개의 값을 입력받아 INSERT 
		String fname = "Kiwi";
		String fcolor = "purple";
		
		// 보안 취약점 (SQL Injection)
		// 변수명에 이상한 값이 들어갈수도 있고 쿼리문 작성하는게 귀찮고 직관적이지 않다.
		// String sql = "INSERT INTO EMPLOYEES VALUES(fruit_seq.nextval,)"+fname + "," + fcolor + ")";
		
		// 해결 방법    > pstmt에 준비시킬 쿼리문에 변수가 필요하다면 변수자리는 ?로 채운다,
		String sql = "INSERT INTO FRUITS VALUES(fruit_seq.nextval,?,?)";
		
		ConnectionPool pool = new ConnectionPool(10);
		
		try(Connection conn = pool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			
			// pstmt.set() 을 이용하여 ? 를 채울수 잇다. 숫자 1 은 첫번째 물음표
			pstmt.setString(1, fname);
			pstmt.setString(2, fcolor);
			
			//실행
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

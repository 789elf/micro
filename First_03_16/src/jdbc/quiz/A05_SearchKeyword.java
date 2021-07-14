package jdbc.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import jdbc.ConnectionPool;
import jdbc.DBConnecter;
class UnderLengthException extends Exception{ 
	public UnderLengthException() {
		super("두 글자 이상 입력");
	}
}
public class A05_SearchKeyword {

	/*
	 * first_name에 사용자가 입력한 내용 이 포함되어 있는 모든 사원검색 (단, 검색어는 두 글자 이상이어야 하고 두 글자 이상이
	 * 아니라면 예외가 발생해야 함)
	 */
	public static void main(String[] args) throws UnderLengthException {
		
		Scanner sc = new Scanner(System.in);
		String sql = "SELECT FIRST_NAME FROM EMPLOYEES WHERE FIRST_NAME LIKE ?";
		String first_name = "%";
		String temp = "";
		System.out.println("두글자 이상 입력 > ");
		temp = sc.next();
		
		if(temp.length() < 2) {
			throw new UnderLengthException();
		}
		first_name += temp + "%";
		
		ConnectionPool pool = new ConnectionPool(5);
		
		try(Connection conn = pool.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			pstmt.setString(1, first_name);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

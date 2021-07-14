package jdbc.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
public class A06_HikariCP {

	public static void main(String[] args) {
	
		
		HikariConfig config = new HikariConfig("hikariDB.txt");
		HikariDataSource ds = new HikariDataSource(config);
		
		String sql = "SELECT * FROM EMPLOYEES";
		try (Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
			
}

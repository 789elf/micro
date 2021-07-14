package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class A06_HikariCp {

	/*
	 *  
	 */
	public static void main(String[] args) {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/orcl");
		config.setUsername("hr");
		config.setPassword("hr");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

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

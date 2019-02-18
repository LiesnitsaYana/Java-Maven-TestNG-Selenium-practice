package task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConnectionWithDatabase {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/home_work"
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	static final String USER = "root";
	static final String PASS = "YanafoRQA28$";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(JDBC_DRIVER);

			System.out.println("Connection...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creation statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, model, type FROM photocameras_types";
			ResultSet rs = stmt.executeQuery(sql);

			List<Photocamera> photocameraList = new ArrayList<Photocamera>();

			while (rs.next()) {
				photocameraList.add(new Photocamera(rs.getInt("id"), rs.getString("model"), rs.getString("type")));
			}

			for (Photocamera f : photocameraList) {
				System.out.println(f);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		}
		System.out.println("Connection has been sucsesfuly closed.");
	}
}

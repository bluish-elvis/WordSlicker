package jp.ne.anabuki_net.slicker.saver;

import java.sql.*;

public class MySQLConnector {
	static Connection con = null;

	MySQLConnector() {
		try {
			// JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// MySQLに接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "test", "");
			System.out.println("MySQLに接続できました。");

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードに失敗しました。");
		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");
		} /*
			 * finally { if (con != null) { try { con.close(); } catch
			 * (SQLException e) { System.out.println("MySQLのクローズに失敗しました。"); } }
			 * }
			 */
	}

	public static void main(String[] args) {
		Statement stm;
		String str = "test";
		try {
			stm = con.createStatement();
			
			int getset_flag = 0;
			switch (getset_flag) {

			case 1:
				//
				str = "";
			case 2:
				//
				str = "";
			}
			
			String sql = str;

		} catch (SQLException e) {
			System.out.println("MySQLに接続できませんでした。");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("MySQLのクローズに失敗しました。");
				}
			}
		}

	}
}
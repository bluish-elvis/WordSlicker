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
		int getset_flag = 0;
		String sql = "";
		int uid = 0,
			cid = 0,
			Score = 0,
			flowless = 0,
			time = 0;
		try {

PreparedStatement ps = con.prepareStatement("select count(*) from record where UID=? and CID=?;");
	ps.setInt(1,uid);
	ps.setInt(1,cid);
		ResultSet rs = ps.executeQuery();
			getset_flag = rs.getInt(1);
			if(getset_flag>0){
				sql="update record set "
						+ "Score =? "
						+ "time =? "
						+ "flowless =?;";
				ps.setInt(10,Score);
				ps.setInt(10,time);
				ps.setInt(1,flowless);
			}else{
				sql = "insert into "
						+ "record(UID, CID, Score, time, floless) "
						+ "values(?,?,?,?,?);";
				ps.setInt(1,cid);
				ps.setInt(1,uid);
				ps.setInt(10,Score);
				ps.setInt(10,time);
				ps.setInt(1,flowless);
			};
			ps = con.prepareStatement(sql);
			ps.executeUpdate(sql);

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
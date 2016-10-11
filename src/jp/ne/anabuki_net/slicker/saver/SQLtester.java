package jp.ne.anabuki_net.slicker.saver;

import java.sql.*;

public class SQLtester{

	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		// TODO 自動生成されたメソッド・スタブ
		// Javaデータアクセスの基礎 サンプルコード(1)
		// EMP表への問合せを実行するJavaアプリケーション
		// JDBC APIをインポート
		// Oracle JDBC Driverのロード
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Oracle8iに接続
		Connection conn=
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
		// ステートメントを作成
		Statement stmt=conn.createStatement();
		// 問合せの実行
		ResultSet rset=stmt.executeQuery("select EMPNO, ENAME from EMP");
		// 問合せ結果の表示
		while(rset.next())
			// 列番号による指定
			System.out.println(rset.getInt(1)+"\t"+rset.getString(2));

		// 結果セットをクローズ
		rset.close();
		// ステートメントをクローズ
		stmt.close();
		// 接続をクローズ
		conn.close();
	}
}

package jp.ne.anabuki_net.slicker.saver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CSVreadtester{

	public static void main(String[] args){
		try{
			File csv=new File("test.csv"); // CSVデータファイル

			BufferedReader br=new BufferedReader(new FileReader(csv));

			// 最終行まで読み込む
			String line="";
			while((line=br.readLine())!=null){

				// 1行をデータの要素に分割
				StringTokenizer st=new StringTokenizer(line, ",");

				while(st.hasMoreTokens()){
					// 1行の各要素をタブ区切りで表示
					System.out.print(st.nextToken()+"\t");
				}
				System.out.println();
			}
			br.close();

		}catch(FileNotFoundException e){
			// Fileオブジェクト生成時の例外捕捉
			e.printStackTrace();
		}catch(IOException e){
			// BufferedReaderオブジェクトのクローズ時の例外捕捉
			e.printStackTrace();
		}
	}
}

package jp.csii.batch;

import java.io.*;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

import jp.csii.dto.Dto;

public class Batch {
	//localhost
		private static final String RDB_DRIVE = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost/csiisysdb2?useUnicode=true&characterEncoding=utf8";
		private static final String USER = "root";
		private static final String PASSWD = "0000";
		private Connection con = null;
		private Statement smt = null;

		public static void main(String[] args) {
			Batch batch = new Batch();
			  ArrayList<String> strPath = batch.getURLProperties("C:\\Users\\test_jp\\Downloads\\application.properties");
			  //System.out.println(strPath.size());
			  //System.out.println(strTab.get(1).length);

			  // 三個檔
			  ArrayList<String[]> strTab = batch.getDataCsvFile(strPath.get(0));

			  //strPath.get(0)   strPath.get(1)   strPath.get(2)

			  String[][] cheTab = batch.checkDate(strTab);

			  batch.insert(cheTab);

//	  	  多了兩個 其他都是null
//			  for(String [] arr: cheTab) {
//				  for(String y : arr) {
//					  System.out.println(y);
//				  }
//			  }

			  //不用 Dto, dao 塞進去？
//			  Dto dto = new Dto();
//			  dto.setName(name);
//			  System.out.println(dto.getName());

//			  Object [] ar = strTable.toArray();
//			  Arrays.asList(ar).forEach(System.out::println);

		}

		public ArrayList<String> getURLProperties(String strPath) {

			Properties prop = new Properties();
			ArrayList<String> li = new ArrayList<String>();
			String strU="";

			try {
	            InputStream inpS = new FileInputStream(strPath);
	            prop.load(inpS);

	            for(int a=0; a<prop.keySet().size(); a++) {
	            	strU = prop.getProperty("url" + a);
	                li.add(strU);
	            }
	            inpS.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  //prop.list(System.out);
		  return li;
		 }

		public ArrayList<String[]> getDataCsvFile(String strPath) {

			ArrayList<String[]> li = new ArrayList<String[]>();
			String redL = null;
			String [] ar;

			try {
				BufferedReader br = new BufferedReader(new FileReader(strPath));

				// br.readLine 是一行一行讀
				// readLine 沒有/t 不會停止
				while((redL = br.readLine()) != null){
					// 用,切出來
					ar = redL.split(",");
					// Array 要塞回去 ArrayList
					Collections.addAll(li,ar);
				}
				br.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			return li;
		}

		public String[][] checkDate(ArrayList<String[]> strTab) {
			// 目前先寫死
			int row = strTab.get(0).length;//4欄
			int line = strTab.size();//9行

			String [][] arrV = new String [line][row];
			ArrayList<String> liX = new ArrayList<String>();

			//將 ArrayList 轉成 Array
			String arr[][] = strTab.toArray(new String[0][0]);

			for(int a=0; a<arr.length; a++) {
				for(int b=0; b<arr[a].length; b++) {
					// 過濾null的欄位
					if( "".equals(arr[a][b]) || arr[a].length < row ) {
						// 對應資料, 記錄null是第幾個, index是從0開始, 所以+1, Int to String
						liX.add(String.valueOf(a+1));
						// 缺少的另外存一個推進去
						Collections.addAll(liX,arr[a]);
						//System.out.println(liX.toString());
						a += 1;  // 不滿4格  跳下一號
						b=-1;    // index 要從0開始  不然會少第一個！
					}else {
						arrV[a][b] = arr[a][b];
						//System.out.println("____________________" + arrV[a][b].toString());
					}
				}// 第二層for
			}// 外層for
			return arrV;
		}

		public void insert(String[][] cheTab){
			try {
				connect();
				con.setAutoCommit(false);

				for(int n=1; n<cheTab.length; n++) {
					// if null +1
					if(cheTab[n][0] == null || cheTab[n][1] == null || cheTab[n][2] == null || cheTab[n][3] == null ) {
						// index 從0開始-1, 最後的index也要進去-1, 所以-2
						// 長度9, index:0~8, n=7時, 不+1
						if(n != cheTab.length-2) {
							n += 1;
						}
					}else {
						String sql = "INSERT INTO customer VALUES(null, '"
								+ cheTab[n][0] + "', '" + cheTab[n][1] + "', '"
				  				+ cheTab[n][2] + "', '" + cheTab[n][3] + "')";
						smt.addBatch(sql);
					}
				}

				smt.executeBatch();

				try {
					con.commit();
				}catch(SQLException se) {
					con.rollback();
					throw se;
				}

			}catch(Exception e) {
				throw new IllegalStateException(e);
			}finally {
				disconnect();
			}
		}

		public void connect() {
			try {
				Class.forName(RDB_DRIVE);
				this.con = DriverManager.getConnection(URL, USER, PASSWD);
				this.smt = this.con.createStatement();
			}catch(Exception e){
				throw new IllegalStateException(e);
			}
		}

		public void disconnect() {
			if (this.smt != null) {
				try {
					this.smt.close();
				} catch (SQLException ignore) {}
			}
			if (this.con != null) {
				try {
					this.con.close();
				} catch (SQLException ignore) {}
			}
		}

		public int[] executeBatch() {
			try {
				return this.smt.executeBatch();
			}catch(Exception e) {
				throw new IllegalStateException(e);
			}
		}
	 
}

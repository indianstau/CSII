package bms.staff.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import bms.book.dto.Book;
import bms.common.dao.CommonDAO;
import bms.staff.dto.StaffDto;
import bms.staff.dto.StaffInsertDto;
import bms.staff.dto.StaffOptComDto;
import bms.staff.dto.StaffOptPjtDto;
import bms.staff.dto.StaffUpdateDto;

public class StaffDao extends CommonDAO{

	public ArrayList<StaffOptPjtDto> getPjtValue(){
		try {
			connect();
			String sql ="Select * from kind";
			ResultSet rs = executeQuery(sql);
			ArrayList<StaffOptPjtDto> pjtAl = new ArrayList<StaffOptPjtDto>();
			while(rs.next()) {
				StaffOptPjtDto optDto = new StaffOptPjtDto();
				optDto.setId(rs.getInt("id"));
				optDto.setPjt(rs.getString("pjt"));
				pjtAl.add(optDto);
			}
			return pjtAl;
		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			disconnect();
		}
	}

	public ArrayList<StaffOptComDto> getComValue(){
		try {
			connect();
			String sql ="Select * from syo";
			ResultSet rs = executeQuery(sql);
			ArrayList<StaffOptComDto> comAl = new ArrayList<StaffOptComDto>();
			while(rs.next()) {
				StaffOptComDto optDto = new StaffOptComDto();
				optDto.setId(rs.getInt("id"));
				optDto.setCom(rs.getString("com"));
				comAl.add(optDto);
			}
			return comAl;
		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			disconnect();
		}
	}

	public ArrayList<StaffDto> selectAll(){
		try {
			connect();
			String sql = "SELECT syain_id,NYUUSYA_DATE,TAISYA_DATE,m_sex.sex,kind.pjt,syo.com "
					+ ",CONCAT(syain_main.first_name_kanji, '',syain_main.LAST_NAME_KANJI) as name "
					+ "FROM syain_main JOIN m_sex ON syain_main.SEIBETU = m_sex.id "
					+ "JOIN kind ON syain_main.SYOKUGYO_KIND = kind.id "
					+ "JOIN syo ON syain_main.syozoku_kaisya = syo.id order by syain_id";
			ResultSet rs = executeQuery(sql);
			ArrayList<StaffDto> stfAl = new ArrayList<StaffDto>();

			while(rs.next()) {
				StaffDto stf = new StaffDto();

				stf.setSyain_id(rs.getInt("syain_id"));
				stf.setCom(rs.getString("com"));
				stf.setName(rs.getString("name"));
				stf.setSex(rs.getString("sex"));
				stf.setPjt(rs.getString("pjt"));

				stf.setNYUUSYA_DATE(rs.getDate("NYUUSYA_DATE"));
				stf.setTAISYA_DATE(rs.getDate("TAISYA_DATE"));

				stfAl.add(stf);
			}
			return stfAl;
		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			disconnect();
		}
	}

	// import 1. ArrayList 2.Staff dto 3.ut arraylist  4. rs
	public ArrayList<StaffDto> search(String name, String com, String pjt, String jstat){
		try {
			connect();

			String sql = "SELECT syain_id,NYUUSYA_DATE,TAISYA_DATE,m_sex.sex,kind.pjt,syo.com "
					+ ",CONCAT(syain_main.first_name_kanji, '',syain_main.LAST_NAME_KANJI) as name "
					+ "FROM syain_main JOIN m_sex ON syain_main.SEIBETU = m_sex.id "
					+ "JOIN kind ON syain_main.SYOKUGYO_KIND = kind.id "
					+ "JOIN syo ON syain_main.syozoku_kaisya = syo.id "
					+ "having name LIKE '%" + name + "%'";

			String comStr = " AND com = '" + com + "'";
			String pjtStr = " AND pjt = '" + pjt + "'";
			String onjStr = " AND TAISYA_DATE IS " + jstat;
			String orderStr = " ORDER BY syain_id";

			// null 判斷方式
			if(com != null) {
				//疊字串
				sql = sql + comStr;
			}
			if(pjt != null) {
				sql = sql + pjtStr;
			}
			if(jstat != null) {
				sql = sql + onjStr;
			}
			sql =  sql + orderStr;

			ResultSet rs = executeQuery(sql);
			ArrayList<StaffDto> stfAl = new ArrayList<StaffDto>();

			while(rs.next()) {
				StaffDto stf = new StaffDto();

				stf.setSyain_id(rs.getInt("syain_id"));
				stf.setCom(rs.getString("com"));
				stf.setName(rs.getString("name"));
				stf.setSex(rs.getString("sex"));
				stf.setPjt(rs.getString("pjt"));
				stf.setNYUUSYA_DATE(rs.getDate("NYUUSYA_DATE"));
				stf.setTAISYA_DATE(rs.getDate("TAISYA_DATE"));

				stfAl.add(stf);
			}
			return stfAl;
		}catch(Exception e) {
			throw new IllegalStateException(e);
		}finally {
			disconnect();
		}
	}
	public int delectById(String id) {
		try {
			connect();
			String sql  = "DELETE FROM syain_main WHERE syain_id = " + id ;
			int ext = executeUpdate(sql);
			return ext;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}finally {
			disconnect();
		}
	}

	public void insert(StaffInsertDto staffInsertDto) {
                    try {
					// DB接続
					connect();

					// 社員データを登録するSQL文を用意
					String sql = "INSERT INTO syain_main VALUES(NULL,'" + staffInsertDto.getFIRST_NAME_KANJI() + "','"
							+ staffInsertDto.getLAST_NAME_KANJI() + "','" + staffInsertDto.getFIRST_NAME_KANA() + "','" 
							+ staffInsertDto.getLAST_NAME_KANA() + "','" + staffInsertDto.getFIRST_NAME_EIGO() 
							+ "','" + staffInsertDto.getLAST_NAME_EIGO() + "','" + staffInsertDto.getSEIBETU() + "','"
							+ staffInsertDto.getTANJYOBI() + "','" + staffInsertDto.getKOKUSEKI() + "','" 
							+ staffInsertDto.getSYUSSINN() + "','" + staffInsertDto.getHAIGUSYA() + "','"
							+ staffInsertDto.getPASSPORT_NUM() + "','" + staffInsertDto.getPASSPORT_END_DATE() + "','" 
							+ staffInsertDto.getVISA_KIKAN() + "','" + staffInsertDto.getVISA_END_DATE() + "','" 
							+ staffInsertDto.getZAIRYU_SIKAKU() + "','" + staffInsertDto.getKOJIN_NUM() + "','"
							+ staffInsertDto.getZAIRYU_NUM() + "','" + staffInsertDto.getSYOZOKU_KAISYA() +"','" 
							+ staffInsertDto.getNYUUSYA_DATE() + "','" + staffInsertDto.getTAISYA_DATE() + "','" 
							+ staffInsertDto.getSYOKUGYO_KIND() + "','" + staffInsertDto.getRAINITI_DATE() + "','"
							+ staffInsertDto.getBIKOU() + "','" + staffInsertDto.getYUUBIN() + "','" 
							+ staffInsertDto.getJYUSYO_1() + "','" + staffInsertDto.getJYUSYO_2() 
							+ "','" + staffInsertDto.getMOYORI_EKI() + "','" + staffInsertDto.getTEL() 
							+ "','" + staffInsertDto.getEMAIL() + "','" + staffInsertDto.getWECHAT() + "','" 
							+ staffInsertDto.getLINE() + "','" + staffInsertDto.getBOKOKU_JYUSYO() + "','"
							+ staffInsertDto.getBOKOKU_KINNKYUU_RENNRAKU() + "','" + staffInsertDto.getSAISYUU_GAKUREKI() + "','" 
							+ staffInsertDto.getGAKKOU_NAME() + "','" + staffInsertDto.getSENNMOM_NAME() + "','" 
							+ staffInsertDto.getSOTUGYO_DATE() +"',NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)";

					// SQL文を発行
					executeUpdate(sql);

				} catch (Exception e) {
					throw new IllegalStateException(e);
				} finally {
					// DB接続解除
					disconnect();
				}

			}
	public void update(StaffUpdateDto staffUpdateDto) {
	    try {
	        // DB接続
	        connect();

	        // 社員データを更新するSQL文を用意
	        String sql = "UPDATE syain_main SET " +
	                "FIRST_NAME_KANJI = '" + staffUpdateDto.getFIRST_NAME_KANJI() + "', " +
	                "LAST_NAME_KANJI = '" + staffUpdateDto.getLAST_NAME_KANJI() + "', " +
	                "FIRST_NAME_KANA = '" + staffUpdateDto.getFIRST_NAME_KANA() + "', " +
	                "LAST_NAME_KANA = '" + staffUpdateDto.getLAST_NAME_KANA() + "', " +
	                "FIRST_NAME_EIGO = '" + staffUpdateDto.getFIRST_NAME_EIGO() + "', " +
	                "LAST_NAME_EIGO = '" + staffUpdateDto.getLAST_NAME_EIGO() + "', " +
	                "SEIBETU = '" + staffUpdateDto.getSEIBETU() + "', " +
	                "TANJYOBI = '" + staffUpdateDto.getTANJYOBI() + "', " +
	                "KOKUSEKI = '" + staffUpdateDto.getKOKUSEKI() + "', " +
	                "SYUSSINN = '" + staffUpdateDto.getSYUSSINN() + "', " +
	                "HAIGUSYA = '" + staffUpdateDto.getHAIGUSYA() + "', " +
	                "PASSPORT_NUM = '" + staffUpdateDto.getPASSPORT_NUM() + "', " +
	                "PASSPORT_END_DATE = '" + staffUpdateDto.getPASSPORT_END_DATE() + "', " +
	                "VISA_KIKAN = '" + staffUpdateDto.getVISA_KIKAN() + "', " +
	                "VISA_END_DATE = '" + staffUpdateDto.getVISA_END_DATE() + "', " +
	                "ZAIRYU_SIKAKU = '" + staffUpdateDto.getZAIRYU_SIKAKU() + "', " +
	                "KOJIN_NUM = '" + staffUpdateDto.getKOJIN_NUM() + "', " +
	                "ZAIRYU_NUM = '" + staffUpdateDto.getZAIRYU_NUM() + "', " +
	                "SYOZOKU_KAISYA = '" + staffUpdateDto.getSYOZOKU_KAISYA() + "', " +
	                "NYUUSYA_DATE = '" + staffUpdateDto.getNYUUSYA_DATE() + "', " +
	                "TAISYA_DATE = '" + staffUpdateDto.getTAISYA_DATE() + "', " +
	                "SYOKUGYO_KIND = '" + staffUpdateDto.getSYOKUGYO_KIND() + "', " +
	                "RAINITI_DATE = '" + staffUpdateDto.getRAINITI_DATE() + "', " +
	                "BIKOU = '" + staffUpdateDto.getBIKOU() + "', " +
	                "YUUBIN = '" + staffUpdateDto.getYUUBIN() + "', " +
	                "JYUSYO_1 = '" + staffUpdateDto.getJYUSYO_1() + "', " +
	                "JYUSYO_2 = '" + staffUpdateDto.getJYUSYO_2() + "', " +
	                "MOYORI_EKI = '" + staffUpdateDto.getMOYORI_EKI() + "', " +
	                "TEL = '" + staffUpdateDto.getTEL() + "', " +
	                "EMAIL = '" + staffUpdateDto.getEMAIL() + "', " +
	                "WECHAT = '" + staffUpdateDto.getWECHAT() + "', " +
	                "LINE = '" + staffUpdateDto.getLINE() + "', " +
	                "BOKOKU_JYUSYO = '" + staffUpdateDto.getBOKOKU_JYUSYO() + "', " +
	                "BOKOKU_KINNKYUU_RENNRAKU = '" + staffUpdateDto.getBOKOKU_KINNKYUU_RENNRAKU() + "', " +
	                "SAISYUU_GAKUREKI = '" + staffUpdateDto.getSAISYUU_GAKUREKI() + "', " +
	                "GAKKOU_NAME = '" + staffUpdateDto.getGAKKOU_NAME() + "', " +
	                "SENNMOM_NAME = '" + staffUpdateDto.getSENNMOM_NAME() + "', " +
	                "SOTUGYO_DATE = '" + staffUpdateDto.getSOTUGYO_DATE() + "' " +
	                "WHERE SYAIN_ID = " + staffUpdateDto.getSYAIN_ID();

	        // SQL文を発行
	        executeUpdate(sql);
	    } catch (Exception e) {
	        throw new IllegalStateException(e);
	    } finally {
	        // DB接続解除
	        disconnect();
	    }
	}

	public StaffUpdateDto selectBySyainId(String SyainId) {

		try {
			// DB接続
			connect();

			// 指定されたISBN番号の書籍データを取得するSQL文を用意
			String sql = "SELECT * FROM syain_main WHERE SYAIN_ID='" + SyainId + "'";

			// SQL文を発行し、結果セットを取得
			ResultSet rs = executeQuery(sql);

			// 書籍データ格納用のBookオブジェクトを生成
		    StaffUpdateDto staffUpdateDto = new StaffUpdateDto();

			// 結果セットから書籍データを取得
			if (rs.next()) {

				    staffUpdateDto.setSYAIN_ID(rs.getInt("SYAIN_ID"));
				    staffUpdateDto.setFIRST_NAME_KANJI(rs.getString("FIRST_NAME_KANJI"));
				    staffUpdateDto.setLAST_NAME_KANJI(rs.getString("LAST_NAME_KANJI"));
				    staffUpdateDto.setFIRST_NAME_KANA(rs.getString("FIRST_NAME_KANA"));
				    staffUpdateDto.setLAST_NAME_KANA(rs.getString("LAST_NAME_KANA"));
				    staffUpdateDto.setFIRST_NAME_EIGO(rs.getString("FIRST_NAME_EIGO"));
				    staffUpdateDto.setLAST_NAME_EIGO(rs.getString("LAST_NAME_EIGO"));
				    staffUpdateDto.setSEIBETU(rs.getInt("SEIBETU"));
				    staffUpdateDto.setTANJYOBI(rs.getDate("TANJYOBI"));
				    staffUpdateDto.setKOKUSEKI(rs.getInt("KOKUSEKI"));
				    staffUpdateDto.setSYUSSINN(rs.getString("SYUSSINN"));
				    staffUpdateDto.setHAIGUSYA(rs.getInt("HAIGUSYA"));
				    staffUpdateDto.setPASSPORT_NUM(rs.getString("PASSPORT_NUM"));
				    staffUpdateDto.setPASSPORT_END_DATE(rs.getDate("PASSPORT_END_DATE"));
				    staffUpdateDto.setVISA_KIKAN(rs.getInt("VISA_KIKAN"));
				    staffUpdateDto.setVISA_END_DATE(rs.getDate("VISA_END_DATE"));
				    staffUpdateDto.setZAIRYU_SIKAKU(rs.getInt("ZAIRYU_SIKAKU"));
				    staffUpdateDto.setKOJIN_NUM(rs.getString("KOJIN_NUM"));
				    staffUpdateDto.setZAIRYU_NUM(rs.getString("ZAIRYU_NUM"));
				    staffUpdateDto.setSYOZOKU_KAISYA(rs.getInt("SYOZOKU_KAISYA"));
				    staffUpdateDto.setNYUUSYA_DATE(rs.getDate("NYUUSYA_DATE"));
				    staffUpdateDto.setTAISYA_DATE(rs.getDate("TAISYA_DATE"));
				    staffUpdateDto.setSYOKUGYO_KIND(rs.getInt("SYOKUGYO_KIND"));
				    staffUpdateDto.setRAINITI_DATE(rs.getDate("RAINITI_DATE"));
				    staffUpdateDto.setBIKOU(rs.getString("BIKOU"));
				    staffUpdateDto.setYUUBIN(rs.getString("YUUBIN"));
				    staffUpdateDto.setJYUSYO_1(rs.getString("JYUSYO_1"));
				    staffUpdateDto.setJYUSYO_2(rs.getString("JYUSYO_2"));
				    staffUpdateDto.setMOYORI_EKI(rs.getString("MOYORI_EKI"));
				    staffUpdateDto.setTEL(rs.getString("TEL"));
				    staffUpdateDto.setEMAIL(rs.getString("EMAIL"));
				    staffUpdateDto.setWECHAT(rs.getString("WECHAT"));
				    staffUpdateDto.setLINE(rs.getString("LINE"));
				    staffUpdateDto.setBOKOKU_JYUSYO(rs.getString("BOKOKU_JYUSYO"));
				    staffUpdateDto.setBOKOKU_KINNKYUU_RENNRAKU(rs.getString("BOKOKU_KINNKYUU_RENNRAKU"));
				    staffUpdateDto.setSAISYUU_GAKUREKI(rs.getInt("SAISYUU_GAKUREKI"));
				    staffUpdateDto.setGAKKOU_NAME(rs.getString("GAKKOU_NAME"));
				    staffUpdateDto.setSENNMOM_NAME(rs.getString("SENNMOM_NAME"));
				    staffUpdateDto.setSOTUGYO_DATE(rs.getString("SOTUGYO_DATE"));
				}
			// 呼び出し元へ書籍データを返す
			return staffUpdateDto;

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			// DB接続解除
			disconnect();
		}

	}



}


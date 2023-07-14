package bms.staff.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import bms.common.dao.CommonDAO;
import bms.staff.dto.StaffDto;
import bms.staff.dto.StaffOptComDto;
import bms.staff.dto.StaffOptPjtDto;

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
			// DB SYOKUGYO_KIND,syozoku_kaisya,SEIBETU  要有值  才撈的出來 詳見DB Readme.md  
			// sql語句作了三個表的聯集  ！！！  
			String sql = "SELECT syain_id,NYUUSYA_DATE,TAISYA_DATE,m_sex.sex,kind.pjt,syo.com "
					+ ",CONCAT(syain_main.first_name_kanji, '',syain_main.LAST_NAME_KANJI) as name "
					+ "FROM syain_main JOIN m_sex ON syain_main.SEIBETU = m_sex.id "
					+ "JOIN kind ON syain_main.SYOKUGYO_KIND = kind.id "
					+ "JOIN syo ON syain_main.syozoku_kaisya = syo.id";
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
//  insert 才是staffdto  Search 是少數的聯集
	public StaffInsertDto selectById(String uid){
		try {
			String sql = "SELECT * FROM syain_main WHERE SYAIN_ID = '" + uid + "'";
			System.out.println(sql);

			ResultSet rs = executeQuery(sql);
			StaffInsertDto staff = new StaffInsertDto();
			if(rs.next()){

				staff.setFIRST_NAME_KANJI(rs.getString("FIRST_NAME_KANJI"));
				staff.setLAST_NAME_KANJI(rs.getString("LAST_NAME_KANJI"));
				staff.setFIRST_NAME_KANA(rs.getString("FIRST_NAME_KANA"));
				staff.setLAST_NAME_KANA(rs.getString("LAST_NAME_KAN"));
				staff.setFIRST_NAME_EIGO(rs.getString("FIRST_NAME_EIGO"));
				staff.setLAST_NAME_EIGO(rs.getString("LAST_NAME_EIGO"));
				staff.setSYUSSINN(rs.getString("SYUSSINN"));
				staff.setPASSPORT_NUM(rs.getString("PASSPORT_NUM"));
				staff.setKOJIN_NUM(rs.getString("KOJIN_NUM"));
				staff.setZAIRYU_NUM(rs.getString("ZAIRYU_NUM"));
				staff.setBIKOU(rs.getString("BIKOU"));
				staff.setYUUBIN(rs.getString("YUUBIN"));
				staff.setJYUSYO_1(rs.getString("JYUSYO_1"));
				staff.setJYUSYO_2(rs.getString("JYUSYO_2"));
				staff.setMOYORI_EKI(rs.getString("MOYORI_EKI"));
				staff.setTEL(rs.getString("TEL"));
				staff.setEMAIL(rs.getString("EMAIL"));
				staff.setWECHAT(rs.getString("WECHAT"));
				staff.setLINE(rs.getString("LINE"));
				staff.setGAKKOU_NAME(rs.getString("GAKKOU_NAME"));
				staff.setSENNMOM_NAME(rs.getString("SENNMOM_NAME"));
				staff.setBOKOKU_JYUSYO(rs.getString("BOKOKU_JYUSYO"));
				staff.setBOKOKU_KINNKYUU_RENNRAKU(rs.getString("BOKOKU_KINNKYUU_RENNRAKU"));

				staff.setSEIBETU(rs.getInt(""));
				staff.setKOKUSEKI(rs.getInt("KOKUSEKI"));
				staff.setHAIGUSYA(rs.getInt("HAIGUSYA"));
				staff.setVISA_KIKAN(rs.getInt("VISA_KIKAN"));
				staff.setZAIRYU_SIKAKU(rs.getInt("ZAIRYU_SIKAKU"));
				staff.setSYOZOKU_KAISYA(rs.getInt("SYOZOKU_KAISYA"));
				staff.setSYOKUGYO_KIND(rs.getInt("SYOKUGYO_KIND"));
				staff.setSAISYUU_GAKUREKI(rs.getInt("SAISYUU_GAKUREKI"));

				staff.setTANJYOBI(rs.getDate("TANJYOBI"));
				staff.setPASSPORT_END_DATE(rs.getDate("PASSPORT_END_DATE"));
				staff.setVISA_END_DATE(rs.getDate("VISA_END_DATE"));
				staff.setNYUUSYA_DATE(rs.getDate("NYUUSYA_DATE"));
				staff.setTAISYA_DATE(rs.getDate("TAISYA_DATE"));
				staff.setRAINITI_DATE(rs.getDate("RAINITI_DATE"));
				staff.setSOTUGYO_DATE(rs.getDate("SOTUGYO_DATE"));

			}
			System.out.println(staff);
			return staff;
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

}

package bms.staff.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import bms.common.dao.CommonDAO;
import bms.staff.dto.StaffDto;

public class StaffDao extends CommonDAO{
	
	public ArrayList<StaffDto> selectAll(){
		try {
			connect();
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
	
	// import 1. ArrayList 2.Staff dto 3.ut arraylist  4. rs
	public ArrayList<StaffDto> search(String name){
		try {
			connect();
			String sql = "SELECT syain_id,NYUUSYA_DATE,TAISYA_DATE,m_sex.sex,kind.pjt,syo.com "
					+ ",CONCAT(syain_main.first_name_kanji, '',syain_main.LAST_NAME_KANJI) as name "
					+ "FROM syain_main JOIN m_sex ON syain_main.SEIBETU = m_sex.id "
					+ "JOIN kind ON syain_main.SYOKUGYO_KIND = kind.id "
					+ "JOIN syo ON syain_main.syozoku_kaisya = syo.id "
					+ "having name LIKE '%" + name + "%'";
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

}

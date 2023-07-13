package bms.staff.controller;

import java.io.IOException;
import java.util.ArrayList;

import bms.staff.dao.StaffDao;
import bms.staff.dto.StaffDto;
import bms.staff.dto.StaffInsertDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *  社内統合管理システム機能に関する処理をおこなうサーブレットクラス
 */
@SuppressWarnings("serial")
public class StaffInsertServlat extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			// POST送信データの取得
			//String SYAIN_ID = request.getParameter("SYAIN_ID");
			String FIRST_NAME_KANJI = request.getParameter("FIRST_NAME_KANJI");
			String LAST_NAME_KANJI = request.getParameter("LAST_NAME_KANJI");
			String FIRST_NAME_KANA = request.getParameter("FIRST_NAME_KANA");
			String LAST_NAME_KANA = request.getParameter("LAST_NAME_KANA");
			String FIRST_NAME_EIGO = request.getParameter("FIRST_NAME_EIGO");
			String LAST_NAME_EIGO = request.getParameter("LAST_NAME_EIGO");
			String SEIBETU = request.getParameter("SEIBETU");
			String TANJYOBI = request.getParameter("TANJYOBI");
			String KOKUSEKI = request.getParameter("KOKUSEKI");
			String  SYUSSINN = request.getParameter("SYUSSINN");
			String  HAIGUSYA = request.getParameter("HAIGUSYA");
			String PASSPORT_NUM = request.getParameter("PASSPORT_NUM");
			String PASSPORT_END_DATE = request.getParameter("PASSPORT_END_DATE");
			String VISA_KIKAN = request.getParameter("VISA_KIKAN");
			String VISA_END_DATE = request.getParameter("VISA_END_DATE");
			String ZAIRYU_SIKAKU = request.getParameter("ZAIRYU_SIKAKU");
			String KOJIN_NUM = request.getParameter("KOJIN_NUM");
			String ZAIRYU_NUM = request.getParameter("ZAIRYU_NUM");
			String SYOZOKU_KAISYA = request.getParameter("SYOZOKU_KAISYA");
			String NYUUSYA_DATE = request.getParameter("NYUUSYA_DATE");
			String TAISYA_DATE = request.getParameter("TAISYA_DATE");
			String SYOKUGYO_KIND = request.getParameter("SYOKUGYO_KIND");
			String RAINITI_DATE = request.getParameter("RAINITI_DATE");
			String BIKOU = request.getParameter("BIKOU");
			String YUUBIN = request.getParameter("YUUBIN");
			String JYUSYO_1 = request.getParameter("JYUSYO_1");
			String JYUSYO_2 = request.getParameter("JYUSYO_2");
			String MOYORI_EKI = request.getParameter("MOYORI_EKI");
			String TEL = request.getParameter("TEL");
			String EMAIL = request.getParameter("EMAIL");
			String WECHAT = request.getParameter("WECHAT");
			String LINE = request.getParameter("LINE");
			String BOKOKU_JYUSYO = request.getParameter("BOKOKU_JYUSYO");
			String BOKOKU_KINNKYUU_RENNRAKU = request.getParameter("BOKOKU_KINNKYUU_RENNRAKU");
			String SAISYUU_GAKUREKI = request.getParameter("SAISYUU_GAKUREKI");
			String GAKKOU_NAME = request.getParameter("GAKKOU_NAME");
			String SENNMOM_NAME = request.getParameter("SENNMOM_NAME");
			String SOTUGYO_DATE = request.getParameter("SOTUGYO_DATE");


			// 登録処理に渡すデータをStaffInsertDtoオブジェクトに格納してまとめる

			StaffInsertDto staffInsertDto = new StaffInsertDto();


			//staffInsertDto.setSYAIN_ID(Integer.parseInt(SYAIN_ID));
			staffInsertDto.setFIRST_NAME_KANJI(FIRST_NAME_KANJI);
			staffInsertDto.setLAST_NAME_KANJI(LAST_NAME_KANJI);
			staffInsertDto.setFIRST_NAME_KANA(FIRST_NAME_KANA);
			staffInsertDto.setLAST_NAME_KANA(LAST_NAME_KANA);
			staffInsertDto.setFIRST_NAME_EIGO(FIRST_NAME_EIGO);
			staffInsertDto.setLAST_NAME_EIGO(LAST_NAME_EIGO);
			staffInsertDto.setSEIBETU(Integer.parseInt(SEIBETU));
			staffInsertDto.setTANJYOBI(java.sql.Date.valueOf(TANJYOBI));
			staffInsertDto.setKOKUSEKI(Integer.parseInt(KOKUSEKI));
			staffInsertDto.setSYUSSINN(SYUSSINN);
			staffInsertDto.setHAIGUSYA(Integer.parseInt(HAIGUSYA));
			staffInsertDto.setPASSPORT_NUM(PASSPORT_NUM);
			staffInsertDto.setPASSPORT_END_DATE(java.sql.Date.valueOf(PASSPORT_END_DATE));
			staffInsertDto.setVISA_KIKAN(Integer.parseInt(VISA_KIKAN));
			staffInsertDto.setVISA_END_DATE(java.sql.Date.valueOf(VISA_END_DATE));
			staffInsertDto.setZAIRYU_SIKAKU(Integer.parseInt(ZAIRYU_SIKAKU));
			staffInsertDto.setKOJIN_NUM(KOJIN_NUM);
			staffInsertDto.setZAIRYU_NUM(ZAIRYU_NUM);
			staffInsertDto.setSYOZOKU_KAISYA(Integer.parseInt(SYOZOKU_KAISYA));
			staffInsertDto.setNYUUSYA_DATE(java.sql.Date.valueOf(NYUUSYA_DATE));
			staffInsertDto.setTAISYA_DATE(java.sql.Date.valueOf(TAISYA_DATE));
			staffInsertDto.setSYOKUGYO_KIND(Integer.parseInt(SYOKUGYO_KIND));
			staffInsertDto.setRAINITI_DATE(java.sql.Date.valueOf(RAINITI_DATE));
			staffInsertDto.setBIKOU(BIKOU);
			staffInsertDto.setYUUBIN(YUUBIN);
			staffInsertDto.setJYUSYO_1(JYUSYO_1);
			staffInsertDto.setJYUSYO_2(JYUSYO_2);
			staffInsertDto.setMOYORI_EKI(MOYORI_EKI);
			staffInsertDto.setTEL(TEL);
			staffInsertDto.setEMAIL(EMAIL);
			staffInsertDto.setWECHAT(WECHAT);
			staffInsertDto.setLINE(LINE);
			staffInsertDto.setBOKOKU_JYUSYO(BOKOKU_JYUSYO);
			staffInsertDto.setBOKOKU_KINNKYUU_RENNRAKU(BOKOKU_KINNKYUU_RENNRAKU);
			staffInsertDto.setSAISYUU_GAKUREKI(Integer.parseInt(SAISYUU_GAKUREKI));
			staffInsertDto.setGAKKOU_NAME(GAKKOU_NAME);
			staffInsertDto.setSENNMOM_NAME(SENNMOM_NAME);
			staffInsertDto.setSOTUGYO_DATE(java.sql.Date.valueOf(SOTUGYO_DATE));


			// データベースアクセス用オブジェクトの生成
			StaffDao objDao = new StaffDao();

			// 社員データを登録する命令を呼び出す
			objDao.insert(staffInsertDto);
			System.out.println("登録成功");
			// ListServletに遷移する

			ArrayList<StaffDto> stfAl = objDao.selectAll();
			request.setAttribute("stfAl",stfAl);

			request.getRequestDispatcher("/staffSearch.jsp").forward(request, response);
		}catch(IllegalStateException le){
		request.getRequestDispatcher("/staffSearch.jsp").forward(request, response);
	}
	}
}

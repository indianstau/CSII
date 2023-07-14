package bms.staff.controller;

import java.io.IOException;
import java.util.ArrayList;

import bms.staff.dao.StaffDao;
import bms.staff.dto.StaffOptComDto;
import bms.staff.dto.StaffOptPjtDto;
import bms.staff.dto.StaffUpdateDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class StaffUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// 入力データの文字コードの指定
		request.setCharacterEncoding("UTF-8");

		// GET送信データ（ISBN番号）の取得
		String SYAIN_ID = request.getParameter("id");

		//System.out.println(SYAIN_ID);

		// データベースアクセス用オブジェクトの生成
		StaffDao objDao = new StaffDao();

		ArrayList<StaffOptComDto> comAl = objDao.getComValue();
		ArrayList<StaffOptPjtDto> pjtAl = objDao.getPjtValue();


//		request.getRequestDispatcher("/Insert.jsp").forward(request,response);

		// 指定したISBN番号の書籍データを取得する命令を呼び出し、戻り値を取得する
		StaffUpdateDto staffDto = objDao.selectBySyainId(SYAIN_ID);


		// 書籍データをリクエストスコープに格納
		request.setAttribute("keyStaff", staffDto);
		request.setAttribute("comAl",comAl);
		request.setAttribute("pjtAl",pjtAl);

		// JSPファイルに遷移する
		request.getRequestDispatcher("/update.jsp").forward(request, response);


	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// 入力データの文字コードの指定
		request.setCharacterEncoding("UTF-8");

		// POST送信データの取得
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

		// 更新処理に渡すデータをBookオブジェクトに格納してまとめる
		StaffUpdateDto staffUpdateDto = new StaffUpdateDto();


		//staffInsertDto.setSYAIN_ID(Integer.parseInt(SYAIN_ID));
		staffUpdateDto.setFIRST_NAME_KANJI(FIRST_NAME_KANJI);
		staffUpdateDto.setLAST_NAME_KANJI(LAST_NAME_KANJI);
		staffUpdateDto.setFIRST_NAME_KANA(FIRST_NAME_KANA);
		staffUpdateDto.setLAST_NAME_KANA(LAST_NAME_KANA);
		staffUpdateDto.setFIRST_NAME_EIGO(FIRST_NAME_EIGO);
		staffUpdateDto.setLAST_NAME_EIGO(LAST_NAME_EIGO);
		staffUpdateDto.setSEIBETU(Integer.parseInt(SEIBETU));
		staffUpdateDto.setTANJYOBI(java.sql.Date.valueOf(TANJYOBI));
		staffUpdateDto.setKOKUSEKI(Integer.parseInt(KOKUSEKI));
		staffUpdateDto.setSYUSSINN(SYUSSINN);
		staffUpdateDto.setHAIGUSYA(Integer.parseInt(HAIGUSYA));
		staffUpdateDto.setPASSPORT_NUM(PASSPORT_NUM);
		staffUpdateDto.setPASSPORT_END_DATE(java.sql.Date.valueOf(PASSPORT_END_DATE));
		staffUpdateDto.setVISA_KIKAN(Integer.parseInt(VISA_KIKAN));
		staffUpdateDto.setVISA_END_DATE(java.sql.Date.valueOf(VISA_END_DATE));
		staffUpdateDto.setZAIRYU_SIKAKU(Integer.parseInt(ZAIRYU_SIKAKU));
		staffUpdateDto.setKOJIN_NUM(KOJIN_NUM);
		staffUpdateDto.setZAIRYU_NUM(ZAIRYU_NUM);
		staffUpdateDto.setSYOZOKU_KAISYA(Integer.parseInt(SYOZOKU_KAISYA));
		staffUpdateDto.setNYUUSYA_DATE(java.sql.Date.valueOf(NYUUSYA_DATE));
		staffUpdateDto.setTAISYA_DATE(java.sql.Date.valueOf(TAISYA_DATE));
		staffUpdateDto.setSYOKUGYO_KIND(Integer.parseInt(SYOKUGYO_KIND));
		staffUpdateDto.setRAINITI_DATE(java.sql.Date.valueOf(RAINITI_DATE));
		staffUpdateDto.setBIKOU(BIKOU);
		staffUpdateDto.setYUUBIN(YUUBIN);
		staffUpdateDto.setJYUSYO_1(JYUSYO_1);
		staffUpdateDto.setJYUSYO_2(JYUSYO_2);
		staffUpdateDto.setMOYORI_EKI(MOYORI_EKI);
		staffUpdateDto.setTEL(TEL);
		staffUpdateDto.setEMAIL(EMAIL);
		staffUpdateDto.setWECHAT(WECHAT);
		staffUpdateDto.setLINE(LINE);
		staffUpdateDto.setBOKOKU_JYUSYO(BOKOKU_JYUSYO);
		staffUpdateDto.setBOKOKU_KINNKYUU_RENNRAKU(BOKOKU_KINNKYUU_RENNRAKU);
		staffUpdateDto.setSAISYUU_GAKUREKI(Integer.parseInt(SAISYUU_GAKUREKI));
		staffUpdateDto.setGAKKOU_NAME(GAKKOU_NAME);
		staffUpdateDto.setSENNMOM_NAME(SENNMOM_NAME);
		staffUpdateDto.setSOTUGYO_DATE(java.sql.Date.valueOf(SOTUGYO_DATE));


		// データベースアクセス用オブジェクトの生成
		StaffDao objDao = new StaffDao();

		// 書籍データを更新する命令を呼び出す
		objDao.update(staffUpdateDto);


		// ListServletに遷移する
		request.getRequestDispatcher("/staffSearcch.jsp").forward(request, response);

	}
}

package bms.staff.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import bms.staff.dao.StaffDao;
import bms.staff.dto.StaffDto;
import bms.staff.dto.StaffInsertDto;
import bms.staff.dto.StaffOptComDto;
import bms.staff.dto.StaffOptPjtDto;
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
		StaffInsertDto staffDto = objDao.selectBySyainId(SYAIN_ID);

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
		String SYAIN_ID = request.getParameter("id");
		String FIRST_NAME_KANJI = request.getParameter("FIRST_NAME_KANJI");
		String LAST_NAME_KANJI = request.getParameter("LAST_NAME_KANJI");
		String FIRST_NAME_KANA = request.getParameter("FIRST_NAME_KANA");
		String LAST_NAME_KANA = request.getParameter("LAST_NAME_KANA");
		String FIRST_NAME_EIGO = request.getParameter("FIRST_NAME_EIGO");
		String LAST_NAME_EIGO = request.getParameter("LAST_NAME_EIGO");
		String SEIBETU = request.getParameter("SEIBETU");
		String TANJYOBI = request.getParameter("TANJYOBI");
		String KOKUSEKI = request.getParameter("KOKUSEKI");
		String SYUSSINN = request.getParameter("SYUSSINN");
		String HAIGUSYA = request.getParameter("HAIGUSYA");
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
		StaffInsertDto staffIDto = new StaffInsertDto();

		staffIDto.setSYAIN_ID(Integer.parseInt(SYAIN_ID));
		staffIDto.setFIRST_NAME_KANJI(FIRST_NAME_KANJI);
		staffIDto.setLAST_NAME_KANJI(LAST_NAME_KANJI);
		staffIDto.setFIRST_NAME_KANA(FIRST_NAME_KANA);
		staffIDto.setLAST_NAME_KANA(LAST_NAME_KANA);
		staffIDto.setFIRST_NAME_EIGO(FIRST_NAME_EIGO);
		staffIDto.setLAST_NAME_EIGO(LAST_NAME_EIGO);
		staffIDto.setSEIBETU(Integer.parseInt(SEIBETU));
		staffIDto.setTANJYOBI(java.sql.Date.valueOf(TANJYOBI));
		staffIDto.setKOKUSEKI(Integer.parseInt(KOKUSEKI));
		staffIDto.setSYUSSINN(SYUSSINN);
		staffIDto.setHAIGUSYA(Integer.parseInt(HAIGUSYA));
		staffIDto.setPASSPORT_NUM(PASSPORT_NUM);
		staffIDto.setPASSPORT_END_DATE(java.sql.Date.valueOf(PASSPORT_END_DATE));
		staffIDto.setVISA_KIKAN(Integer.parseInt(VISA_KIKAN));
		staffIDto.setVISA_END_DATE(java.sql.Date.valueOf(VISA_END_DATE));
		staffIDto.setZAIRYU_SIKAKU(Integer.parseInt(ZAIRYU_SIKAKU));
		staffIDto.setKOJIN_NUM(KOJIN_NUM);
		staffIDto.setZAIRYU_NUM(ZAIRYU_NUM);
		staffIDto.setSYOZOKU_KAISYA(Integer.parseInt(SYOZOKU_KAISYA));
		staffIDto.setNYUUSYA_DATE(java.sql.Date.valueOf(NYUUSYA_DATE));
		staffIDto.setTAISYA_DATE(java.sql.Date.valueOf(TAISYA_DATE));
		staffIDto.setSYOKUGYO_KIND(Integer.parseInt(SYOKUGYO_KIND));
		staffIDto.setRAINITI_DATE(java.sql.Date.valueOf(RAINITI_DATE));
		staffIDto.setBIKOU(BIKOU);
		staffIDto.setYUUBIN(YUUBIN);
		staffIDto.setJYUSYO_1(JYUSYO_1);
		staffIDto.setJYUSYO_2(JYUSYO_2);
		staffIDto.setMOYORI_EKI(MOYORI_EKI);
		staffIDto.setTEL(TEL);
		staffIDto.setEMAIL(EMAIL);
		staffIDto.setWECHAT(WECHAT);
		staffIDto.setLINE(LINE);
		staffIDto.setBOKOKU_JYUSYO(BOKOKU_JYUSYO);
		staffIDto.setBOKOKU_KINNKYUU_RENNRAKU(BOKOKU_KINNKYUU_RENNRAKU);
		staffIDto.setSAISYUU_GAKUREKI(Integer.parseInt(SAISYUU_GAKUREKI));
		staffIDto.setGAKKOU_NAME(GAKKOU_NAME);
		staffIDto.setSENNMOM_NAME(SENNMOM_NAME);
		staffIDto.setSOTUGYO_DATE(java.sql.Date.valueOf(SOTUGYO_DATE));

		// データベースアクセス用オブジェクトの生成
		StaffDao objDao = new StaffDao();

		// 書籍データを更新する命令を呼び出す
		objDao.update(staffIDto);
		
		ArrayList<StaffDto> stfAl = objDao.selectAll();
		request.setAttribute("stfAl",stfAl);

		// ListServletに遷移する
		request.getRequestDispatcher("/staffSearch.jsp").forward(request, response);

	}
}

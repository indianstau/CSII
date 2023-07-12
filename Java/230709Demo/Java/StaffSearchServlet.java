package bms.staff.controller;

import java.io.IOException;
import java.util.ArrayList;

import bms.staff.dao.StaffDao;
import bms.staff.dto.StaffDto;
import bms.staff.dto.StaffOptComDto;
import bms.staff.dto.StaffOptPjtDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StaffSearchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//初始化,對應位置用
		int index = 0;
		String jstat = "";
		boolean flag = true;

		//1.第一次進入時   要抓到 DB 對應值  倒回 Jsp select option
		StaffDao stfDao = new StaffDao();
		ArrayList<StaffOptComDto> comAl = stfDao.getComValue();
		ArrayList<StaffOptPjtDto> pjtAl = stfDao.getPjtValue();

		//2.抓user 選的值
		String name = req.getParameter("name");
		String com = req.getParameter("com");
		String pjt = req.getParameter("pjt");
		// null 問題
		String [] jobStat = req.getParameterValues("jobstat");

		if(com != null) {
			// index -1 才是正確的位置   string to int
			index = Integer.valueOf(com).intValue() - 1;
			// 拿到對應位置的 (String) com 存回去
			com = comAl.get(index).getCom();
		}

		if(pjt != null) {
			index = Integer.valueOf(pjt).intValue()-1;
			pjt = pjtAl.get(index).getPjt();
		}

		if(jobStat != null && jobStat.length<2) {
			// 前端  0離  1在
			// DB   退社有日期為己離職   無日期還在籍
			// 2選  2不選
			if( "0".equals(jobStat[0]) ) {
				//前0 退社Not null(有值) 離
				jstat = "not Null";
			}else{
				//前1 退社isNull  在職
				jstat = "Null";
	        }
		}else {
			// 兩選  兩不選
			jstat = null;
		}
		
		ArrayList<StaffDto> stfAl = stfDao.search(name, com, pjt, jstat);

		req.setAttribute("comAl",comAl);
		req.setAttribute("pjtAl",pjtAl);
		req.setAttribute("stfAl",stfAl);
		req.getRequestDispatcher("/staffSearch.jsp").forward(req,resp);
	}
}

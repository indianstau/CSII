package bms.staff.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

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
		
		String name = req.getParameter("name");
		String com = req.getParameter("com");
		String pjt = req.getParameter("pjt");
		
		StaffDao stfDao = new StaffDao();
		ArrayList<StaffDto> stfAl = stfDao.search(name);
		ArrayList<StaffOptComDto> comAl = stfDao.getComValue();
		ArrayList<StaffOptPjtDto> pjtAl = stfDao.getPjtValue();
		
//		for(int i=0;i<sexAl.size();i++) {
//			System.out.println(sexAl.get(i).getId());
//		}

//		sexAl.forEach(System.out::println);
		
//		for(StaffOptComDto arr:comAl) {
//			System.out.print(arr.getId());
//			System.out.println(arr.getCom());
//		}

		req.setAttribute("stfAl",stfAl);
		req.setAttribute("comAl",comAl);
		req.setAttribute("pjtAl",pjtAl);
		req.getRequestDispatcher("/staffSearch.jsp").forward(req,resp);
	}
}

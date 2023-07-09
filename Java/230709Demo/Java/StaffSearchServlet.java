package bms.staff.controller;

import java.io.IOException;
import java.util.ArrayList;

import bms.staff.dao.StaffDao;
import bms.staff.dto.StaffDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StaffSearchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String path = req.getServletPath();
		
		String name = req.getParameter("name");
		String com = req.getParameter("com");
		String pjt = req.getParameter("pjt");
		
		System.out.print(name);
		
		StaffDao stfDao = new StaffDao();
		
		ArrayList<StaffDto> stfAl = stfDao.search(name);

		req.setAttribute("stfAl",stfAl);
		req.getRequestDispatcher("/staffSearch.jsp").forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String com = req.getParameter("com");
		String pjt = req.getParameter("pjt");
		
		System.out.print(com);
		
		StaffDao stfDao = new StaffDao();
		
		ArrayList<StaffDto> stfAl = stfDao.search(name);

		req.setAttribute("stfAl",stfAl);
		req.getRequestDispatcher("/staffSearch.jsp").forward(req,resp);
	}
}

package bms.staff.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bms.staff.dao.StaffDao;
import bms.staff.dto.StaffDto;

public class StaffListServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StaffDao stfDao = new StaffDao();
		
		ArrayList<StaffDto> stfAl = stfDao.selectAll();

		req.setAttribute("stfAl",stfAl);
		req.getRequestDispatcher("/staffSearch.jsp").forward(req,resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


	}


}

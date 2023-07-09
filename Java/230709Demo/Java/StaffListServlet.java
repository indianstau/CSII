package bms.staff.controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bms.staff.dao.StaffDao;
import bms.staff.dto.StaffDto;
import bms.staff.dto.StaffOptComDto;
import bms.staff.dto.StaffOptPjtDto;

public class StaffListServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StaffDao stfDao = new StaffDao();
		
		ArrayList<StaffDto> stfAl = stfDao.selectAll();
		ArrayList<StaffOptComDto> comAl = stfDao.getComValue();
		ArrayList<StaffOptPjtDto> pjtAl = stfDao.getPjtValue();
	

		req.setAttribute("stfAl",stfAl);
		req.setAttribute("comAl",comAl);
		req.setAttribute("pjtAl",pjtAl);
		req.getRequestDispatcher("/staffSearch.jsp").forward(req,resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}

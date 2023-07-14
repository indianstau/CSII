package bms.staff.controller;

import java.io.IOException;
import java.util.ArrayList;

import bms.staff.dao.StaffDao;
import bms.staff.dto.StaffInsertDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class StaffUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uid = req.getParameter("id");
		System.out.println(uid);

		StaffDao stfDao = new StaffDao();
		StaffInsertDto stfIdto = stfDao.selectById(uid);

		System.out.println(stfIdto);

		req.setAttribute("stfIdto", stfIdto);
		req.getRequestDispatcher("/staffUpdate.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}


}

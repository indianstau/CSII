package bms.staff.controller;

import java.io.IOException;

import bms.staff.dao.StaffDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StaffDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// jsp a tag 上寫id? 就是這id
		String sid = req.getParameter("id");
		System.out.print(sid);
		StaffDao stfDao = new StaffDao();

		req.getRequestDispatcher("/staffSearch.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

  }
}

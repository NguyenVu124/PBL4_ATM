package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bean.Monitoring;
import model.bo.ViewMonitoringAdminBO;

@WebServlet(urlPatterns = {"/viewListMonitoring"})

public class CtrlViewMonitoringAdmin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CtrlViewMonitoringAdmin() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account loginedUser = (Account) session.getAttribute("loginedUser");
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		if (loginedUser.getType() != 1) {
			response.sendRedirect(request.getContextPath() + "/viewMonitoring");
			return;
		}
		
		ViewMonitoringAdminBO viewMonitoringAdminBO = new ViewMonitoringAdminBO();
		List<Monitoring> list = null;
		try {
			list = viewMonitoringAdminBO.viewAllMonitoring();
		} catch (ClassNotFoundException | SQLException e) {	}
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/viewMonitoringAdminView.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkID = (String)request.getParameter("checkID");
		String inputID = "%";
		if (checkID != null) {
			inputID = inputID + (String)request.getParameter("inputID");
		}
		
		String checkDate = (String)request.getParameter("checkDate");
		String inputDate = "%";
		if (checkDate != null) {
			inputDate = (String)request.getParameter("inputDate") + inputDate;
		}
		
		String checkType = (String)request.getParameter("checkType");
		String inputType = "%";
		if (checkType != null) {
			inputType = (String)request.getParameter("inputType");
			if (inputType.equals("ALL"))
				inputType = "%";
			else
				inputType = inputType + "%";
		}
		
		ViewMonitoringAdminBO viewMonitoringAdminBO = new ViewMonitoringAdminBO();
		List<Monitoring> list = null;
		try {
			list = viewMonitoringAdminBO.viewListSearchMonitoring(inputID, inputDate, inputType);
		} catch (ClassNotFoundException | SQLException e) {	}
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/viewMonitoringAdminView.jsp");
		dispatcher.forward(request, response);
	}
	
}

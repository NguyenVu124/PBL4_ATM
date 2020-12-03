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
import model.bo.ViewMonitoringBO;

@WebServlet(urlPatterns = { "/viewMonitoring" })

public class CtrlViewMonitoring extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CtrlViewMonitoring() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account loginedUser = (Account) session.getAttribute("loginedUser");
		if (loginedUser == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		ViewMonitoringBO viewMonitoringBO = new ViewMonitoringBO();
		List<Monitoring> list = null;
		try {
			list = viewMonitoringBO.viewMonitoring(loginedUser.getID());
		} catch (ClassNotFoundException | SQLException e) {
		}

		request.setAttribute("list", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/viewMonitoringView.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}

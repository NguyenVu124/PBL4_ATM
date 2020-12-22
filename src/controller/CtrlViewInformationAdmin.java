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
import model.bean.Information;
import model.bo.ViewInformationAdminBO;

@WebServlet(urlPatterns = {"/viewListInformation"})

public class CtrlViewInformationAdmin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CtrlViewInformationAdmin() {
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
			response.sendRedirect(request.getContextPath() + "/viewInformation");
			return;
		}
		
		ViewInformationAdminBO viewInformationAdminBO = new ViewInformationAdminBO();
		List<Information> list = null;
		try {
			list = viewInformationAdminBO.viewAllInformation();
		} catch (ClassNotFoundException | SQLException e) {	}
		
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/viewInformationAdminView.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}

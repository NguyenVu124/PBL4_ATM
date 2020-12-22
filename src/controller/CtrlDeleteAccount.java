package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bo.DeleteAccountBO;

@WebServlet(urlPatterns = {"/deleteAccount"})

public class CtrlDeleteAccount extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CtrlDeleteAccount() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account loginedUser = (Account) session.getAttribute("loginedUser");
		if (loginedUser == null || loginedUser.getType() != 1) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		int ID = 0;
		try {
			ID = Integer.parseInt(request.getParameter("ID"));
		} catch (Exception e) {};
		DeleteAccountBO deleteAccountBO = new DeleteAccountBO();
		try {
			deleteAccountBO.deleteAccount(ID);
		} catch (ClassNotFoundException | SQLException e) {	}

		response.sendRedirect(request.getContextPath() + "/viewListInformation");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}

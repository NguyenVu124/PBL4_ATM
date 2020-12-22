package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.LoginBO;
import model.bean.Account;

@WebServlet(urlPatterns = {"/login"})

public class CtrlLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CtrlLogin() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/loginView.jsp");
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String error = null;
		Account account = new Account();
		
		LoginBO loginBO = new LoginBO();

		try {
			account = loginBO.checkAccountLogin(username, password);
		} catch (ClassNotFoundException | SQLException e) {}
		
		if (account != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginedUser", account);
			if (account.getType() != 1)
				response.sendRedirect(request.getContextPath() + "/viewInformation");
			else 
				response.sendRedirect(request.getContextPath() + "/viewListInformation");
		}
		
		else {
			error = "Invalid username or password";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/loginView.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}

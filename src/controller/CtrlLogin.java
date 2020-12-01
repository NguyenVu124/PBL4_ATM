package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.BO;
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
		
		error = BO.errorFormLogin(username, password);
		if (error != null) {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/loginView.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		account = BO.accountLogin(username, password);
		if (account != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginedUser", account);
			String notification = "Login successful";
			request.setAttribute("notification", notification);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/notification.jsp");
			dispatcher.forward(request, response);
		}
		
		else {
			error = "Invalid username or password";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/loginView.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}

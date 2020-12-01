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

@WebServlet(urlPatterns = {"/signup"})

public class CtrlSignup extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CtrlSignup() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/signupView.jsp");
		dispatcher.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		
		String error = null;
		error = BO.errorFormSignup(username, password, repassword);
		if (error != null) {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/signupView.jsp");
			dispatcher.forward(request, response);
			return;
		}
		
		error = BO.errorAlreadyAccount(username, password);
		if (error == null) {
			Account account = BO.insertAccount(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("loginedUser", account);
			BO.insertBalance(account.getID());
			response.sendRedirect(request.getContextPath()+"/insertInformation");
		}
		else {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/signupView.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}

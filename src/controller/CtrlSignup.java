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

import model.bean.Account;
import model.bo.SignupBO;

@WebServlet(urlPatterns = { "/signup" })

public class CtrlSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CtrlSignup() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/signupView.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");

		SignupBO signupBO = new SignupBO();
		String error = null;
		error = signupBO.errorFormSignup(username, password, repassword);
		if (error != null) {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/signupView.jsp");
			dispatcher.forward(request, response);
			return;
		}

		try {
			if (signupBO.isExistUsername(username)) {
				signupBO.insertAccount(username, password);
				Account account = signupBO.getAccountByUsername(username);
				HttpSession session = request.getSession();
				session.setAttribute("loginedUser", account);
				signupBO.insertBalance(account.getID());
				response.sendRedirect(request.getContextPath() + "/insertInformation");
			} else {
				error = "Username is already exist";
				request.setAttribute("error", error);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/signupView.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException | IOException | ServletException e) {
		}

	}
}

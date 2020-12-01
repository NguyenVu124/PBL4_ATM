package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bo.BO;

@WebServlet(urlPatterns = {"/withdrawBalance"})

public class CtrlWithdrawBalance extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CtrlWithdrawBalance() {
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

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/withdrawBalanceView.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account loginedUser = (Account) session.getAttribute("loginedUser");
	
		String input = (String)request.getParameter("input");
		int ID = loginedUser.getID();
		
		String error = BO.errorWithdrawBalance(ID, input);
		if ((error == null)) {
			float output = BO.calculateWithdraw(ID, input);
			if (output < 0) {
				error = "Not enough";
				request.setAttribute("error", error);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/withdrawBalanceView.jsp");
				dispatcher.forward(request, response);
				return;
			}
			else {
				String notification = BO.withdrawBalance(ID, output);
				BO.insertWithdrawMonitoring(ID, input);
				request.setAttribute("notification", notification);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/notification.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/withdrawBalanceView.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}

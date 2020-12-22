package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bean.Balance;
import model.bo.ViewBalanceBO;

@WebServlet(urlPatterns = {"/viewBalance"})

public class CtrlViewBalance extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CtrlViewBalance() {
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
		
		ViewBalanceBO viewBalanceBO = new ViewBalanceBO();
		Balance balance = null;
		try {
			balance = viewBalanceBO.viewBalance(loginedUser.getID());
		} catch (ClassNotFoundException | SQLException e) {	}
		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(0);
		String balanceFull = df.format(balance.getBalance());
		request.setAttribute("balance", balanceFull);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/viewBalanceView.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
}

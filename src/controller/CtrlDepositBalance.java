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
import model.bo.DepositBalanceBO;

@WebServlet(urlPatterns = { "/depositBalance" })

public class CtrlDepositBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CtrlDepositBalance() {
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

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/depositBalanceView.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account loginedUser = (Account) session.getAttribute("loginedUser");

		String input = (String) request.getParameter("input");
		int ID = loginedUser.getID();

		DepositBalanceBO depositBalanceBO = new DepositBalanceBO();

		String error = depositBalanceBO.checkErrorDeposit(input);
		if ((error == null)) {
			float output = 0;
			try {
				output = depositBalanceBO.calculateDeposit(ID, input);
				depositBalanceBO.depositBalance(ID, output);
				depositBalanceBO.insertDepositMonitoring(ID, input);
			} catch (ClassNotFoundException | SQLException e) {
			}
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/homeView.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/view/depositBalanceView.jsp");
			dispatcher.forward(request, response);
		}

	}
}

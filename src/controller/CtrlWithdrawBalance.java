package controller;

import java.io.IOException;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
//import model.bo.WithdrawBalanceBO;

@WebServlet(urlPatterns = {"/withdrawBalance"})

public class CtrlWithdrawBalance extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private Map<Integer, Object> locks = new ConcurrentHashMap<>();
	
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
//		HttpSession session = request.getSession();
//		Account loginedUser = (Account) session.getAttribute("loginedUser");
//	
//		String input = (String)request.getParameter("input");
//		int ID = loginedUser.getID();
//		
//		synchronized (locks.computeIfAbsent(ID, k -> new Object())) {
//		WithdrawBalanceBO withdrawBalanceBO = new WithdrawBalanceBO();
//			
//		String error = withdrawBalanceBO.checkErrorWithdraw(input);
//		if (error == null) {
//			float output = 0;
//			try {
//				output = withdrawBalanceBO.calculateWithdraw(ID, input);
//				try {
//					Thread.sleep(4000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (ClassNotFoundException | SQLException e) {	}
//			if (output < 0) {
//				try {
//					Thread.sleep(4000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				error = "Not enough";
//				request.setAttribute("error", error);
//				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/withdrawBalanceView.jsp");
//				dispatcher.forward(request, response);
//				return;
//			}
//			else {
//				try {
//					withdrawBalanceBO.withdrawBalance(ID, output);
//					try {
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//						withdrawBalanceBO.insertWithdrawMonitoring(ID, input);
//					} catch (ClassNotFoundException | SQLException e) {	}
//					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/homeView.jsp");
//					dispatcher.forward(request, response);
//				}
//			}
//			else {
//				request.setAttribute("error", error);
//				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/withdrawBalanceView.jsp");
//				dispatcher.forward(request, response);
//			}
//		}
	}
}

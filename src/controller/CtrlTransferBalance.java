package controller;

import java.io.IOException;
//import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
//import model.bo.TransferBalanceBO;

@WebServlet(urlPatterns = {"/transferBalance"})

public class CtrlTransferBalance extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public CtrlTransferBalance() {
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

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/transferBalanceView.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Account loginedUser = (Account) session.getAttribute("loginedUser");
//	
//		String input = (String)request.getParameter("input");
//		int senderID = loginedUser.getID();
//		int receiverID = Integer.parseInt(request.getParameter("receiverID"));
//		
//		TransferBalanceBO transferBalanceBO = new TransferBalanceBO();
//		
//		String error = transferBalanceBO.checkFormTransferBalance(senderID, input);
//		if ((error == null)) {			
//			error = transferBalanceBO.checkTransfer(senderID, receiverID, input);
//			if (error != null) {
//				request.setAttribute("error", error);
//				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/transferBalanceView.jsp");
//				dispatcher.forward(request, response);
//				return;
//			}
//			else {
//				try {
//					transferBalanceBO.transferBalance(senderID, receiverID, input);
//				} catch (ClassNotFoundException | SQLException e) {	}
//				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/homeView.jsp");
//				dispatcher.forward(request, response);
//			}
//		}
//		else {
//			request.setAttribute("error", error);
//			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/transferBalanceView.jsp");
//			dispatcher.forward(request, response);
//		}
//		
	}
}

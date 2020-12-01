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
		HttpSession session = request.getSession();
		Account loginedUser = (Account) session.getAttribute("loginedUser");
	
		String input = (String)request.getParameter("input");
		int senderID = loginedUser.getID();
		int receiverID = Integer.parseInt(request.getParameter("receiverID"));
		
		String error = BO.errorWithdrawBalance(senderID, input);
		if ((error == null)) {			
			error = BO.checkTransfer(senderID, receiverID, input);
			if (error != null) {
				request.setAttribute("error", error);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/transferBalanceView.jsp");
				dispatcher.forward(request, response);
				return;
			}
			else {
				String notification = BO.transferBalance(senderID, receiverID, input);
				request.setAttribute("notification", notification);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/notification.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/transferBalanceView.jsp");
			dispatcher.forward(request, response);
		}
		
	}
}

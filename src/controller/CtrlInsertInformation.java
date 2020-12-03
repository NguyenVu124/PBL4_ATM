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
import model.bean.Information;
import model.bo.InsertInformationBO;

@WebServlet(urlPatterns = { "/insertInformation" })

public class CtrlInsertInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CtrlInsertInformation() {
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

		request.setAttribute("ID", loginedUser.getID());
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/insertInformationView.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account loginedUser = (Account) session.getAttribute("loginedUser");

		int ID = loginedUser.getID();
		String name = (String) request.getParameter("name");
		String phone = (String) request.getParameter("phone");
		String gender = (String) request.getParameter("gender");
		String birth = (String) request.getParameter("birth");
		String email = (String) request.getParameter("email");
		String identitynumber = (String) request.getParameter("identitynumber");

		InsertInformationBO insertInformationBO = new InsertInformationBO();

		Information infor = new Information(ID, name, phone, gender, birth, email, identitynumber);
		String error = insertInformationBO.checkFormUpdateInformation(infor);
		if ((error == null)) {
			try {
				insertInformationBO.insertInformation(infor);
			} catch (ClassNotFoundException | SQLException e) {
			}
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/homeView.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", error);
			request.setAttribute("infor", infor);
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/view/insertInformationView.jsp");
			dispatcher.forward(request, response);
		}

	}
}

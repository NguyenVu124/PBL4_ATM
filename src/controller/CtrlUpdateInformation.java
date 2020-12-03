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
import model.bo.UpdateInformationBO;

@WebServlet(urlPatterns = { "/updateInformation" })

public class CtrlUpdateInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CtrlUpdateInformation() {
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
		UpdateInformationBO updateInformationBO = new UpdateInformationBO();
		Information infor = null;
		try {
			infor = updateInformationBO.viewInformation(loginedUser.getID());
		} catch (ClassNotFoundException | SQLException e) {
		}
		request.setAttribute("infor", infor);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/updateInformationView.jsp");
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

		Information infor = new Information(ID, name, phone, gender, birth, email, identitynumber);
		UpdateInformationBO updateInformationBO = new UpdateInformationBO();
		String error = updateInformationBO.checkFormUpdateInformation(infor);
		if ((error == null)) {
			try {
				updateInformationBO.updateInformation(infor);
			} catch (ClassNotFoundException | SQLException e) {
			}

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/homeView.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("error", error);
			request.setAttribute("infor", infor);
			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/view/updateInformationView.jsp");
			dispatcher.forward(request, response);
		}

	}
}

package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bo.DepositBalanceBO;
import model.bo.TransferBalanceBO;
import model.bo.WithdrawBalanceBO;

@WebServlet(urlPatterns = {"/updateBalance"})

public class CtrlUpdateBalance extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Map<Integer, Object> locks = new ConcurrentHashMap<>();
	
	public CtrlUpdateBalance() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account loginedUser = (Account) session.getAttribute("loginedUser");
	
		String func = (String)request.getParameter("func");
		int ID = loginedUser.getID();
		int receiverID = 0;
		try {
			receiverID = Integer.parseInt(request.getParameter("receiverID"));
		} catch (Exception e) {}
		
		String input = (String)request.getParameter("input");
		
		if (func.equals("withdraw")) {
			synchronized (locks.computeIfAbsent(ID, k -> new Object())) {
				WithdrawBalanceBO withdrawBalanceBO = new WithdrawBalanceBO();
					
				String error = withdrawBalanceBO.checkErrorWithdraw(input);
				if (error == null) {
					float output = 0;
					try {
						output = withdrawBalanceBO.calculateWithdraw(ID, input);
//						try {
//							Thread.sleep(3000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					} catch (ClassNotFoundException | SQLException e) {	}
					if (output < 0) {
//						try {
//							Thread.sleep(3000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						error = "Not enough";
						request.setAttribute("error", error);
						RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/withdrawBalanceView.jsp");
						dispatcher.forward(request, response);
						return;
					}
					else {
						try {
							withdrawBalanceBO.withdrawBalance(ID, output);
//							try {
//								Thread.sleep(3000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
								withdrawBalanceBO.insertWithdrawMonitoring(ID, input);
							} catch (ClassNotFoundException | SQLException e) {	}
						response.sendRedirect(request.getContextPath() + "/viewBalance");
					}
					}
				else {
					request.setAttribute("error", error);
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/withdrawBalanceView.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
		
		if (func.equals("deposit")) {
			synchronized (locks.computeIfAbsent(ID, k -> new Object())) {
				DepositBalanceBO depositBalanceBO = new DepositBalanceBO();
				
				String error = depositBalanceBO.checkErrorDeposit(input);
				if ((error == null)) {
					float output = 0;
					try {
						output = depositBalanceBO.calculateDeposit(ID, input);
//						try {
//							Thread.sleep(3000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						depositBalanceBO.depositBalance(ID, output);
//						try {
//							Thread.sleep(3000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						depositBalanceBO.insertDepositMonitoring(ID, input);
					} catch (ClassNotFoundException | SQLException e) {	}
					response.sendRedirect(request.getContextPath() + "/viewBalance");
				}
				else {
					request.setAttribute("error", error);
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/depositBalanceView.jsp");
					dispatcher.forward(request, response);
				}
			}
		}
		
		if (func.equals("transfer")) {
			TransferBalanceBO transferBalanceBO = new TransferBalanceBO();
			
			String error = transferBalanceBO.checkFormTransferBalance(input);
			if ((error == null)) {			
				error = transferBalanceBO.checkReceiverID(loginedUser.getID(), receiverID);
				if (error == null) {
					synchronized (locks.computeIfAbsent(ID, k -> new Object())) {
						WithdrawBalanceBO withdrawBalanceBO = new WithdrawBalanceBO();
						float output = 0;
						try {
							output = withdrawBalanceBO.calculateWithdraw(ID, input);
//							try {
//								Thread.sleep(3000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
						} catch (ClassNotFoundException | SQLException e) {	}
						if (output < 0) {
//							try {
//								Thread.sleep(3000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
							error = "Not enough";
							request.setAttribute("error", error);
							RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/transferBalanceView.jsp");
							dispatcher.forward(request, response);
							return;
						}
						else {
							try {
								withdrawBalanceBO.withdrawBalance(ID, output);
//								try {
//									Thread.sleep(3000);
//								} catch (InterruptedException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
								transferBalanceBO.insertWTransferMonitoring(receiverID, loginedUser.getID(), input);
							} catch (ClassNotFoundException | SQLException e) {	}
						}
						
					}
					
					synchronized (locks.computeIfAbsent(receiverID, k -> new Object())) {
						DepositBalanceBO depositBalanceBO = new DepositBalanceBO();
						float output = 0;
						try {
							output = depositBalanceBO.calculateDeposit(receiverID, input);
//							try {
//								Thread.sleep(3000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
							depositBalanceBO.depositBalance(receiverID, output);
//							try {
//								Thread.sleep(3000);
//							} catch (InterruptedException e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//							}
							transferBalanceBO.insertDTransferMonitoring(ID, receiverID, input);
						} catch (ClassNotFoundException | SQLException e) {	}
						response.sendRedirect(request.getContextPath() + "/viewBalance");
					}
				}
				else {
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					request.setAttribute("error", error);
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/transferBalanceView.jsp");
					dispatcher.forward(request, response);
					return;
				}
			}
	
			else {
				request.setAttribute("error", error);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/transferBalanceView.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	}
}

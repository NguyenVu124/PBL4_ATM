package model.bo;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import model.dao.TransferBalanceDAO;

public class TransferBalanceBO {
	TransferBalanceDAO transferBalanceDAO = new TransferBalanceDAO();
	
	public String checkFormTransferBalance(int _ID, String _input) {
		String error = "Input must be positive float number";
		float input = 0;
		try {
			input = Float.parseFloat(_input);
		} catch (Exception e) {
			return error;
		}
		if (input<=1000)
			return "Input number > 1000";
		return null;
	}
	
	public String checkTransfer(int _senderID, int _receiverID, String _input) {
		try {
			float input = Float.parseFloat(_input);
			float balance = transferBalanceDAO.getBalance(_senderID).getBalance();
			if (input > balance) {
				return "Not enough";
			}
			List<Integer> list = transferBalanceDAO.getListID();
			for (int item : list) {
				if (item ==_receiverID) {
					return null;
				}
			} 
		} catch (Exception e) {}
		return "Invalid ID";
	}
	
	public void transferBalance(int _senderID, int _receiverID, String _input) throws SQLException, ClassNotFoundException {
		float input = 0;
		try {
			input = Float.parseFloat(_input);
		} catch (Exception e) {}
		
		float _sBalance = transferBalanceDAO.getBalance(_senderID).getBalance() - input;
		float _rBalance = transferBalanceDAO.getBalance(_receiverID).getBalance() + input;
		String currentTime = LocalDateTime.now().toString();
		String date = currentTime.substring(0, 10);
		String time = currentTime.substring(11, 19);
		String _sTime = date + " " + time;
		String _sDes = "- " + _input + " VND";
		String _rTime = date + " " + time;
		String _rDes = "+ " + _input + " VND";
		try {
			transferBalanceDAO.transferBalance(_senderID, _receiverID, _sBalance, _rBalance, _sDes, _rDes, _sTime, _rTime);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

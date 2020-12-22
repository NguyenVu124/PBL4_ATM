package model.bo;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import model.bean.Monitoring;
import model.dao.TransferBalanceDAO;

public class TransferBalanceBO {
	TransferBalanceDAO transferBalanceDAO = new TransferBalanceDAO();
	
	public String checkFormTransferBalance(String _input) {
		String error = "Input must be a positive number";
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
	
	public String checkReceiverID(int _ID, int _receiverID) {
		try {
			List<Integer> list = transferBalanceDAO.getListID(_ID);
			for (int item : list) {
				if (item == _receiverID) {
					return null;
				}
			} 
		} catch (Exception e) {}
		return "Invalid ID";
	}
	
	public void insertWTransferMonitoring(int _receiverID, int _ID, String _input) throws ClassNotFoundException, SQLException {
		String currentTime = LocalDateTime.now().toString();
		String date = currentTime.substring(0, 10);
		String time = currentTime.substring(11, 19);
		String _time = date + " " + time;
		String _description = "- " + _input + " VND";
		String _type = "Transfer To " + _receiverID;
		Monitoring monitoring = new Monitoring(_ID, _time, _description, _type);
		transferBalanceDAO.insertWMonitoring(monitoring);	
	}
	
	public void insertDTransferMonitoring(int _senderID, int _ID, String _input) throws ClassNotFoundException, SQLException {
		String currentTime = LocalDateTime.now().toString();
		String date = currentTime.substring(0, 10);
		String time = currentTime.substring(11, 19);
		String _time = date + " " + time;
		String _description = "+ " + _input + " VND";
		String _type = "Transfer From " + _senderID;
		Monitoring monitoring = new Monitoring(_ID, _time, _description, _type);
		transferBalanceDAO.insertDMonitoring(monitoring);	
	}
}

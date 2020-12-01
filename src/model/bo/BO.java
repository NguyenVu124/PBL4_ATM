package model.bo;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import model.bean.Account;
import model.bean.Balance;
import model.bean.Information;
import model.bean.Monitoring;
import model.dao.DAO;

public class BO {
	public static String errorFormLogin(String _username, String _password) {
		if (_username.equals("") || (_password.equals("")))
			return "Fill in all fields";
		else 
			return null;
	}
	
	public static Account accountLogin(String _username, String _password) {
		Account account = new Account();
		try {
			account = DAO.accountLogin(_username, _password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (account != null && (account.getUsername().equals(_username) && (account.getPassword().equals(_password)))) {
			return account;
		}
		else 
			return null;
	}
	
	public static String errorFormSignup(String _username, String _password, String _repassword) {
		if (_username.equals("") || _password.equals("") || _repassword.equals("")) {
			return "Fill in all fields";
		}
		if (!(_password.equals(_repassword))) {
			return "Password and repassword do not match";
		}
		return null;
	}
	
	public static String errorAlreadyAccount(String _username, String _password) {
		List<String> list = null;
		try {
			list = DAO.listUsername();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (String item : list) {
			if (item.equals(_username)) {
				return "Username is already existed";
			}
		}
		return null;
	}
	
	public static Account accountFromUsername(String _username) {
		Account account = new Account();
		try {
			account = DAO.accountFromUsername(_username);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public static Account insertAccount(String _username, String _password) {
		Account account = new Account();
		try {
			DAO.insertAccount(_username, _password);
			account = BO.accountFromUsername(_username);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public static void insertBalance(int _ID) {
		try {
			DAO.insertBalance(_ID);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static String errorFormUpdateInformation(Information _infor) {
		String error = null;
		String regex = "\\d+";
		if (_infor.getName().equals("") || _infor.getGender().equals("") || _infor.getEmail().equals("") || _infor.getBirth().equals("")) {
			return "Fill in all fields";
		}
		if (!(_infor.getIdentitynumber().matches(regex))) {
			return "Invalid identity number";
		}
		if (!(_infor.getPhone().matches(regex))) {
			return "Invalid phone";
		}
		return error;
	}
	
	public static String updateInformation(Information _infor) {
		try {
			DAO.updateInformation(_infor);
			return "Update Successful";
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String insertInformation(Information _infor) {
		try {
			DAO.insertInformation(_infor);
			return "Insert Successful";
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Information viewInformation(int _ID) {
		Information infor = new Information();
		try {
			infor = DAO.viewInformation(_ID);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return infor;
	}
	
	public static Balance viewBalance(int _ID) {
		Balance balance = new Balance();
		try {
			balance = DAO.viewBalance(_ID);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return balance;
	}
	
	public static List<Monitoring> viewMonitoring(int _ID) {
		List<Monitoring> list = null;
		try {
			list = DAO.viewMonitoring(_ID);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String deleteAccount(int _ID) {
		String notification = "";
		try {
			DAO.deleteAccount(_ID);
			notification = "Your account has been deleted";
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			notification = "Erorr";
		}
		return notification;
	}
	
	public static String errorDepositBalance(int _ID, String _input) {
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
	
	public static String errorWithdrawBalance(int _ID, String _input) {
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
	
	public static float calculateDeposit(int _ID, String _input) {
		Balance balance = new Balance();
		float realBalance = 0;
		float output = 0;
		float input = 0;
		try {
			input = Float.parseFloat(_input);
			balance = DAO.viewBalance(_ID);
			realBalance = balance.getBalance();
			output = realBalance + input;
		} catch (Exception e) {}
		return output;
	}
	
	public static float calculateWithdraw(int _ID, String _input) {
		Balance balance = new Balance();
		float realBalance = 0;
		float output = 0;
		float input = 0;
		try {
			input = Float.parseFloat(_input);
			balance = DAO.viewBalance(_ID);
			realBalance = balance.getBalance();
			output = realBalance - input;
		} catch (Exception e) {}
		return output;
	}
	
	public static String depositBalance(int _ID, float _output) {
		try {
			DAO.depositBalance(_ID, _output);
			return "Update Successful";
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String withdrawBalance(int _ID, float _output) {
		try {
			DAO.withdrawBalance(_ID, _output);
			return "Update Successful";
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void insertDepositMonitoring(int _ID, String _input) {
		String currentTime = LocalDateTime.now().toString();
		String date = currentTime.substring(0, 10);
		String time = currentTime.substring(11, 19);
		String _time = date + " " + time;
		String _description = "+ " + _input + " VND";
		Monitoring monitoring = new Monitoring(_ID, _time, _description);
		try {
			DAO.insertMonitoring(monitoring);;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void insertWithdrawMonitoring(int _ID, String _input) {
		String currentTime = LocalDateTime.now().toString();
		String date = currentTime.substring(0, 10);
		String time = currentTime.substring(11, 19);
		String _time = date + " " + time;
		String _description = "- " + _input + " VND";
		Monitoring monitoring = new Monitoring(_ID, _time, _description);
		try {
			DAO.insertMonitoring(monitoring);;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static String checkTransfer(int _senderID, int _receiverID, String _input) {
		try {
			float input = Float.parseFloat(_input);
			float balance = DAO.viewBalance(_senderID).getBalance();
			if (input > balance) {
				return "Not enough";
			}
			List<Integer> list = DAO.listID();
			for (int item : list) {
				if (item ==_receiverID) {
					return null;
				}
			} 
		} catch (Exception e) {}
		return "Invalid ID";
	}
	
	public static String transferBalance(int _senderID, int _receiverID, String _input){
		float input = 0;
		try {
			input = Float.parseFloat(_input);
		} catch (Exception e) {}
		List<Float> list = null;;
		try {
			list = DAO.getBalance(_senderID, _receiverID);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		float _sBalance = list.get(0) - input;
		float _rBalance = list.get(1) + input;
		String currentTime = LocalDateTime.now().toString();
		String date = currentTime.substring(0, 10);
		String time = currentTime.substring(11, 19);
		String _sTime = date + " " + time;
		String _sDes = "- " + _input + " VND";
		String _rTime = date + " " + time;
		String _rDes = "+ " + _input + " VND";
		try {
			DAO.transferBalance(_senderID, _receiverID, _sBalance, _rBalance, _sDes, _rDes, _sTime, _rTime);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "Update Succesful";
	}
}

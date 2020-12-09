package model.bo;

import java.sql.SQLException;
import java.time.LocalDateTime;

import model.bean.Balance;
import model.bean.Monitoring;
import model.dao.WithdrawBalanceDAO;

public class WithdrawBalanceBO {
	WithdrawBalanceDAO withdrawBalanceDAO = new WithdrawBalanceDAO();

	public String checkErrorWithdraw(String _input) {
		String error = "Input must be positive float number";
		float input = 0;
		try {
			input = Float.parseFloat(_input);
		} catch (Exception e) {
			return error;
		}
		if (input <= 1000)
			return "Input number > 1000";
		return null;
	}

	public float calculateWithdraw(int _ID, String _input) throws ClassNotFoundException, SQLException {
		Balance balance = new Balance();
		float realBalance = 0;
		float output = 0;
		float input = 0;
		try {
			input = Float.parseFloat(_input);
			balance = withdrawBalanceDAO.getBalance(_ID);
			realBalance = balance.getBalance();
			output = realBalance - input;
		} catch (Exception e) {
		}
		return output;
	}

	public void withdrawBalance(int _ID, float _output) throws ClassNotFoundException, SQLException {
		withdrawBalanceDAO.withdrawBalance(_ID, _output);
	}

	public void insertWithdrawMonitoring(int _ID, String _input) throws ClassNotFoundException, SQLException {
		String currentTime = LocalDateTime.now().toString();
		String date = currentTime.substring(0, 10);
		String time = currentTime.substring(11, 19);
		String _time = date + " " + time;
		String _description = "- " + _input + " VND";
		Monitoring monitoring = new Monitoring(_ID, _time, _description);
		withdrawBalanceDAO.insertMonitoring(monitoring);
	}
}

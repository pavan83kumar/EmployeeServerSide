package com.service;

import java.sql.SQLException;
import java.util.List;

import com.daoImpl.BonusDaoImpl;
import com.entities.Bonus;

public class BonusService {
	BonusDaoImpl bonusDAO = new BonusDaoImpl();

	public void loadBonus(List<Bonus> bonus) throws SQLException {
		bonusDAO.loadBonus(bonus);

	}

	public List<Bonus> getAllBonus() throws SQLException {

		return bonusDAO.getAllBonus();
	}

	public int getRemainingAmount(int deptNo) throws SQLException {
		return bonusDAO.getRemainingAmount(deptNo);
	}

	public void setRemainingAmount(int remaining, int deptNo) throws SQLException {
		bonusDAO.setRemainingAmount(remaining, deptNo);
	}

}

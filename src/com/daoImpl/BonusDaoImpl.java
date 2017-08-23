package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.connection.ConnectionFactory;
import com.entities.Bonus;

public class BonusDaoImpl {
	
	final static Logger logger=Logger.getLogger(BonusDaoImpl.class);

	public void loadBonus(List<Bonus> bonus) throws SQLException {
		// Loading Bonus data from file to database.
		try (Connection con = ConnectionFactory.getConnection();
				Statement s = con.createStatement();
				PreparedStatement stmt = con.prepareStatement("insert into bonus values(?,?,?)")) {
			s.execute("truncate bonus");
			for (int i = 0; i < bonus.size(); i++) {
				stmt.setInt(1, bonus.get(i).getDeptNo());
				stmt.setInt(2, bonus.get(i).getAmount());
				stmt.setInt(3, bonus.get(i).getRemainingAmount());
				stmt.executeUpdate();
			}

		}

	}

	public List<Bonus> getAllBonus() throws SQLException {

		List<Bonus> bonusList = new ArrayList<>();

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con.prepareStatement("select * from bonus")) {

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				int num = rs.getInt(1);
				int amount = rs.getInt(2);
				int remainingAmount = rs.getInt(3);
				bonusList.add(new Bonus(num, amount, remainingAmount));

			}

		}
		return bonusList;
	}

	public int getRemainingAmount(int deptNo) throws SQLException {
		int balance = 0;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con.prepareStatement("select remainingAmount from bonus where deptNo =?")) {
			stmt.setInt(1, deptNo);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				balance = rs.getInt(1);
			}
			return balance;

		}

	}

	public void setRemainingAmount(int remaining, int deptNo) throws SQLException {

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con
						.prepareStatement("update bonus set remainingAmount = ? where deptNo = ?")) {
			stmt.setInt(1, remaining);
			stmt.setInt(2, deptNo);
			stmt.executeUpdate();

		}

	}

}

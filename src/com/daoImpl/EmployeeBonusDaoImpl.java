package com.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.connection.ConnectionFactory;
import com.entities.EmployeeBonus;

public class EmployeeBonusDaoImpl {
	
	final static Logger logger=Logger.getLogger(EmployeeBonusDaoImpl.class);
	
	public void setBonus(EmployeeBonus bonus) throws SQLException{
		logger.info("Setting the bonus to the Database");
		
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con
						.prepareStatement("insert into employeebonus values(?,?,?,?)")) {
			stmt.setInt(1, bonus.getNumber());
			stmt.setString(2, bonus.getStatus());
			stmt.setInt(3,bonus.getAmount());
			stmt.setDate(4, new Date(bonus.getDataAllocated().getTime()));
			stmt.executeUpdate	();
			
		}
	}

}

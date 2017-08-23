package com.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.connection.ConnectionFactory;
import com.entities.Employee;

public class EmployeeDaoImpl {
	
	final static Logger logger=Logger.getLogger(EmployeeDaoImpl.class);

	public void loadEmployee(List<Employee> employee) throws SQLException {
		
		

		// Loading employee data from file to database.
		try (Connection con = ConnectionFactory.getConnection(); Statement s = con.createStatement();
				PreparedStatement stmt = con.prepareStatement("insert into employee values(?,?,?,?,?,?)")) {
			//con.setAutoCommit(false);
			s.execute("truncate employee");

			for (Employee emp : employee) {
				stmt.setInt(1, emp.getNumber());
				stmt.setInt(2, emp.getDeptNumber());
				stmt.setDate(3, new Date(emp.getDoJ().getTime()));
				stmt.setDate(4, new Date(emp.getDoB().getTime()));
				stmt.setInt(5, emp.getSalary());
				stmt.setInt(6, emp.getSalGrade());
				stmt.executeUpdate();

			}
		}

	}

	public List<Employee> getEmployees(int deptNo, String type) throws SQLException {

		List<Employee> empList = new ArrayList<Employee>();

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con
						.prepareStatement("select * from employee where deptNo = ? order by " + type)) {
			stmt.setInt(1, deptNo);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				empList.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5),
						rs.getInt(6)));
			}
		}
		return empList;

	}

}

package com.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connection.ConnectionFactory;
import com.entities.Employee;

public class DepartmentDaoImpl {
	Employee emp;

	public Employee getEmployee(int empId) {
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con.prepareStatement("select * from employee where empNo = ?")) {
			stmt.setInt(1, empId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				emp = new Employee(empId, rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;

	}

	public List<Employee> getEmployeesByDeptId(int deptId) {
		List<Employee> empList = new ArrayList<>();
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stmt = con.prepareStatement("select * from employee where deptNo = ?")) {
			stmt.setInt(1, deptId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				empList.add(
						new Employee(rs.getInt(1), deptId, rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;

	}
}

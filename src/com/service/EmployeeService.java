package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daoImpl.EmployeeDaoImpl;
import com.entities.Employee;

public class EmployeeService {

	EmployeeDaoImpl employeeDAO = new EmployeeDaoImpl();

	public void loadEmployee(List<Employee> employee) throws SQLException {

		employeeDAO.loadEmployee(employee);

	}
	
	public List<Employee> getEmployees(int deptNo) throws SQLException{
		
		List<Employee> emp = new ArrayList<>();
		if(deptNo %2 == 0){
			emp = employeeDAO.getEmployees(deptNo,"DoB");
		}
		else{
			emp = employeeDAO.getEmployees(deptNo, "DoJ");
		}
		return emp;
	}
}

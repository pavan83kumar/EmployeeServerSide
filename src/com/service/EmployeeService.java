package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daoImpl.EmployeeDaoImpl;
import com.entities.Department;
import com.entities.Employee;
import com.util.Credentials;
import com.util.EmployeeUtil;

public class EmployeeService {

	EmployeeDaoImpl employeeDAO = new EmployeeDaoImpl();

	public void loadEmployee(List<Employee> employee) throws SQLException {

		employeeDAO.loadEmployee(employee);

	}

	public void loadEmployeeWithOutId(Employee employee) throws SQLException {

		employeeDAO.loadEmployeeWithOutId(employee);

	}

	public Employee getEmployeeById(int empNo) {
		return employeeDAO.getEmployeeById(empNo);
	}

	public void deleteEmployee(int empNo) {
		employeeDAO.deleteEmployee(empNo);
	}

	public List<Employee> getEmployees(int deptNo) throws SQLException {

		List<Employee> emp = new ArrayList<>();
		if (deptNo % 2 == 0) {
			emp = employeeDAO.getEmployees(deptNo, "DoB");
		} else {
			emp = employeeDAO.getEmployees(deptNo, "DoJ");
		}
		return emp;
	}

	public boolean updateEmployee(int empNo, Employee emp) {
		return employeeDAO.updateEmployee(empNo, emp);
	}

	public boolean authenticatingUser(String username, String password) {
		Credentials credential = new Credentials(username, password);
		if (new EmployeeUtil().getCredetials().contains(credential)) {
			return true;
		} else {
			return false;
		}
	}

	public Department getDepartment(int id) {
		Department dept1 = null;
		List<Department> deptList = new EmployeeUtil().getAllDepartments();
		for (Department department : deptList) {
			if (department.getId() == id) {
				return department;
			}
		}

		return dept1;
	}

}

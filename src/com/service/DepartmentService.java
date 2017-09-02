package com.service;

import java.util.List;

import com.daoImpl.DepartmentDaoImpl;
import com.entities.Employee;

public class DepartmentService {

	DepartmentDaoImpl deptDAO = new DepartmentDaoImpl();

	public Employee getEmployee(int empId) {

		return deptDAO.getEmployee(empId);

	}

	public List<Employee> getEmployeesByDeptId(int deptId) {
		return deptDAO.getEmployeesByDeptId(deptId);
	}

}

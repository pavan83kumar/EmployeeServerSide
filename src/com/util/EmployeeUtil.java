package com.util;

import java.util.ArrayList;
import java.util.List;

import com.entities.Department;

public class EmployeeUtil {

	public  List<Department> getAllDepartments() {

		// Creating Department Objects

		Department dept1 = new Department(1, "CS");
		Department dept2 = new Department(2, "CIS");
		Department dept3 = new Department(3, "IM");
		Department dept4 = new Department(4, "ME");

		List<Department> deptList = new ArrayList<>();
		deptList.add(dept1);
		deptList.add(dept2);
		deptList.add(dept3);
		deptList.add(dept4);

		return deptList;

	}

	public List<Credentials> getCredetials() {

		// Creating Credentials Objects

		Credentials cred1 = new Credentials("pavan", "pavan123");
		Credentials cred2 = new Credentials("sai", "sai123");
		Credentials cred3 = new Credentials("satheesh", "satheesh123");
		Credentials cred4 = new Credentials("santhosh", "santhosh123");

		List<Credentials> credList = new ArrayList<>();
		credList.add(cred1);
		credList.add(cred2);
		credList.add(cred3);
		credList.add(cred4);

		return credList;

	}

}

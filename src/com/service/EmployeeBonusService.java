package com.service;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.daoImpl.EmployeeBonusDaoImpl;
import com.entities.Bonus;
import com.entities.Employee;
import com.entities.EmployeeBonus;

public class EmployeeBonusService {

	BonusService bonusService = new BonusService();
	EmployeeService empService = new EmployeeService();
	EmployeeBonusDaoImpl bonusDaoImpl = new EmployeeBonusDaoImpl();

	public int getEmployeeBonus(int empSal, int empSalGrade) {
		int empBonus = 0;
		switch (empSalGrade) {
		case 1:
			empBonus = (int) (empSal * 0.1);
			break;
		case 2:
			empBonus = (int) (empSal * 0.15);
			break;
		case 3:
			empBonus = (int) (empSal * 0.2);
			break;
		case 4:
			empBonus = (int) (empSal * 0.25);
		}
		return empBonus;
	}

	public void allocateBonus() throws SQLException {
		List<Bonus> list = new ArrayList<>();
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		list = bonusService.getAllBonus();

		for (Bonus db : list) {

			List<Employee> emp = empService.getEmployees(db.getDeptNo());
			Thread t = new Thread() {
				public void run() {
					System.out.println(db.getDeptNo());
					for (Employee e : emp) {
						// System.out.println(e.getNumber());
						try {
							giveBonus(e);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}

				}

			};
			executorService.execute(t);
		}
		executorService.shutdown();
	}

	private void giveBonus(Employee e) throws SQLException {
		int bonus = getEmployeeBonus(e.getSalary(), e.getSalGrade());
		java.util.Date date = new java.util.Date();
		long ms = date.getDate();

		int remainingAmount = bonusService.getRemainingAmount(e.getDeptNumber());
		if (remainingAmount == 0) {

			setBonus(new EmployeeBonus(e.getNumber(), "INC", 0, new Date(ms)));
			bonusService.setRemainingAmount(0, e.getDeptNumber());
		} else if (remainingAmount >= bonus) {

			setBonus(new EmployeeBonus(e.getNumber(), "CMP", bonus, new Date(ms)));
			bonusService.setRemainingAmount(remainingAmount - bonus, e.getDeptNumber());
		} else {

			setBonus(new EmployeeBonus(e.getNumber(), "PAR", remainingAmount, new Date(ms)));
			bonusService.setRemainingAmount(0, e.getDeptNumber());
		}

	}

	public void setBonus(EmployeeBonus bonus) throws SQLException {
		bonusDaoImpl.setBonus(bonus);
	}

}

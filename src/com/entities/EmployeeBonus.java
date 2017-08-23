package com.entities;

import java.util.Date;

public class EmployeeBonus {
	private int number;
	private String status;
	private int amount;
	private Date dataAllocated;

	public EmployeeBonus(int number, String status, int amount, Date dataAllocated) {
		super();
		this.number = number;
		this.status = status;
		this.amount = amount;
		this.dataAllocated = dataAllocated;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDataAllocated() {
		return dataAllocated;
	}

	public void setDataAllocated(Date dataAllocated) {
		this.dataAllocated = dataAllocated;
	}
}

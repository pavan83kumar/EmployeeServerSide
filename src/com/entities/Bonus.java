package com.entities;

public class Bonus {

	@Override
	public String toString() {
		return "Bonus [deptNo=" + deptNo + ", amount=" + amount + ", remainingAmount=" + remainingAmount + "]";
	}

	private int deptNo;
	private int amount;
	private int remainingAmount;

	public Bonus(int deptNo, int amount, int remainingAmount) {
		super();
		this.deptNo = deptNo;
		this.amount = amount;
		this.remainingAmount = remainingAmount;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
}

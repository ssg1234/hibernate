package com.hexa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@Column(name="aid")
	private int accId;
	
	@Column(name="cname")
	private String custName;
	
	@Column(name="bal")
	private double bal;
	
	public Account() {
		
	}
	
	public Account(int accId, String custName, double bal) {
		super();
		this.accId = accId;
		this.custName = custName;
		this.bal = bal;
	}



	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		
		return accId + " " + custName + " " + bal;
	}
	
	
}

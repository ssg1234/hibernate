package com.hexa.entity;

public class Account {
	private int aid;
	private String cname;
	private double bal;
	
	//use by spring IOC for DI
	public Account(int aid, String cname, double bal) {
		this.aid = aid;
		this.cname = cname;
		this.bal = bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public int getAid() {
		return aid;
	}

	public String getCname() {
		return cname;
	}

	public double getBal() {
		return bal;
	}

	@Override
	public String toString() {
		return aid + " " + cname + " " +bal; 
	}
	
}

package com.hexa.entity;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class Interest {
	
	//@NotEmpty(message="amount is mandatory")
	@Min(value=1000, message="amount must be minimum 1000")
	private double amt;
	
	//@NotEmpty(message="years is mandatory")
	@Range(min=1, max=30, message="years must be between 1 and 30")
	private int years;
	
	//@NotEmpty(message="rate is mandatory")
	@Min(value=1, message="minimum value must be 1")
	private double rate;

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public int getYears() {
		return years;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
	
}

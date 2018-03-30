package com.hexa.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service("myser")
public class SerImpl implements ISer{
	@Value("${rate}")
	private double rate;
	@Override
	public double calcSimple(double amt, int years) {
		return amt * years * rate /100;
		
	}

	
}

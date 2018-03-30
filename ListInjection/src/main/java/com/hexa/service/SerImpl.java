package com.hexa.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SerImpl implements ISer{
	private List<String> fnames;
	
	//setter for Spring IOC to do DI
	public void setFnames(List<String> fnames) {
		this.fnames = fnames;
	}


	@Override
	public Set<String> getCities() {
		Set<String> set =new HashSet<String>();
		for(String fname:fnames) {
			set.addAll(readData(fname));
		}
		return set;
	}
	
	public List<String> readData(String fname){
		String str =null;
		List<String> lst= new ArrayList<String>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(fname))){
			while((str = br.readLine()) != null)
                lst.add(str);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lst;
	}
}


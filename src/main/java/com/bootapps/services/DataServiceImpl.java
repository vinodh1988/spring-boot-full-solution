package com.bootapps.services;

import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

	@Override
	public String[] getNames() {
		// TODO Auto-generated method stub
		String []names= {"Rohan","Jason","Nicholas","Arjun","Rishi","Victor"};
		return names;
	}

}

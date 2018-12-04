package com.se.dces.cmm.ducache.timestamp;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class TimeStamp {
	
	public double createTimeStamp() {
		Date date = new Date();
		return date.getTime();
	}
}

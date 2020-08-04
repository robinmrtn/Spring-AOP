package com.romart.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneService {

	public String getFortune() {

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Heavy traffic expected";
	}

	public String getFortune(boolean tripwire) {

		if (tripwire) {
			throw new RuntimeException("Traffic closed");
		}
		return getFortune();
	}

}

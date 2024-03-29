package com.xj.aop.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;
@Service
public class SpaPrincessA implements SPAService{
	
	private Random random = new Random();
	
	private int bound = 5;

	@Override
	public void fullBodyMassage(String customer) {
		try {
			TimeUnit.SECONDS.sleep(random.nextInt(bound));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(customer + "享受完fullBodyMassage服务！");
	}

	@Override
	public void aromaOilMassage(String customer) {
		try {
			TimeUnit.SECONDS.sleep(random.nextInt(bound));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(customer + "享受完aromaOilMassage服务！");
	}

	@Override
	public void rest() {
		try {
			TimeUnit.SECONDS.sleep(random.nextInt(bound));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("rest服务！");
	}

}

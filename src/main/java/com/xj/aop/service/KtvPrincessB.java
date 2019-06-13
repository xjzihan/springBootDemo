package com.xj.aop.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class KtvPrincessB implements KTVService {

	private Random random = new Random();

	private int bound = 5;

	@Override
	public void momoSing(String customer) {
		try {
			TimeUnit.SECONDS.sleep(random.nextInt(bound));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(customer + "享受完momoSing服务！");
	}

}

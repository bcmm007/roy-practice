package com.roy.thread;

public class MyRunnable implements Runnable {
	@Override
	/*
	 * FunctionID:R01
	 * Thread实现了Runnable接口，同时Thread的构造函数也可以传入Runnable的对象
	 */
	public void run() {
		System.out.println("运行中！");
	}
}

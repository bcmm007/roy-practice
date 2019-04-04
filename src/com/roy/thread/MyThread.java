package com.roy.thread;

public class MyThread extends Thread {
	//设置变量，用户测试各类共享等
	private int count = 5;
	public MyThread() {}
	//设置线程名称
	public MyThread(String threadName) {
		super();
		this.setName(threadName);
	}
    @Override
    /*
     * FunctionID:A01
     * 这是第一个测试方法
     */
//	public void run() {
//    	super.run();
//    	System.out.println("MyThread");
//    }
    /*
     *FunctionId:A02
     */
//    public void run() {
//    	for (int i=0;i<10;i++) {
//    	    int time = (int)(Math.random() * 1000);
//    	    try {
//				Thread.sleep(time);
//			} catch (InterruptedException e) {
//				System.out.println("Thead error");
//				break;
//			}
//    	    System.out.println("run=" + Thread.currentThread().getName());
//    	}
//    }
    /*
     * FunctionId:A03,A04
     * A04时，增加synchronized关键字
     */
//    public synchronized void run() {
//    	super.run();
//    	while (count > 0) {
//    		count--;
//    		System.out.println("由" + Thread.currentThread().getName() + "计算，count=" + count);
//    	}
//    }
    /*
     * FunctionId:A05
     */
//    public void run() {
//    	System.out.println("run方法的打印" + Thread.currentThread().getName());
//    }
    /*
     * FunctionId:A06
     */
//    public void run() {
//    	System.out.println("run=" + this.isAlive());
//    }
    /*
     * FunctionId:A07
     * sleep()
     * 让当前正在执行的线程，休眠指定的毫秒数
     */
//    public void run() {
//        System.out.println("run threadName=" + this.currentThread().getName() + " begin");
//        try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println("run threadName=" + this.currentThread().getName() + " end");
//    }
    /*
     * FunctionId:A08
     */
//    public void run() {
//      System.out.println("run threadName=" + this.currentThread().getName() + " begin " + System.currentTimeMillis());
//      try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//      System.out.println("run threadName=" + this.currentThread().getName() + " end " + System.currentTimeMillis());
//    }
    /*
     * FunctionId:A09
     * 停止线程:interrupt
     * stop,suspend,resume都已废弃过期，不安全
     */
//    public void run() {
//    	super.run();
//    	for (int i = 0; i< 15000; i++) {
//    		System.out.println("i = " + (i));
//    	}
//    }
    /*
     * FunctionId:A10
     * 停止线程
     */
//    public void run() {
//    	super.run();
//    	for (int i = 0; i < 15000; i++) {
//    		if (this.interrupted()) {
//    			System.out.println("已经是停止状态了！我要退出了！");
//    			break;
//    		}
//    		System.out.println("i=" + (i + 1));
//    	}
//    }
    /*
     * FunctionId:A11
     * 停止线程
     */
//    public void run() {
//	    super.run();
//	    for (int i = 0; i < 15000; i++) {
//		    if (this.interrupted()) {
//			    System.out.println("已经是停止状态了！我要退出了！");
//			    break;
//		    }
//		    System.out.println("i=" + (i + 1));
//	    }
//	    System.out.println("我被输出，是for循环之后继续执行，说明线程并未停止");
//    }
    /*
     * FunctionId:A12
     * 停止线程
     */
//    public void run() {
//	    super.run();
//	    try {
//	        for (int i = 0; i < 15000; i++) {
//		        if (this.interrupted()) {
//			        System.out.println("已经是停止状态了！我要退出了！");
//			        throw new InterruptedException();
//				}
//		        System.out.println("i=" + (i + 1));
//		    }
//	    } catch (InterruptedException e) {
//			System.out.println("进到了异常的catch中");
//			e.printStackTrace();
//		}
//	    System.out.println("我被输出，是for循环之后继续执行，说明线程并未停止");    	
//    }
    /*
     * FunctionId:A13
     * 在沉睡中停止
     */
//    public void run() {
//    	super.run();
//    	try {
//    		System.out.println("run begin");
//			Thread.sleep(200000);
//			System.out.println("run end");
//		} catch (InterruptedException e) {
//			System.out.println("在沉睡中被终止，进入catch");
//			e.printStackTrace();
//		}
//    }
    /*
     * FunctionId:A14
     * 先停止，再sleep
     */
    public void run() {
    	super.run();
    	try {
    		for (int i = 0;i < 10000;i++) {
    			System.out.println("i=" + (i+1));
    		}
		    System.out.println("run begin");
		    Thread.sleep(200000);
		    System.out.println("run end");
	    } catch (InterruptedException e) {
		    System.out.println("先停止，再遇到sleep！进入catch！");
		    e.printStackTrace();
	    }
    }
}

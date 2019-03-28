package com.roy.thread;

public class ActionThread {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * FunctionId:A01
		 * 运行结果："运行结束"先输出，"MyThread"后输出
		 * 说明：1.多线程时，代码的运行结果与代码的执行顺序或调用顺序是无关的
		 * 2.另外，start方法的执行顺序并不能严格代表线程的启动顺序，示例较简单，这里不掩饰了
		 */
//        MyThread myThread = new MyThread();
//        myThread.start();
//        System.out.println("运行结束！");
		/*
		 * FunctionId：A02
		 * 运行结果：main线程与myThread线程交替执行
		 */
//	    MyThread myThread = new MyThread();
//	    myThread.setName("myThread");
//	    //start方法是交由系统来调用
//	    myThread.start();
//	    //run是交由main来调用
//	    myThread.run();
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
		/*
		 * FunctionId:R01
		 */
//		Runnable runnale = new MyRunnable();
//		Thread thread = new Thread(runnale);
//		thread.start();
//		System.out.println("运行结束");
		/*
		 * FunctionId：A03
		 * 运行结果：count在A，B，C的各自线程中递减，互补影响
		 */
//		MyThread myThreadA = new MyThread("A");
//		MyThread myThreadB = new MyThread("B");
//		MyThread myThreadC = new MyThread("C");
//		myThreadA.start();
//		myThreadB.start();
//		myThreadC.start();
		/*
		 * FunctionId:A03,A04
		 * 运行结果：A和B同时计算出了3。测试A04的时候是顺序的，没有问题
		 * 说明：换了一种调用方式，共享myThread，变量是非线程安全的
		 */
//		MyThread myThread = new MyThread();
//		Thread myThreadA = new Thread(myThread,"A");
//		Thread myThreadB = new Thread(myThread,"B");
//		Thread myThreadC = new Thread(myThread,"C");
//		myThreadA.start();
//		myThreadB.start();
//		myThreadC.start();
		/*
		 * FunctionId:A05
		 * 注意MyThread类的构造方法中，增加打印当前线程名
		 * 运行结构：构造方法都是由main调用的。执行start时，是由Thead-0调用，run是由main调用
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		myThread.run();
		/*
		 * FunctionId:A06
		 * begin ==false end ==true run=true
         * 正在运行或准备开始运行，都是活动状态
         * end==true是因为还没结束，sleeep(1000)之后，end==false
		 */
//		MyThread myThread = new MyThread();
//		System.out.println("begin ==" + myThread.isAlive());
//		myThread.start();
//		Thread.sleep(1000);
//		System.out.println("end ==" + myThread.isAlive());
		/*
		 * FunctionId:A07
		 * 说明：直接调用了run方法，又main线程执行，是同步
		 * begin =1553731385636
         * run threadName=main begin
         * run threadName=main end
         * end =1553731387641
		 */
//		MyThread myThread = new MyThread();
//		System.out.println("begin =" + System.currentTimeMillis());
//		myThread.run();
//		System.out.println("end =" + System.currentTimeMillis());
		/*
		 * FunctionId:A08
		 * 说明：调用start方法，异步
		 * begin =1553731703521
         * end =1553731703522
         * run threadName=Thread-0 begin 1553731703522
         * run threadName=Thread-0 end 1553731705524
		 */
//		MyThread myThread = new MyThread();
//		System.out.println("begin =" + System.currentTimeMillis());
//		myThread.start();;
//		System.out.println("end =" + System.currentTimeMillis());
		/*
		 * FunctionId:M01
		 * 说明：getId() 获取线程唯一标识
		 * 输出：main 1
		 */
		Thread runThread = Thread.currentThread();
		System.out.println(runThread.getName() + " " + runThread.getId());
	}
}

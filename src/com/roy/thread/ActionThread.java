package com.roy.thread;

import org.omg.Messaging.SyncScopeHelper;

public class ActionThread {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * FunctionId：A01
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
		 * FunctionId：R01
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
		 * FunctionId：A03,A04
		 * 运行结果：A和B同时计算出了3。测试A04的时候是顺序的，没有问题
		 * 说明：换了一种调用方式，共享myThread，变量是非线程安全的
		 */
//      MyThread myThread = new MyThread();
//		Thread myThreadA = new Thread(myThread,"A");
//		Thread myThreadB = new Thread(myThread,"B");
//		Thread myThreadC = new Thread(myThread,"C");
//		myThreadA.start();
//		myThreadB.start();
//		myThreadC.start();
		
		/*
		 * FunctionId：A05
		 * 注意MyThread类的构造方法中，增加打印当前线程名
		 * 运行结构：构造方法都是由main调用的。执行start时，是由Thead-0调用，run是由main调用
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		myThread.run();
		
		/*
		 * FunctionId：A06
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
		 * FunctionId：A07
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
		 * FunctionId：A08
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
		 * FunctionId：M01
		 * 说明：getId() 获取线程唯一标识
		 * 输出：main 1
		 */
//		Thread runThread = Thread.currentThread();
//		System.out.println(runThread.getName() + " " + runThread.getId());
		
		/*
		 * FunctionId：A09
		 * 输出：0~14999
		 * interrupt方法只是向线程发出信号，提醒终止，由被中断的线程处理如何终止，因为在run方法中没有处理，所以没有终止
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		myThread.interrupt();
		
		/*
		 * FunctionId：A09
		 * 线程是否终止1 = false
         * 线程是否终止2 = false
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		Thread.sleep(80);
//		myThread.interrupt();
//		System.out.println("线程是否终止1 = " + myThread.interrupted());
//		System.out.println("线程是否终止2 = " + myThread.interrupted());
		
		/*
		 * FunctionId：A09
         * 线程是否终止1 = true
         * 线程是否终止2 = true
         * 说明：sleep是为了线程启动后，在中间位置中断，效果比较直观
         * isInterrupted：测试线程是否已经中断
         * 
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		Thread.sleep(80);
//		myThread.interrupt();
//		System.out.println("线程是否终止1 = " + myThread.isInterrupted());
//		System.out.println("线程是否终止2 = " + myThread.isInterrupted());
		
		/*
		 * FunctionId：M02
		 * interrupted：测试当前线程是否已经中断
		 * 调用该方法时，会同时清理中断状态
		 * 是否停止1 = true
         * 是否停止2 = false
		 */
//		Thread.currentThread().interrupt();
//		System.out.println("是否停止1 = " + Thread.interrupted());
//		System.out.println("是否停止2 = " + Thread.interrupted());
//		System.out.println("end!");
		
		/*
		 * FunctionId:A10
		 * 输出：在5906的时候停止，打印了停止提示文字，但是"end"也打印了，也就是for之后的语句继续执行了
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		Thread.sleep(50);
//		myThread.interrupt();
//		System.out.println("end");
		
		/*
		 * FunctionId:A11
		 * 输出：在5552的时候停止，打印了停止提示文字，"end"打印了，方法内for循环之后的文字也被打印了
		 * 说明：说明线程继续执行了
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		Thread.sleep(50);
//		myThread.interrupt();
//		System.out.println("end");
		
		/*
		 * FunctionId:A12
		 * 输出：在5552的时候停止，打印了停止提示文字，"end"打印了，方法内for循环之后的文字在异常中被打印
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		Thread.sleep(50);
//		myThread.interrupt();
//		System.out.println("end");
		
		/*
		 * FunctionId:A13
		 * 输出：如果在方法内处理异常，会打印begin，end，在沉睡中被终止。否则，只打印begin
		 */
//		try {
//		    MyThread myThread = new MyThread();
//		    myThread.start();
//		    Thread.sleep(200);
//		    myThread.interrupt();
//		} catch(InterruptedException e) {
//			System.out.println("main catch");
//			e.printStackTrace();
//		}
//		System.out.println("end!");
		
		/*
		 * FunctionId:A14
		 * 输出：先输出了end，然后打印数字，然后是run begin，最后进入了异常处理
		 * 说明：执行顺序，启动线程，开始数字打印，发出终止信号，线程中继续打印，数字打印结束，打印run beging，进入sleep，由于已收到了终止信号，sleep异常
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		myThread.interrupt();
//		System.out.println("end!");
		
		/*
		 * FunctionId:A15
		 * 输出：执行到i=8时停止了
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		Thread.sleep(8000);
//		myThread.stop();
		
		/*
		 * FunctionId:A16
		 * 输出：进入异常处理并终止了
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
		
		/*
		 * FunctionId:A17
		 * 输出：b aa 没有保证完整性
		 */
//		try {
//		    SynchronizedObject synObject = new SynchronizedObject();
//		    MyThread myThread = new MyThread(synObject);
//		    myThread.start();
//		    Thread.sleep(500);
//		    myThread.stop();
//		    System.out.println(synObject.getUserName() + " " + synObject.getPassWord());
//		}catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		
		/*
		 * FunctionId:A18
		 * 运行200ms后停止，但是多个return代码易混乱
		 */
//		MyThread myThread = new MyThread();
//		myThread.start();
//		Thread.sleep(200);
//		myThread.interrupt();
		
		/*
		 * FunctionId:A19
		 * 输出：
		 * aTime= 1556781909415 i= 337400273
		 * aTime= 1556781909917 i= 337400273
		 * bTime= 1556781910419 i= 666344923
		 * bTime= 1556781910920 i= 666344923
		 * 注意：最终线程只是暂定，别忘了手工停掉
		 */
//		MyThread myThread = new MyThread();
//		//启动与暂停
//		myThread.start();
//		Thread.sleep(500);
//		myThread.suspend();
//		System.out.println("aTime= " + System.currentTimeMillis() + " i= " + myThread.getI());
//		Thread.sleep(500);
//		System.out.println("aTime= " + System.currentTimeMillis() + " i= " + myThread.getI());
//	    
//		//恢复运行
//		myThread.resume();
//		Thread.sleep(500);
//		
//		//再次暂停
//		myThread.suspend();
//		System.out.println("bTime= " + System.currentTimeMillis() + " i= " + myThread.getI());
//		Thread.sleep(500);
//		System.out.println("bTime= " + System.currentTimeMillis() + " i= " + myThread.getI());
		
		/*
		 * FunctionId:A20
		 * 对应SynchronizedObject类中的A20
		 * suspend与resume方法的缺点，独占
		 * 输出：线程2调用的printStringRS方法不会被执行
		 * 注意：最终线程只是暂定，别忘了手工停掉
		 * 总结：Function19和Function20说明了，suspend以独占的方式暂停，不会释放资源，也无法实现同步
		 */
//		final SynchronizedObject synObject = new SynchronizedObject();
//		//创建个一个线程对象，同时重写run方法
//		Thread curThread1 = new Thread() {
//			@Override
//			public void run() {
//				synObject.printStringRS();
//			}
//		};
//		curThread1.setName("a");
//		curThread1.start();
//		Thread.sleep(1000);
//		
//		//创建第二个线程对象，同时重写run方法
//		Thread curThread2 = new Thread() {
//			@Override
//			public void run() {
//				System.out.println("thread2启动了，但进不了printStringRS方法！只打印一个begin");
//				System.out.println("因为printStringRS方法被a线程锁定并suspend暂停了");
//				synObject.printStringRS();
//			}
//		};
//		curThread2.start();
		
    /*
     * FunctionId:A21
     */
//	MyThread myThread = new MyThread();
//	myThread.start();
		
    /*
     * FunctionId:A22
     * 输出：a= 1378077113；b= 1375713105
     * 说明：也有b小的时候，cpu的随机性影响比较大
     */
//	ThreadA threadA = new ThreadA();
//	threadA.setPriority(5);
//	threadA.start();
//	
//	ThreadB threadB = new ThreadB();
//	threadB.setPriority(8);
//	threadB.start();
//	
//	Thread.sleep(2000);
//	threadA.stop();
//	threadB.stop();
//	
//	System.out.println("a= " + threadA.getCnt());
//	System.out.println("b= " + threadB.getCnt());
		
    /*
     * FunctionId:A23
     */
	MyThread myThread = new MyThread();
	myThread.setDaemon(true);
	myThread.start();
	Thread.sleep(5000);
	System.out.println("离开myThread就停止了");
	}
}

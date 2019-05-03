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
	
    /*
     * FunctionID:A01
     * 这是第一个测试方法
     */
//	@Override
//	public void run() {
//    	super.run();
//    	System.out.println("MyThread");
//    }
	
    /*
     *FunctionId:A02
     */
//    @Override
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
//    @Override
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
//    @Override
//    public void run() {
//    	System.out.println("run方法的打印" + Thread.currentThread().getName());
//    }
	
    /*
     * FunctionId:A06
     */
//    @Override
//    public void run() {
//    	System.out.println("run=" + this.isAlive());
//    }
	
    /*
     * FunctionId:A07
     * sleep()
     * 让当前正在执行的线程，休眠指定的毫秒数
     */
//    @Override
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
//    @Override
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
//    @Override
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
//    @Override
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
//    @Override
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
//    @Override
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
//    @Override
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
//    @Override
//    public void run() {
//    	super.run();
//    	try {
//    		for (int i = 0;i < 10000;i++) {
//    			System.out.println("i=" + (i+1));
//    		}
//		    System.out.println("run begin");
//		    Thread.sleep(200000);
//		    System.out.println("run end");
//	    } catch (InterruptedException e) {
//		    System.out.println("先停止，再遇到sleep！进入catch！");
//		    e.printStackTrace();
//	    }
//    }
	
    /*
     * FunctionId:A15
     * 已弃用的stop方法暴力停止
     */
//    @Override
//    public void run() {
//        int i = 0;
//        try {
//            while(true) {
//            	i++;
//            	System.out.println("i=" + i);
//            	Thread.sleep(1000);
//            }
//        }catch(InterruptedException e) {
//        	e.printStackTrace();
//        }
//    }
	
    /*
     * FunctionId:A16
     * 已弃用的stop()方法会抛出java.lang.ThreadDeath异常
     */
//    @Override
//    public void run() {
//    	try {
//    		this.stop();
//    	}catch(ThreadDeath e){
//    		System.out.println("进入了catch()方法");
//    		e.printStackTrace();
//    	}
//    }
	
    /*
     * FunctionId:A17
     * 提现强行释放所的不良后果
     */
//    private SynchronizedObject synObject;
//   
//    public MyThread(SynchronizedObject synObject) {
//    	super();
//    	this.synObject = synObject;
//    }
//    @Override
//    public void run() {
//    	synObject.printString("b", "bb");
//    }
	
    /*
     * FunctionId:A18
     * 使用return停止线程
     */
//	@Override
//	public void run() {
//		while(true) {
//			if(this.isInterrupted()) {
//				System.out.println("停止了!");
//				return;
//			}
//			System.out.println("timer=" + System.currentTimeMillis());
//		}
//	}
	
	/*
	 * FunctionId:A19
	 * 线程暂停与恢复suspend与resume方法(均已过期)
	 */
//	private long i = 0;
//	
//	public long getI() {
//		return i;
//	}
//	
//	public void setI() {
//		this.i = i;
//	}
//	
//	@Override
//	public void run() {
//	    while(true) {
//	    	i++;
//	    }
//	}
    
	/*
	 * FunctionId:A21
	 * yield：释放当前cpu的资源，再次获得的时间由cpu决定
	 * 有yield与无yield，运行时间会差数倍
	 */
//	@Override
//	public void run() {
//        long beginTime = System.currentTimeMillis();
//        int cnt = 0;
//        for(int i = 0;i < 5000000; i++) {
//        	Thread.yield();
//        	cnt = cnt + (i + 1);
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("用时 " + (endTime - beginTime) + "毫秒!");
//	}
	
    /*
	 * FunctionId:A23
	 * setDaemon：将线程设置成守护线程
	 */
	private int i = 0;
	@Override
	public void run() {
		try {
            while(true) {
        	    i++;
        	    System.out.println("i= " + i);
			    Thread.sleep(1000);
            }
		}catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}

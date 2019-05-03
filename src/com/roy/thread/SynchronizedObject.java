package com.roy.thread;

public class SynchronizedObject {
	private String userName = "a";
	private String passWord = "aa";
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
    synchronized public void printString(String userName,String passWord) {
    	try {
    		this.userName = userName;
    		Thread.sleep(10000);
    		this.passWord = passWord;
    	}catch(InterruptedException e) {
    		e.printStackTrace();
    	}
    }
    /*
     * FunctionId:A20
     */
    synchronized public void printStringRS() {
    	System.out.println("begin");
    	if(Thread.currentThread().getName().equals("a")) {
    		System.out.println("a线程永远suspend了!");
    		Thread.currentThread().suspend();
    	}
    	System.out.println("end");
    }
}

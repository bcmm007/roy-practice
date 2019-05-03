package com.roy.thread;

public class ThreadB extends Thread {
    private int cnt = 0;
    
    public int getCnt() {
    	return cnt; 
    }
    
    @Override
    public void run() {
    	while(true) {
    		cnt++;
    	}
    }
}

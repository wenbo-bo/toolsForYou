package com.easygo.sample.bean;

public class FileReceiveTest{//接收方
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReceiveFileThread rf=new ReceiveFileThread();
		rf.start();
	}
	
}
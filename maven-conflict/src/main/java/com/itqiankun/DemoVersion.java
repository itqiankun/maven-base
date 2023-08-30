package com.itqiankun;

/**
 * @author: ma_qiankun
 * @date: 2023/8/30
 **/
public class DemoVersion {


	public String name = "itqiankun.com";

	public void consoleName(){
		System.out.println("输出结果:"+name);
	}
	public void consoleNameTwo(){
		System.out.println("输出第二个版本结果:"+name);
	}

	public static void main(String[] args) {
		DemoVersion demoVersion = new DemoVersion();
		demoVersion.consoleName();
	}
}

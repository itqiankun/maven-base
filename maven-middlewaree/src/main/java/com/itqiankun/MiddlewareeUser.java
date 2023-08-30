package com.itqiankun;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author: ma_qiankun
 * @date: 2023/8/30
 **/
@Slf4j
public class MiddlewareeUser {

	@Test
	public void it_qk_middlewaree_user_consoleNameTwo(){
		MyClassLoaderCustom myClassLoaderCustom = new MyClassLoaderCustom(Thread.currentThread().getContextClassLoader().getParent());
		Class testAClass;
		try {
			testAClass = myClassLoaderCustom.loadClass("DemoVersion-2.0-SNAPSHOT");
			Method mainMethod = testAClass.getDeclaredMethod("consoleNameTwo");
			Object o = testAClass.newInstance();
			mainMethod.invoke(o);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

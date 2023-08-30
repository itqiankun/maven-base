package com.itqiankun;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author: ma_qiankun
 * @date: 2023/8/30
 **/
@Slf4j
public class MiddlewareUser {

	@Test
	public void it_qk_middleware_user(){
		MyClassLoaderCustom myClassLoaderCustom = new MyClassLoaderCustom(Thread.currentThread().getContextClassLoader().getParent());
		Class testAClass = null;
		try {
			testAClass = myClassLoaderCustom.loadClass("DemoVersion-1.0-SNAPSHOT");
			Method mainMethod = testAClass.getDeclaredMethod("consoleName");
			Object o = testAClass.newInstance();
			mainMethod.invoke(o);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

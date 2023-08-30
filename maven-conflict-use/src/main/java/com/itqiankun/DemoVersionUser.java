package com.itqiankun;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: ma_qiankun
 * @date: 2023/8/30
 **/
@Slf4j
public class DemoVersionUser {
	@Test
	public void it_qk_middleware_user_consoleName(){
		MiddlewareUser middlewareUser = new MiddlewareUser();
		middlewareUser.it_qk_middleware_user();
	}

	@Test
	public void it_qk_middleware_user_consoleNameTwo(){
		MiddlewareeUser middlewareeUser = new MiddlewareeUser();
		middlewareeUser.it_qk_middlewaree_user_consoleNameTwo();
	}
}

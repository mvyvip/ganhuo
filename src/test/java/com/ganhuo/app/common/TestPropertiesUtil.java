package com.ganhuo.app.common;

import org.junit.Test;

import com.ganhuo.app.com.util.PropertiesUtil;

public class TestPropertiesUtil {
	@Test
	public void testUtil() {
		System.out.println(PropertiesUtil.getInstance().load("jdbc"));
	}
}

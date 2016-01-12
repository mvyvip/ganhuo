package com.ganhuo.app.common.utils;

import org.apache.log4j.Logger;
import org.apache.shiro.crypto.hash.Md5Hash;

public class StringUtil {
	private Logger logger = Logger.getLogger(StringUtil.class);
	
	private StringUtil() {}
	
	public static boolean isNotNull(String s) {
		if(s == null || "".equals(s.trim())) {
			return false;
		}
		return true;
	}
	
	public static boolean isNotNull(String ...s) {
		for (String ss : s) {
			if(ss == null || "".equals(ss)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isNull(String s) {
		if(s == null || "".equals(s.trim())) {
			return true;
		}
		return false;
	}

	public static String getMD5Shiro(String str) {
		if (StringUtil.isNull(str)) {
			return "";
		}
		return new Md5Hash(str).toHex();
	}
}

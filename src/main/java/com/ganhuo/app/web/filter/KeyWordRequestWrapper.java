package com.ganhuo.app.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;

import com.ganhuo.app.common.pool.KeywordPool;


public class KeyWordRequestWrapper extends HttpServletRequestWrapper{
	public KeyWordRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String[] getParameterValues(String name) {
		String[] values = super.getParameterValues(name);
		if(values == null || values.length == 0) {
			return values;
		}
		for (int i = 0; i < values.length; i++) {
			values[i] = replaceParam(values[i]);
		}
		return values;
	}

	/**
	 * 字符比对和替换
	 * 
	 * @param str
	 *            要检查的参数
	 * @return 返回修改后的参数
	 */
	private String replaceParam(String str) {
		if(StringUtils.isEmpty(str)) {
			return str;
		}
		for (String key : KeywordPool.keys) {
			if(str.contains(key)) {
				return str.replaceAll(key, genStr(key.length()));
			}
		}
		return str;
	}

	/**
	 * 生成指定长度的 "*" "*"可以根据配置类(ConstantPool)读取
	 */
	private String genStr(int length) {
		String s = "";
		for (int i = 0; i < length; i++) {
			s += "*";
		}
		return s;
	}
	
}

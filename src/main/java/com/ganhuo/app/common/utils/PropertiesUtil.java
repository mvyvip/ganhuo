package com.ganhuo.app.common.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



/**
 * <h2>读取指定路径下的Properties文件</h2>
 * <dl>
 * <dt>功能描述</dt>
 * <dd>无</dd>
 * <dt>使用规范</dt>
 * <dd>无</dd>
 * </dl>
 * @version V1.0
 * @date 2016年1月8日 下午5:03:25 
 * @author lt
 */
public class PropertiesUtil {
	
	/**
	 * 实例对象
	 */
	private static PropertiesUtil util = null;
	
	/**
	 * 所有的properties文件
	 */
	private static Map<String,Properties> props = null;
	
	public static PropertiesUtil getInstance() {
		if (util == null) {
			synchronized (PropertiesUtil.class) {
				if (util == null) {
					props = new HashMap<String, Properties>();
					util = new PropertiesUtil();
				}
			}
		}
		return util;
	}
	
	public Properties load(String name) {
		if (props.get(name) != null) {
			return props.get(name);
		} else {
			Properties properties = new Properties();
			try {
				properties.load(PropertiesUtil.class.getResourceAsStream("/" + name + ".properties"));
				props.put(name, properties);
				return properties;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}

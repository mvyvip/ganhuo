package com.ganhuo.app.common.utils;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ganhuo.app.common.pool.ConstantPool;


/**
 * <h2>针对HTTP常用操作做方法封装，具体可看每个方法上的注释</h2>
 * <dl>
 * <dt>功能描述</dt>
 * <dd>无</dd>
 * <dt>使用规范</dt>
 * <dd>在本类中添加新方法前仔细对比不要弄重复了，作为工具类建议每个方法都为static，这样可避免new太多的实例造成 内存紧张。</dd>
 * </dl>
 * @version V1.0
 * @date 2016年1月12日 上午10:15:33 
 * @author lt
 */
public class HttpUtil {
	
	Logger logger = Logger.getLogger(HttpUtil.class);
	
	private HttpUtil() {}
	
	
	 /**
	  * 得到session中的值
	  * @param session
	  * @param key
	  * @param obj
	  * @version v1.0
	  * @author lt
	  * @date 2016年1月12日 上午10:46:22
	  */
	public static String getSession(HttpSession session,String name) {
		if(StringUtil.isNotNull(name) && session.getAttribute(name) != null) {
			return session.getAttribute(name).toString();
		}
		return "";
	}
	
	 /**
	  * 把值放到session会话中
	  * @param session
	  * @param key
	  * @param obj
	  * @version v1.0
	  * @author lt
	  * @date 2016年1月12日 上午10:46:22
	  */
	public static void setSession(HttpSession session, String key, Object obj) {
		if (StringUtil.isNotNull(key) && obj != null) {
			session.setAttribute(key, obj);
		}
	}
	
	 /**
	  * 删除session会话中
	  * @param session
	  * @param key
	  * @version v1.0
	  * @author lt
	  * @date 2016年1月12日 上午10:46:22
	  */
	public static void delSession(HttpSession session, String key) {
		if (StringUtil.isNotNull(key)) {
			session.removeAttribute(key);
		}
	}
	
	public static String getToken(HttpSession session) {
		String token = StringUtil.getMD5Shiro(UUID.randomUUID().toString());
		HttpUtil.setSession(session, ConstantPool.SESSION_TOKEN, token);
		return token;
	}
}

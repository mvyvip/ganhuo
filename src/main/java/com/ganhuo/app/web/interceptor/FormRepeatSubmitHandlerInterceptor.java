package com.ganhuo.app.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ganhuo.app.common.pool.ConstantPool;
import com.ganhuo.app.common.utils.HttpUtil;
import com.ganhuo.app.common.utils.StringUtil;


/**
 * <h2>表单重复提交拦截器</h2>
 * <dl>
 * <dt>功能描述</dt>
 * <dd>防止表单重复提交</dd>
 * <dt>使用规范</dt>
 * <dd>
 * 	防止重复提交（根据页面标识选择性拦截） 如果你需要在表单提交时做重复提交拦截，那么请在表单里面隐藏 一个字段放token的值。 
 * 	<input type="hidden" name="request_token" value="<%=HttpUtil.getToken(session)%>">
 * </dd>
 * </dl>
 * @version V1.0
 * @date 2016年1月12日 上午10:56:17 
 * @author lt
 */
public class FormRepeatSubmitHandlerInterceptor implements HandlerInterceptor {

	private Logger logger = Logger.getLogger(FormRepeatSubmitHandlerInterceptor.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 * 方法执行之前运行，如果返回true，[首先运行controller,在方法运行完毕后继续运行postHandle，最后运行afterCompletion],返回false直接退出
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("request_path => " + request.getRequestURI() + " | parameter => " + request.getQueryString());
		System.out.println(request.getRequestURI());
		// 得到请求token值
		String request_token = request.getParameter(ConstantPool.REQUEST_TOKEN);
		// 取出session中的token
		String session_token = HttpUtil.getSession(request.getSession(), ConstantPool.SESSION_TOKEN);
		if(StringUtil.isNotNull(request_token,session_token)) {
			// 如果相同第一次就是提交，清空session
			if(request_token.equals(session_token)) {
				HttpUtil.delSession(request.getSession(), ConstantPool.SESSION_TOKEN);
				return true;
			}else {
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}

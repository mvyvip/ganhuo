package com.ganhuo.app.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * <h2>特殊字符请求过滤器</h2>
 * <dl>
 * <dt>功能描述</dt>
 * <dd>过滤替换特殊敏感字符</dd>
 * <dt>使用规范</dt>
 * <dd>无</dd>
 * </dl>
 * @version V1.0
 * @date 2016年1月8日 下午5:15:47 
 * @author lt
 */
public class CharacterReplaceFilter implements Filter{
	
	private final static Logger log = Logger.getLogger(CharacterReplaceFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("CharacterReplaceFilter.init()");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String method = request.getMethod();
		if("PUT".equalsIgnoreCase(method) || "POST".equalsIgnoreCase(method)|| "GET".equalsIgnoreCase(method)) {
			log.debug("next CharacterReplaceFilter=>");
			KeyWordRequestWrapper wrapper = new KeyWordRequestWrapper(request);
			filterChain.doFilter(wrapper, response);
		}else {
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		log.debug("CharacterReplaceFilter.destroy()");
	}
	
}

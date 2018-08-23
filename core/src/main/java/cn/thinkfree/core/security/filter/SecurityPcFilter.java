package cn.thinkfree.core.security.filter;


import cn.thinkfree.core.bundle.MyRespBundle;
import cn.thinkfree.core.security.filter.util.SecurityConstants;
import cn.thinkfree.core.security.filter.util.SecurityRequestUtil;
import cn.thinkfree.core.security.filter.util.SessionUserDetailsUtil;
import cn.thinkfree.core.utils.VersionUtil;
import com.google.gson.Gson;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;


/**
 * 权限拦截器
 * 
 */
 public class SecurityPcFilter extends AbstractSecurityInterceptor implements Filter {

	private FilterInvocationSecurityMetadataSource securityMetadataSource;

 
	/**  
	 * 如果为APP用户则不进行拦截 直接放行
	 * 如果为PC用户则进行权限与路径效验
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获取拦截请求
		HttpServletRequest httpRequest = (HttpServletRequest)request;
//		HttpServletResponse httpResponse = (HttpServletResponse)response;
		String url = httpRequest.getRequestURI().replaceFirst(httpRequest.getContextPath(), "");

		logger.info("拦截请求：" + url);
		//	 判断登陆状态：如果未登陆则要求登陆
//		if(!SessionUserDetailsUtil.isLogined()) {
//			if (SecurityRequestUtil.isAjax(httpRequest)) {
////				httpResponse.getOutputStream().print("<script >alert('认证失效,重新登录!');window.location.href='/'</script>");
//			} else {
//				httpResponse.sendRedirect(httpRequest.getContextPath() + SecurityConstants.LOGIN_PAGE);
//			}
//			logger.info("未登陆用户，From IP:" + SecurityRequestUtil.getRequestIp(httpRequest) + "访问 ：URI" + url);
//			return;
//    	}

		//	 过资源(URL)白名单：如果为公共页面，直接执行
//		if(SecurityMetadataSourceTrustListHolder.isTrustSecurityMetadataSource(url)){
//			chain.doFilter(request, response);
//			return;
//		}

		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);
	}



	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	public void invoke(FilterInvocation fi) throws IOException, ServletException {
		InterceptorStatusToken token = null;
 		try {
			token = super.beforeInvocation(fi);
		} catch (AccessDeniedException |  IllegalArgumentException e) {
			HttpServletRequest httpRequest = fi.getRequest();
			HttpServletResponse httpResponse = fi.getResponse();
			String url = httpRequest.getRequestURI().replaceFirst(httpRequest.getContextPath(), "");
			logger.info("用户 " + SessionUserDetailsUtil.getLoginUserName() + "，From IP:" + SecurityRequestUtil.getRequestIp(httpRequest) + "。尝试访问未授权(或者) URI:" + url);
//			if (SecurityRequestUtil.isAjax(httpRequest)) {
				MyRespBundle<String> myRespBundle =buildErrorResp();
				httpResponse.setHeader("Content-Type","application/json; charset=utf-8");
				httpResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
				httpResponse.getWriter().write(new Gson().toJson(myRespBundle));
//			} else {
//				httpResponse.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
//				RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(SecurityConstants.NOT_ACCEPTABLE);
//				dispatcher.forward(httpRequest, httpResponse);
//			}

			return;
		}
		
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}

	private MyRespBundle<String> buildErrorResp() {
		MyRespBundle<String> myRespBundle = new MyRespBundle<>();
		myRespBundle.setCode(HttpServletResponse.SC_NOT_ACCEPTABLE);
		myRespBundle.setMessage("无权访问");
		myRespBundle.setVersion(VersionUtil.getVersion());
		myRespBundle.setTimestamp(Instant.now().toEpochMilli());
		return myRespBundle;

	}

	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}


	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource) {
		this.securityMetadataSource = newSource;
	}

	@Override
	public void destroy() {
		logger.info("完了！！自定义安全链坏了！！！！");
	}

	@Override
	public void init(FilterConfig fiter)   {
		logger.info("自定义安全链启动！！！！");
	}

}
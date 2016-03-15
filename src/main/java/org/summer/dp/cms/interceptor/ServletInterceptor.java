package org.summer.dp.cms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ServletInterceptor extends HandlerInterceptorAdapter {  

    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	/**
    	 * 暂时允许跨域访问
    	 */
    	response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");  
        response.setHeader("Access-Control-Allow-Methods", "GET");  
        response.setHeader("Allow", "GET");  
        return true;  
    }  

}  
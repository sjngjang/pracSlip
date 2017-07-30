package net.sj.slipp.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class WebAppCustomIntercepter implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods",
			        "GET, POST, PUT, DELETE, OPTIONS");
			return true;
	}
	
	@Override
	 public void postHandle(HttpServletRequest request, HttpServletResponse response,
	   Object object, ModelAndView modelAndView) throws Exception {

	 }
	
	@Override
	 public void afterCompletion(HttpServletRequest request,
	   HttpServletResponse response, Object object, Exception exception)
	   throws Exception {

	 }
}

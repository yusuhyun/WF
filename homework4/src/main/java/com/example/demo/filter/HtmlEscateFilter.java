//package com.example.demo.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//
//import com.example.demo.controller.HTMLCharacterEscapes;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@WebFilter("/*")
//public class HtmlEscateFilter implements Filter {
//	
//	public HtmlEscateFilter() {
//		System.out.println("HtmlEscateFilter 실행");
//	}
//	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//		System.out.println("HtmlEscateFilter 이건뭐지");
//		HttpServletRequest req = (HttpServletRequest)request;
//		HTMLCharacterEscapes hce = new HTMLCharacterEscapes(req);
//		//chain.doFilter(hce, response);
//	}
//	
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		Filter.super.destroy();
//	}
//}

//package com.example.demo.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Component;
//
//@WebFilter(filterName = "xssFilter", urlPatterns = "/*", asyncSupported = true)
//@Component
//public class XssFilter implements Filter {
//	
//	@Override
//    public void destroy() {
//        // TODO Auto-generated method stub
// 
//    }
// 
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        // TODO Auto-generated method stub
//        HttpServletRequest req = (HttpServletRequest) request;
//        XssHttpServletRequestWrapper xssRequestWrapper = new XssHttpServletRequestWrapper(req);
//        chain.doFilter(xssRequestWrapper, response);
//    }
// 
//    @Override
//    public void init(FilterConfig arg0) throws ServletException {
//        // TODO Auto-generated method stub
//    }
//	
//}

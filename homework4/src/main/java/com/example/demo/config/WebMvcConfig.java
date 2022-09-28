//package com.example.demo.config;
//
//import java.util.List;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.example.demo.controller.HTMLCharacterEscapes;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//@EnableWebMvc
//public class WebMvcConfig implements WebMvcConfigurer {
//	
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		 converters.add(htmlEscapingConverter());
//	}
//	
//	 private HttpMessageConverter<?> htmlEscapingConverter() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.getFactory().setCharacterEscapes(new HTMLCharacterEscapes());
//
//        return new MappingJackson2HttpMessageConverter(objectMapper);
//    }
//
//}

//package com.example.demo.config;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
//
//import com.example.demo.controller.HTMLEscapes;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurationSupport {
//	
//	
//	
//	
//	
//	 
////	@Override
////    public void addViewControllers(ViewControllerRegistry registry) {
////        registry.addRedirectViewController("/*", "index.html");
////    }
//	
//	@Override
//	protected void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/library").setViewName("forward:index.html");
//	    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//		super.addViewControllers(registry);
//	}
////	
////	@Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
////    }
//	
//	@Bean
//	public HttpMessageConverter<?> htmlEscapingConverter() {
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.getFactory().setCharacterEscapes(new HTMLEscapes()); // 
////		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
////		objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//
//		MappingJackson2HttpMessageConverter htmlEscapingConverter =
//				new MappingJackson2HttpMessageConverter();
//		htmlEscapingConverter.setObjectMapper(objectMapper);
//
//		return htmlEscapingConverter;
//	}
//
//	@Override
//	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(htmlEscapingConverter());
//		super.addDefaultHttpMessageConverters(converters);  // default Http Message Converter  추가
//	}
//	
//	
////	@Bean
////    public MappingJackson2HttpMessageConverter jsonEscapeConverter() {
////        ObjectMapper objectMapper = new ObjectMapper();
////        objectMapper.getFactory().setCharacterEscapes(new HTMLEscapes());
////        return new MappingJackson2HttpMessageConverter(objectMapper);
////    }
//
////	@Override
////    protected void extendMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
////        ListIterator<HttpMessageConverter<?>> listIterator = messageConverters.listIterator();
////        while(listIterator.hasNext()) {
////            HttpMessageConverter<?> next = listIterator.next();
////            if(next instanceof MappingJackson2HttpMessageConverter) {
////                listIterator.remove();
////                break;
////            }
////        }
////        messageConverters.add(getMappingJackson2HttpMessageConverter());
////
////    }
////
////    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
////    	
////        SimpleModule module = new SimpleModule();
////        module.addDeserializer(String.class, new JsonHtmlXssDeserializer1(String.class));
////        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().applicationContext(this.getApplicationContext()).build();
////        objectMapper.registerModule(module);
////        
////        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
////        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
////        
////        List<MediaType> list = new ArrayList<>();
////        list.add(MediaType.APPLICATION_JSON_UTF8);
////        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
////        return mappingJackson2HttpMessageConverter;
////    }
////
////}
////
////class JsonHtmlXssDeserializer1 extends JsonDeserializer<String> {
////
////    public JsonHtmlXssDeserializer1(Class<String> string) {
////        super();
////    }
////
////    @Override
////    public Class<String> handledType() {
////        return String.class;
////    }
////
////    @Override
////    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
////        String value = jsonParser.getValueAsString();
////        if (value != null) {
////            return StringEscapeUtils.escapeHtml4(value.toString());
////        }
////        return value;
////    }
//	
//	
//}

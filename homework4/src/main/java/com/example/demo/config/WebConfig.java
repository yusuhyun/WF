//package com.example.demo.config;
//
//import java.io.IOException;
//
//import org.apache.commons.text.StringEscapeUtils;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.module.SimpleModule;
//
//public class WebConfig implements WebMvcConfigurer, InitializingBean{
//	
//
//        @Autowired(required = false)
//        private ObjectMapper objectMapper;
//
//        private SimpleModule getSimpleModule() {
//            SimpleModule simpleModule = new SimpleModule();
//            simpleModule.addDeserializer(String.class, new JsonHtmlXssDeserializer(String.class));
//            return simpleModule;
//        }
//
//    @Override
//        public void afterPropertiesSet() throws Exception {
//            if (objectMapper != null) {
//                SimpleModule simpleModule = getSimpleModule();
//                objectMapper.registerModule(simpleModule);
//            }
//        }
//    }
//
//class JsonHtmlXssDeserializer extends JsonDeserializer<String> {
//
//    public JsonHtmlXssDeserializer(Class<String> string) {
//        super();
//    }
//
//    @Override
//    public Class<String> handledType() {
//        return String.class;
//    }
//
//    @Override
//    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//        String value = jsonParser.getValueAsString();
//        if (value != null) {
//            return StringEscapeUtils.escapeHtml4(value.toString());
//        }
//        return value;
//    }
//}
//

package com.example.infrastructure._configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.time.format.DateTimeFormatter;

public class CustomObjectMapper {

    public static ObjectMapper objectMapper() {
        return SingletonHolder.INSTANCE.objectMapper;
    }

    private static class SingletonHolder {
        private static final CustomObjectMapper INSTANCE = new CustomObjectMapper();
    }

    ObjectMapper objectMapper;

    private CustomObjectMapper() {
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.NON_PRIVATE);
        objectMapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(new LocalDateSerializer(DateTimeFormatter.ISO_DATE));
        module.addSerializer(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        objectMapper.registerModule(module);
    }
}

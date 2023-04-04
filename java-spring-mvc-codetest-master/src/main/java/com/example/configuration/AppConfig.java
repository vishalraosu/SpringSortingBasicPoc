package com.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Configuration
public class AppConfig {

    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setUseIsoFormat(true);
        registrar.setDateFormatter(DateTimeFormatter.ISO_LOCAL_DATE);
        registrar.setTimeFormatter(DateTimeFormatter.ISO_TIME);
        registrar.registerFormatters(registry);

        registry.addConverter(String.class, ZonedDateTime.class, source -> {
            try {
                return ZonedDateTime.parse(source, DateTimeFormatter.ISO_DATE_TIME);
            } catch (DateTimeParseException e) {
                return null;
            }
        });
    }

}

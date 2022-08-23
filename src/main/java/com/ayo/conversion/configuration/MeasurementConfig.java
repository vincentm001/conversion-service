package com.ayo.conversion.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "conversion")
@Getter
@Setter
public class MeasurementConfig {
    private Map<String, String> measurement;

    public static class Measurement{
        private String key;
        private String value;
    }
}

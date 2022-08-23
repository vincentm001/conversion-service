package com.ayo.conversion.model.temperature;

import com.ayo.conversion.model.temperature.TemperatureScale;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class TemperatureResponse {

    private double convertedValue;
    private TemperatureScale from;
    private TemperatureScale to;
}

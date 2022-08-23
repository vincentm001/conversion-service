package com.ayo.conversion.model.temperature;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Temperature {

    private double conversionValue;
    private TemperatureScale from;
    private TemperatureScale to;
}

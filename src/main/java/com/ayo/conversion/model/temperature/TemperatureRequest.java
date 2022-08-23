package com.ayo.conversion.model.temperature;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@Builder
@ToString
public class TemperatureRequest {

    @NotNull(message = "conversionValue is a required field")
    private double conversionValue;
    @NotNull(message = "from is a required field")
    private TemperatureScale from;
    @NotNull(message = "to is a required field")
    private TemperatureScale to;
}

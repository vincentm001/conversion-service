package com.ayo.conversion.model.distance;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LengthResponse {
    private double convertedValue;
    private LengthScale from;
    private LengthScale to;
}

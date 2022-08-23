package com.ayo.conversion.model.distance;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Length {
    private double conversionValue;
    private LengthScale from;
    private LengthScale to;
}

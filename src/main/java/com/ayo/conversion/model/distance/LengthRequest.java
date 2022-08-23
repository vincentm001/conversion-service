package com.ayo.conversion.model.distance;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class LengthRequest {

    private double conversionValue;
    private LengthScale from;
    private LengthScale to;
}

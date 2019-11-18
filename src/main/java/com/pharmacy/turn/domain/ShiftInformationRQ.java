package com.pharmacy.turn.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ShiftInformationRQ implements Serializable {
    private static final long serialVersionUID = 5212705982833197538L;

    @JsonProperty("region_id")
    private String regionId;
    
    private Filter filter;
    
}
